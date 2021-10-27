package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Artist;
import edu.kea.paintings.repositories.ArtistRepository;
import edu.kea.paintings.models.Gallery;
import edu.kea.paintings.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Artists {

    @Autowired
    ArtistRepository artists;

    @Autowired
    GalleryRepository galleries;

    @GetMapping("/artists")
    public Iterable<Artist> getArtists(){
        return artists.findAll();
    }

    @GetMapping("/artists/{id}")
    public Optional<Artist> getArtistById(@PathVariable Long id){
        return artists.findById(id);
    }

    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist newArtist){
        newArtist.setId(null);
        return artists.save(newArtist);
    }

    @PostMapping("/artists/gallery/{artistId}/{galleryId}")
    public Artist addGalleryToArtist(@PathVariable Long artistId, @PathVariable Long galleryId){
        return null;
    }

    @PutMapping("/artists/{id}")
    public String putArtistById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith){
        if(artists.existsById(id)){
            artistToUpdateWith.setId(id);
            artists.save(artistToUpdateWith);
            return "Artist updated";
        } else{
            return "Artist not found";
        }
    }

    /*
    @PutMapping("/artists/{id}")
    public Artist putArtistById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith){
        artistToUpdateWith.setId(id);
        return artists.save(artistToUpdateWith);
    }
     */

    @PatchMapping("/artists/{id}")
    public String patchArtistById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith){
        return artists.findById(id).map(foundArtist -> {
            if(artistToUpdateWith.getName() != null) {foundArtist.setName(artistToUpdateWith.getName());}
            if(artistToUpdateWith.getAge() != 0) {foundArtist.setAge(artistToUpdateWith.getAge());}
            if(artistToUpdateWith.getNationality() != null) {foundArtist.setNationality(artistToUpdateWith.getNationality());}
            if(artistToUpdateWith.getGender() != null) {foundArtist.setGender(artistToUpdateWith.getGender());}
            artists.save(foundArtist);
            return "Artist updated";
        }).orElse("Artist not found");
    }

    @DeleteMapping("/artists/{id}")
    public void deleteArtistById(@PathVariable Long id){
        artists.deleteById(id);
    }
}
