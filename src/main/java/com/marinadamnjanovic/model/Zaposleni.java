package com.marinadamnjanovic.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="zaposleni")
public class Zaposleni {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_zaposleni")
    private int id;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "rola")
    private int rola;

    /*@OneToOne(mappedBy = "id_zaposleni")
    private LicniPodaci licniPodaci;*/

    /*@OneToMany(mappedBy = "id_zaposleni")
    private List<Zahtev> zahtevi = new ArrayList<>();*/

    public Zaposleni(int id, String username, String password, int rola) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rola = rola;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRola() {
        return rola;
    }

    public void setRola(int rola) {
        this.rola = rola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zaposleni() {

    }

}
