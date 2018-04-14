package com.marinadamnjanovic.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="zahtev")
public class Zahtev implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_zahtev")
    private int id;

    @Column(name = "status")
    private int status;

    @Column(name = "predmet")
    private String predmet;

    @Column(name = "datum")
    private Date datum;

    @OneToOne (mappedBy = "zahtev", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Odmor odmor;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_zaposleni")
    private Zaposleni idZaposleni;

    public Zahtev(){

    }

    public Zahtev(int status, String predmet, Date datum) {
        this.status = status;
        this.predmet = predmet;
        this.datum = datum;
    }

    public Odmor getOdmor() {
        return odmor;
    }

    public void setOdmor(Odmor odmor) {
        this.odmor = odmor;
        odmor.setZahtev(this);
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

    @Override
    public String toString() {
        return "Zahtev{" +
                "id=" + id +
                ", status=" + status +
                ", predmet='" + predmet + '\'' +
                ", datum=" + datum +
                ", idZaposleni=" + idZaposleni +
                '}';
    }
}
