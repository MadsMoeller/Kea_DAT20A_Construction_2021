package mads.kea.prices_store.controllers;

import mads.kea.prices_store.models.Store;
import mads.kea.prices_store.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Stores {

    @Autowired
    StoreRepository stores;

    @GetMapping("/stores")
    public List<Store> getAllStores(){
        return stores.findAll();
    }

    @GetMapping("/stores/{id}")
    public Optional<Store> getStoreById(@PathVariable Long id){
        return stores.findById(id);
    }
}
