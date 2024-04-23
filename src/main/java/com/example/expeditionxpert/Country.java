package com.example.expeditionxpert;
import jakarta.persistence.*;


import java.util.List;


@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String land;
    private String sprache;
    private String waehrung;
    private String klima;
    private String sicherheit;

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public String getWaehrung() {
        return waehrung;
    }

    public void setWaehrung(String waehrung) {
        this.waehrung = waehrung;
    }

    public String getKlima() {
        return klima;
    }

    public void setKlima(String klima) {
        this.klima = klima;
    }

    public String getSicherheit() {
        return sicherheit;
    }

    public void setSicherheit(String sicherheit) {
        this.sicherheit = sicherheit;
    }
}
