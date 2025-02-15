package me.inaqui.urlshortener.service;

import me.inaqui.urlshortener.dtos.RedirectDto;
import me.inaqui.urlshortener.entity.Redirect;
import me.inaqui.urlshortener.request.RedirectCreateRequest;

import java.util.Optional;

public interface RedirectService {

    public RedirectDto createRedirect(RedirectCreateRequest request);

    public Redirect getRedirect(String alias);

}
