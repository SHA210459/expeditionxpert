package com.example.expeditionxpert;
import jakarta.persistence.*;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    // Konstruktor, Getter und Setter (abgekürzt für die wichtigen Felder)

    public City() {
    }

    // Getter und Setter für die wichtigen Felder
}

