package me.inaqui.urlshortener.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@Data
public class RedirectCreateRequest {

    private String alias;
    @NotNull
    @URL
    private String longUrl;

}
