package com.example.expeditionxpert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReisezieleRepository<Reiseziele> extends JpaRepository<Reiseziele, Long> {

    List<Reiseziele> findByLand(String land);

    List<Reiseziele> findBySprache(String sprache);

    List<Reiseziele> findByWaehrung(String waehrung);

    List<Reiseziele> findByKlima(String klima);

    List<Reiseziele> findBySicherheit(String sicherheit);

}
