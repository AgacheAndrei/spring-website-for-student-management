package isi.proiect.studentmanager;

public class Elev {
    private int nr_matricol;
    private String CNP;
    private String nume;
    private String prenume;
    private String nr_telefon;
    private String adresa;
    private Float medie;
    private String acte_adi;
    private int codclasa;

    public Elev() {
    }

    public Elev(int nr_matricol, String CNP, String nume, String prenume, String nr_telefon, String adresa, Float medie, String acte_adi, int codclasa) {
        this.nr_matricol = nr_matricol;
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.nr_telefon = nr_telefon;
        this.adresa = adresa;
        this.medie = medie;
        this.acte_adi = acte_adi;
        this.codclasa = codclasa;
    }

    public int getNr_matricol() {
        return nr_matricol;
    }

    public void setNr_matricol(int nr_matricol) {
        this.nr_matricol = nr_matricol;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Float getMedie() {
        return medie;
    }

    public void setMedie(Float medie) {
        this.medie = medie;
    }

    public String getActe_adi() {
        return acte_adi;
    }

    public void setActe_adi(String acte_adi) {
        this.acte_adi = acte_adi;
    }

    public int getCodclasa() {
        return codclasa;
    }

    public void setCodclasa(int codclasa) {
        this.codclasa = codclasa;
    }
}
