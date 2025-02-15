package me.inaqui.urlshortener.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.inaqui.urlshortener.dtos.RedirectDto;
import me.inaqui.urlshortener.entity.Redirect;
import me.inaqui.urlshortener.request.RedirectCreateRequest;
import me.inaqui.urlshortener.service.RedirectService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4321")
public class RedirectController {

    private final RedirectService redirectService;

    @GetMapping("/{alias:[a-zA-Z0-9]{6,15}}")
    public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException {
        Redirect redirect = redirectService.getRedirect(alias);
        URI uri = new URI(redirect.getLongUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/api")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreateRequest request) {
        RedirectDto redirect = redirectService.createRedirect(request);
        return ResponseEntity.ok().body(redirect);
    }
}
