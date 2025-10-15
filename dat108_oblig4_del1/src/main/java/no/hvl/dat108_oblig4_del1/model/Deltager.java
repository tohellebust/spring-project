package no.hvl.dat108_oblig4_del1.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Deltager {

    @NotBlank(message = "Fornavn kan ikke være tomt")
    @Size(min = 2, max = 20, message = "Fornavn må være mellom 2 og 20 tegn")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zæøå-]*$", message = "Fornavn må starte med stor bokstav og kan kun inneholde bokstaver, bindestrek og mellomrom")
    private String fornavn;

    @NotBlank(message = "Etternavn kan ikke være tomt")
    @Size(min = 2, max = 20, message = "Etternavn må være mellom 2 og 20 tegn")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zæøå-]*$", message = "Etternavn må starte med stor bokstav og kan kun inneholde bokstaver og bindestrek")
    private String etternavn;

    @NotBlank(message = "Mobilnummer kan ikke være tomt")
    @Pattern(regexp = "^\\d{8}$", message = "Mobilnummer må bestå av nøyaktig 8 siffer")
    private String mobil;

    @NotBlank(message = "Passord kan ikke være tomt")
    @Size(min = 8, max = 20, message = "Passord må være mellom 8 og 20 tegn")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", message = "Passord må inneholde minst én stor bokstav, én liten bokstav og ett tall")
    private String passord;

    @NotBlank(message = "Kjønn må velges")
    private String kjonn;

    public Deltager() {
    }

    public Deltager(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.passord = passord;
        this.kjonn = kjonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    // --- equals, hashCode og toString ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deltager deltager = (Deltager) o;
        return Objects.equals(mobil, deltager.mobil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobil);
    }

    @Override
    public String toString() {
        return "Deltager{" +
                "fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", passord='" + passord + '\'' +
                ", kjonn='" + kjonn + '\'' +
                '}';
    }
}