package com.marinadamnjanovic.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="zahtev")
public class Zahtev {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_zahtev")
    private int id;

    @NotEmpty
    @Column(name = "status")
    private int status;

    @NotEmpty
    @Column(name = "predmet")
    private String predmet;

    @NotEmpty
    @Column(name = "datum")
    private Date datum;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_zaposleni")
    private Zaposleni idZaposleni;

    public Zahtev() {
    }

    public Zahtev(int status, String predmet, Date datum) {
        this.status = status;
        this.predmet = predmet;
        this.datum = datum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
