package com.marinadamnjanovic.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="odmor")
public class Odmor implements Serializable {

    @Id
    @Column(name = "id_odmor")
    private int id;

    @Column(name = "datumOd")
    private Date datumOd;

    @Column(name = "datumDo")
    private Date datumDo;

    @Column(name = "povod")
    private String povod;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn (name = "id_zahtev", nullable = false)
    private Zahtev zahtev;

    public Odmor() {
    }

    public Odmor(Date datumOd, Date datumDo, String povod) {
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.povod = povod;
    }

    public Zahtev getZahtev() {
        return zahtev;
    }

    public void setZahtev(Zahtev zahtev) {
        this.zahtev = zahtev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getPovod() {
        return povod;
    }

    public void setPovod(String povod) {
        this.povod = povod;
    }



    @Override
    public String toString() {
        return "Odmor{" +
                "datumOd=" + datumOd +
                ", datumDo=" + datumDo +
                ", povod='" + povod + '\'' +
                '}';
    }
}
