package dk.kea.trash_api.controllers;

import dk.kea.trash_api.model.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonController {

    List<Pokemon> pokemon = Arrays.asList(
            new Pokemon("Venusaur", 3),
            new Pokemon("Pidgeot", 18),
            new Pokemon("Electabuzz", 125),
            new Pokemon("Nidoking", 34),
            new Pokemon("Alakazam", 65),
            new Pokemon("Gyarados", 130)
    );

    @GetMapping("/pokemon/go")
    public boolean pokemonGo(){
        return false;
    }

    @GetMapping("/pokemon/dreamteam")
    public List<Pokemon> pokemonDreamTeam(){
        return pokemon;
    }

}
