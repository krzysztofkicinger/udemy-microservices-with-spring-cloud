package com.kicinger.udemy.boot.app.controllers;

import com.kicinger.udemy.boot.app.domain.Player;
import com.kicinger.udemy.boot.app.domain.Team;
import com.kicinger.udemy.boot.app.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class TeamController {

    private Team team;

    @Autowired
    private TeamRepository teamRepository;

    @PostConstruct
    public void init() {
        Set<Player> players = new HashSet<Player>();
        players.add(new Player("Charlie Brown", "pitcher"));
        players.add(new Player("Snoopy", "shortstop"));
        teamRepository.save(new Team("Peanuts", "California", players));
    }

    @GetMapping("/teams-api")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

}
