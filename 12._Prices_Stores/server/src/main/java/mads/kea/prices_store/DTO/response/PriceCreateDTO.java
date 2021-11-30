package mads.kea.prices_store.DTO.response;

import mads.kea.prices_store.models.Price;
import mads.kea.prices_store.models.Store;

public class PriceCreateDTO {

    public Price price;
    public String message;
    public boolean failed;

    public PriceCreateDTO(Price price){
        message = "Success";
        this.price = price;
    }

    public PriceCreateDTO(String errorMessage){
        message = errorMessage;
        this.failed = true;
    }

}
