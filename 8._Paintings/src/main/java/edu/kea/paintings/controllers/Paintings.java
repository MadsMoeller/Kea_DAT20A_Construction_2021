package edu.kea.paintings.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kea.paintings.DTO.ArtistDTO;
import edu.kea.paintings.models.Artist;
import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.ArtistRepository;
import edu.kea.paintings.repositories.PaintingRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Paintings controller", description = "REST endpoints for paintings")
@RestController
public class Paintings {

    @Autowired
    PaintingRepository paintings;
    @Autowired
    ArtistRepository artists;

    @GetMapping("/paintings")
    public Iterable<Painting> getPaintings(){
        return paintings.findAll();
    }

    @GetMapping("/paintings/{id}")
    public Optional<Painting> getPaintingById(@PathVariable Long id){
        return paintings.findById(id);
    }

    @GetMapping("/paintings/timeline")
    public List<Painting> getPaintingsByArtistAndYear(@RequestParam(required = false) String artist, @RequestParam(required = false) int year){
        return paintings.findPaintingsByArtistAndYear(artist, year);
    }

    @GetMapping("/paintings/pricelookup/{price}")
    public List<Painting> getPaintingsAboveACertainPrice(@PathVariable double price){
        return paintings.findPaintingsMoreExpensiveThan(price);
    }

    @PostMapping("/paintings")
    public Painting addPainting(@RequestBody String body)throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Painting paintingToCreate = mapper.readValue(body, Painting.class);

        Iterable<Long> artistsIds = mapper.readValue(body, ArtistDTO.class).artistIds;

        System.out.println();

        System.out.println(paintingToCreate);
        System.out.println(artistsIds);

        List<Artist> foundArtists = artists.findAllById(artistsIds);

        paintingToCreate.setArtists(foundArtists);

        return paintings.save(paintingToCreate);
        //newPainting.setId(null);
        //return paintings.save(newPainting);
    }

    @PutMapping("/paintings/{id}")
    public String putPaintingById(@PathVariable Long id, @RequestBody Painting paintingToUpdateWith){
        if(paintings.existsById(id)){
            paintingToUpdateWith.setId(id);
            paintings.save(paintingToUpdateWith);
            return "Painting updated";
        } else{
            return "Painting not found";
        }
    }

    @PatchMapping("/paintings/{id}")
    public String patchPaintingById(@PathVariable Long id, @RequestBody Painting paintingToUpdateWith){
        return paintings.findById(id).map(foundPainting -> {
            if(paintingToUpdateWith.getArtist() != null) {foundPainting.setArtist(paintingToUpdateWith.getArtist());}
            if(paintingToUpdateWith.getPrice() != 0) {foundPainting.setPrice(paintingToUpdateWith.getPrice());}
            if(paintingToUpdateWith.getTitle() != null) {foundPainting.setTitle(paintingToUpdateWith.getTitle());}
            if(paintingToUpdateWith.getGenre() != null) {foundPainting.setGenre(paintingToUpdateWith.getGenre());}
            if(paintingToUpdateWith.getYear() != 0) {foundPainting.setYear(paintingToUpdateWith.getYear());}
            paintings.save(foundPainting);
            return "Artist updated";
        }).orElse("Artist not found");
    }

    /*
    @PatchMapping("/paintings{id}")
    public Painting patchPaintingById(@PathVariable String id, @RequestBody String body){
        try{
            ObjectMapper mapper = new ObjectMapper();
            Painting newPainting = mapper.readValue(body, Painting.class);
            return newPainting;
        }catch (JsonProcessingException jpe) {
            System.out.println("Error: " + jpe.getMessage());
            Painting unknownPainting = new Painting("Unknown");
            paintings.set(Integer.parseInt(id)-1, unknownPainting);
            return unknownPainting;
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
     */

    @DeleteMapping("/paintings/{id}")
    public void deletePaintingById(@PathVariable Long id){
        paintings.deleteById(id);
    }
}
