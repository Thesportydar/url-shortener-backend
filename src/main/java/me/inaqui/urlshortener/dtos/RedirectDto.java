package me.inaqui.urlshortener.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RedirectDto {

    private String shortUrl;
    private String longUrl;

}
