package com.example.expeditionxpert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DestinationController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("")
    public String showDestinations(Model model) {
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("currencies", getCurrencies(countries));
        model.addAttribute("climates", getClimates(countries));
        return "index"; // Hier "index" ist der Name Ihrer HTML-Datei (z.B. index.html)
    }

    // Hilfsmethode, um eine Liste der eindeutigen Währungen zu extrahieren
    private List<String> getCurrencies(List<Country> countries) {
        return countries.stream()
                .map(Country::getWaehrung)
                .distinct()
                .collect(Collectors.toList());
    }

    // Hilfsmethode, um eine Liste der eindeutigen Klimazonen zu extrahieren
    private List<String> getClimates(List<Country> countries) {
        return countries.stream()
                .map(Country::getKlima)
                .distinct()
                .collect(Collectors.toList());
    }
}
