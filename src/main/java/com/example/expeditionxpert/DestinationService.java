package com.example.expeditionxpert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DestinationService {

    List<Country> findAllCountries();

    Country findCountryById(Long id);

    Country saveCountry(Country country);

    void deleteCountry(Long id);
}