package mads.kea.prices_store.controllers;

import mads.kea.prices_store.DTO.response.PriceCreateDTO;
import mads.kea.prices_store.models.Price;
import mads.kea.prices_store.repositories.PriceRepository;
import mads.kea.prices_store.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Prices {

    @Autowired
    PriceRepository prices;

    @Autowired
    StoreRepository stores;

    @GetMapping("/prices")
    public List<Price> getAllPrices(){
        return prices.findAll();
    }

    @GetMapping("/prices/{storeId}")
    public List<Price> getPricesByStoreId(@PathVariable Long storeId){
        return prices.findAllByStoreId(storeId);
    }

    @PostMapping("/prices/{storeId}")
    public PriceCreateDTO createPrice(@PathVariable Long storeId, @RequestBody Price priceToCreate){
        return stores.findById(storeId).map(store -> {
            priceToCreate.setId(null);
            priceToCreate.setStore(store);
            Price createdPrice = prices.save(priceToCreate);
            return new PriceCreateDTO(createdPrice);
        }
        ).orElse(new PriceCreateDTO("Did not find the store by storeId"));
    }

    @DeleteMapping("/prices/{storeId}")
    public void deleteAllPricesByStoreId(@PathVariable Long storeId){
        prices.deleteAllPricesByStoreId(storeId);
    }
}
