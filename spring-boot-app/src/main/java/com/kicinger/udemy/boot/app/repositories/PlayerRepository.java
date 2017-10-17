package com.kicinger.udemy.boot.app.repositories;

import com.kicinger.udemy.boot.app.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(
        path = "players",
        rel = "players"
)
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
