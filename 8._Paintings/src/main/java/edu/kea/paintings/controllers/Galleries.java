package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Gallery;
import edu.kea.paintings.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Galleries {

    @Autowired
    GalleryRepository galleries;

    @GetMapping("/galleries")
    public Iterable<Gallery> getGalleries(){
        return galleries.findAll();
    }

    @GetMapping("/galleries/{id}")
    public Optional<Gallery> getGalleryById(@PathVariable Long id){
        return galleries.findById(id);
    }

    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery newGallery){
        newGallery.setId(null);
        return galleries.save(newGallery);
    }

    @PutMapping("/galleries/{id}")
    public Gallery putGalleryById(@PathVariable Long id, @RequestBody Gallery galleryToUpdateWith){
        galleryToUpdateWith.setId(id);
        return galleries.save(galleryToUpdateWith);
    }

    @PatchMapping("/galleries/{id}")
    public Gallery patchGalleryById(@PathVariable Long id, @RequestBody Gallery newGallery){
        return null;
    }

    @DeleteMapping("/galleries/{id}")
    public void deleteGalleryById(@PathVariable Long id){
        galleries.deleteById(id);
    }
}
