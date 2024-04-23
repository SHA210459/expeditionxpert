package com.example.expeditionxpert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilterController {

    @Autowired
    private ReisezieleRepository reisezieleRepository;

    @GetMapping("/filterDestinations")
    public <Reiseziele> String filterDestinations(
            @RequestParam String filterAttribute,
            @RequestParam String filterValue,
            Model model
    ) {
        List<Reiseziele> filteredDestinations;

        switch (filterAttribute) {
            case "Land":
                filteredDestinations = reisezieleRepository.findByLand(filterValue);
                break;
            case "Sprache":
                filteredDestinations = reisezieleRepository.findBySprache(filterValue);
                break;
            case "Waehrung":
                filteredDestinations = reisezieleRepository.findByWaehrung(filterValue);
                break;
            case "Klima":
                filteredDestinations = reisezieleRepository.findByKlima(filterValue);
                break;
            case "Sicherheit":
                filteredDestinations = reisezieleRepository.findBySicherheit(filterValue);
                break;
            default:
                filteredDestinations = reisezieleRepository.findAll();
        }

        model.addAttribute("filteredDestinations", filteredDestinations);
        return "filtered_destinations"; // Thymeleaf-Vorlage für die Anzeige der gefilterten Reiseziele
    }
}
