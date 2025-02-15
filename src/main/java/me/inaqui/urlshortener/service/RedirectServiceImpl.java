package me.inaqui.urlshortener.service;

import lombok.RequiredArgsConstructor;
import me.inaqui.urlshortener.dtos.RedirectDto;
import me.inaqui.urlshortener.entity.Redirect;
import me.inaqui.urlshortener.exception.ConflictException;
import me.inaqui.urlshortener.exception.NotFoundException;
import me.inaqui.urlshortener.repository.RedirectRepository;
import me.inaqui.urlshortener.request.RedirectCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedirectServiceImpl implements RedirectService {

    private final RedirectRepository redirectRepository;
    @Value("${url_prefix}")
    private String urlPrefix;

    private final SecureRandom random = new SecureRandom();
    private static final int MAX_RETRIES = 6;

    private String generateRandomAlias() {
        byte[] bytes = new byte[6];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes).substring(0, 6);
    }

    private String generateUniqueAlias() {
        String alias;
        int retries = 0;
        do {
            alias = generateRandomAlias();
            retries++;
            if(retries > MAX_RETRIES) {
                throw new ConflictException("Could not generate alias. Try again.");
            }
        } while(redirectRepository.existsByAlias(alias));
        return alias;
    }

    @Override
    public RedirectDto createRedirect(RedirectCreateRequest request) {

        if(request.getAlias() != null && redirectRepository.existsByAlias(request.getAlias())) {
            throw new ConflictException(
                    String.format("Alias %s already exists", request.getAlias())
            );
        }

        Redirect redirect = new Redirect();
        redirect.setLongUrl(request.getLongUrl());

        if(request.getAlias() != null) {
            redirect.setAlias(request.getAlias());
        } else {
            redirect.setAlias(generateUniqueAlias());
        }

        redirectRepository.save(redirect);

        RedirectDto dto = new RedirectDto();
        dto.setLongUrl(redirect.getLongUrl());
        dto.setShortUrl(String.format("%s/%s", urlPrefix, redirect.getAlias()));

        return dto;
    }

    @Override
    public Redirect getRedirect(String alias) {
        return redirectRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException(String.format("Alias %s not found", alias)));
    }
}
