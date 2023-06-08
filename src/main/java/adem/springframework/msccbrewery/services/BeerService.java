package adem.springframework.msccbrewery.services;

import adem.springframework.msccbrewery.web.model.BeerDto;
import org.springframework.stereotype.Component;

import java.util.UUID;


public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
