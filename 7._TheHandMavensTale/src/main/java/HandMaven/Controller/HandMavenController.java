package HandMaven.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandMavenController {

    @GetMapping("/")
    public String about(){
        return "about:HandMaven";
    }
}
