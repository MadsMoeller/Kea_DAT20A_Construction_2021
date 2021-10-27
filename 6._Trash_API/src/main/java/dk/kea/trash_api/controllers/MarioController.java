package dk.kea.trash_api.controllers;

import dk.kea.trash_api.model.SuperMarioCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarioController {

    @GetMapping("/supermario/characters")
    public SuperMarioCharacter smCharacter(){
        return new SuperMarioCharacter("Bowser");
    }

}
