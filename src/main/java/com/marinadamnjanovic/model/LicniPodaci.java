package com.marinadamnjanovic.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="licnipodaci")
public class LicniPodaci {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_licnipod")
    private int id;

    @NotEmpty
    @Column(name = "ime")
    private String ime;

    @NotEmpty
    @Column(name = "prezime")
    private String prezime;

    @Column(name = "datumRodenja")
    private Date datumRodenja;

    @NotEmpty
    @Column(name = "lk")
    private long lk;

    @Column(name = "email")
    private String email;

    @Column(name = "telefon")
    private long telefon;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "opstina")
    private int opstina;

    @Column(name = "bracnoStanje")
    private int bracnoStanje;

    @Column(name = "zanimanje")
    private String zanimanje;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_zaposleni")
    private Zaposleni zaposleni;

    public LicniPodaci(String ime, String prezime, Date datumRodenja, long lk, String email, long telefon, String adresa, int opstina, int bracnoStanje, String zanimanje, Zaposleni zaposleni) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodenja = datumRodenja;
        this.lk = lk;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
        this.opstina = opstina;
        this.bracnoStanje = bracnoStanje;
        this.zanimanje = zanimanje;
        this.zaposleni = zaposleni;
    }

    public LicniPodaci() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(Date datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public long getLk() {
        return lk;
    }

    public void setLk(long lk) {
        this.lk = lk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getOpstina() {
        return opstina;
    }

    public void setOpstina(int opstina) {
        this.opstina = opstina;
    }

    public int getBracnoStanje() {
        return bracnoStanje;
    }

    public void setBracnoStanje(int bracnoStanje) {
        this.bracnoStanje = bracnoStanje;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }
}
