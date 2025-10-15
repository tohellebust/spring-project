package no.hvl.dat108_oblig4_del1;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import no.hvl.dat108_oblig4_del1.model.Deltager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Enhetstester for valideringsreglene i Deltager-klassen.
 */
class DeltagerValidationTest {

    private static Validator validator;

    // Denne metoden kjøres én gang før alle testene for å sette opp validatoren
    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Lager en gyldig deltager som kan brukes som utgangspunkt i testene.
     */
    private Deltager gyldigDeltager() {
        return new Deltager("Ola", "Nordmann", "12345678", "Passord123", "mann");
    }

    @Test
    void gyldigDeltagerSkalIkkeHaValideringsfeil() {
        Deltager deltager = gyldigDeltager();
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);

        // Assert 1: Sjekker at en gyldig deltager ikke gir noen feil.
        assertTrue(violations.isEmpty(), "En gyldig deltager skal ikke ha valideringsfeil.");
    }

    @Test
    void fornavnForKortGirFeil() {
        Deltager deltager = gyldigDeltager();
        deltager.setFornavn("A"); // Ugyldig
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);

        // Assert 2: Sjekker at for kort fornavn blir fanget opp.
        assertFalse(violations.isEmpty(), "Valideringen skal finne feil i fornavn.");
    }

    @Test
    void fornavnMedLitenForbokstavGirFeil() {
        Deltager deltager = gyldigDeltager();
        deltager.setFornavn("ola"); // Ugyldig
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);

        // Assert 3: Sjekker at fornavn med liten forbokstav gir feil.
        assertEquals(1, violations.size(), "Skal finne nøyaktig én feil for ugyldig fornavn.");
    }

    @Test
    void ugyldigMobilnummerGirFeil() {
        Deltager deltager = gyldigDeltager();
        deltager.setMobil("12345"); // Ugyldig
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);

        // Assert 4: Sjekker at mobilnummer med feil lengde gir feil.
        assertFalse(violations.isEmpty(), "Validering skal finne feil i mobilnummer.");
    }

    @Test
    void passordForKortGirFeil() {
        Deltager deltager = gyldigDeltager();
        deltager.setPassord("Kort1"); // Ugyldig
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);

        // Assert 5: Sjekker at for kort passord gir feil.
        assertFalse(violations.isEmpty(), "Validering skal finne feil for for kort passord.");
    }

    @Test
    void passordUtenTallGirFeil() {
        Deltager deltager = gyldigDeltager();
        deltager.setPassord("PassordUtenTall"); // Ugyldig
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);

        // Assert 6 (bonus): Sjekker at passord uten tall gir feil.
        assertFalse(violations.isEmpty(), "Validering skal finne feil for passord som mangler tall.");
    }
}