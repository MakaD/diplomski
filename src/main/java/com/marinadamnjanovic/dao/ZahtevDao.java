package com.marinadamnjanovic.dao;

import com.marinadamnjanovic.model.Zahtev;

import java.util.List;

public interface ZahtevDao {

    void addZahtev(Zahtev zahtev);
    List<Zahtev> listZahtev();
    Zahtev getZahtevById(int id);
    void removeZahtev(int id);

}
