package no.hvl.dat108_oblig4_del1.repository;

import no.hvl.dat108_oblig4_del1.model.Deltager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DeltagerRepo {

    private final List<Deltager> deltagere;

    public DeltagerRepo() {
        deltagere = new ArrayList<>(Arrays.asList(
                new Deltager("Arne", "Arnesen", "90123456", "Passord1", "mann"),
                new Deltager("Anne", "Panne", "23456789", "Passord2", "kvinne"),
                new Deltager("Per", "Persen", "12345678", "Passord3", "mann"),
                new Deltager("Kari", "Nordmann", "98765432", "Passord4", "kvinne"),
                new Deltager("Ola", "Halvorsen", "45678901", "Passord5", "mann"),
                new Deltager("Silje", "Solberg", "91234567", "Passord6", "kvinne"),
                new Deltager("Bjørn", "Johansen", "47654321", "Passord7", "mann"),
                new Deltager("Ida", "Vold", "99887766", "Passord8", "kvinne"),
                new Deltager("Lars-Petter", "Helland", "12345679", "Passord9", "mann"),
                new Deltager("Frida", "Bakken", "44556677", "Passord10", "kvinne")
        ));
    }

    /**
     * Henter ut en liste over alle påmeldte deltagere.
     * @return En liste med Deltager-objekter.
     */
    public List<Deltager> findAll() {
        return deltagere;
    }

    /**
     * Lagrer en ny deltager i listen.
     * @param deltager Deltager-objektet som skal legges til.
     */
    public void save(Deltager deltager) {
        deltagere.add(deltager);
    }

    /**
     * Finner en deltager basert på mobilnummer.
     * Siden mobilnummer er unikt, vil dette alltid returnere maks én person.
     * @param mobil Mobilnummeret det skal søkes etter.
     * @return Deltager-objektet hvis det finnes, ellers null.
     */
    public Deltager findByMobil(String mobil) {
        // Går gjennom listen og returnerer den første deltageren som matcher mobilnummeret.
        return deltagere.stream()
                .filter(d -> d.getMobil().equals(mobil))
                .findFirst()
                .orElse(null);
    }
}