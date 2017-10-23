package com.kicinger.udemy.cloud.projections;

import com.kicinger.udemy.cloud.domain.Player;
import com.kicinger.udemy.cloud.domain.Team;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(
        name = "inlinePlayers",
        types = { Team.class }
)
public interface InlinePlayers {

    String getName();
    String getLocation();
    String getMascotte();
    Set<Player> getPlayers();

}
