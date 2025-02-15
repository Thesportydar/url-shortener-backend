package me.inaqui.urlshortener.repository;

import me.inaqui.urlshortener.entity.Redirect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RedirectRepository extends JpaRepository<Redirect, Long> {
    boolean existsByAlias(String alias);

    Optional<Redirect> findByAlias(String alias);
}
