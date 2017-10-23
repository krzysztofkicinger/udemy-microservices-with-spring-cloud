package com.kicinger.udemy.cloud.traverse;


import com.kicinger.udemy.cloud.domain.Player;
import com.kicinger.udemy.cloud.resources.PlayerResources;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;

import java.net.URI;

public class TraversonExample {

    private void getPlayer() throws Exception {
        Traverson traverson = new Traverson(
                new URI("http://localhost:8080/")
                , MediaTypes.HAL_JSON
        );

        final PlayerResources playerResources = traverson
            .follow("$_links.team.href", "$_embedded.team[0]._links.players.href")
            .toObject(PlayerResources.class);

        playerResources.getContent().forEach(resource -> {
            Player player = resource.getContent();
            System.out.println(player);
        });
    }

}
