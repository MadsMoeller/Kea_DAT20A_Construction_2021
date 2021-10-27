package dk.kea.trash_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

@RestController
public class TrashController {



    @GetMapping("/")
    public String index(){return "index";}

    @GetMapping("/route")
    public String route(){
        return "I like coffee, I like tea. I love the Java jive and it loves me.";
    }

    @GetMapping("/clock")
    public String clock(){
        return "Tick tock goes the clock: " + (""+ java.time.LocalTime.now()).substring(0, 8);
    }

    @GetMapping("/clock2")
    public LocalTime clock2(){
        return java.time.LocalTime.now();
    }


    ArrayList<String> deadlySins = new ArrayList<>(){{
        add("pride");
        add("covetousness");
        add("lust");
        add("gluttony");
        add("envy");
        add("anger");
        add("sloth");
    }};

    Random rand = new Random();

    @GetMapping("/sin")
    public String deadlySin(){
        int sin = rand.nextInt(7);
        return deadlySins.get(sin);
    }

    @GetMapping("/sin/{sinInput}")
    public String numberedSin(@PathVariable String sinInput){
        try {
            int sin = Integer.parseInt(sinInput);
            if (sin <= 0 || sin > 7) {
                return "please input path variable between 1 and 7";
            }
            return deadlySins.get(sin - 1);
        }catch(NumberFormatException nfe){
            System.out.println("Error: " + nfe.getMessage());
            return "path variable not a number. Please input path variable as a number between 1 and 7";
        }
    }

    @GetMapping("/trash")
    public String trashMethod(
            @RequestParam(required = false) String trash,
            @RequestParam(required = false) String otherTrash
    ){
        return "This is your trash: " + trash + "<br>This is your other trash: " + otherTrash;
    }

    @PostMapping("/rubbishbin")
    public String throwOutRubbish(@RequestBody String rubbish){
        System.out.println(rubbish);
        return "Everything went well";
    }
}
