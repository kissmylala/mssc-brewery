package adem.springframework.msccbrewery.services;

import adem.springframework.msccbrewery.web.model.BeerDto;
import org.springframework.stereotype.Component;

import java.util.UUID;


public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);
}
