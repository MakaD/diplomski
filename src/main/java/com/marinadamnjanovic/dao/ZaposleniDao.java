package com.marinadamnjanovic.dao;

import com.marinadamnjanovic.model.Zaposleni;

import java.util.List;

public interface ZaposleniDao {

    void addZaposleni(Zaposleni zaposleni);
    List<Zaposleni> listZaposleni();
    Zaposleni getZaposleniById(int id);
    void removeZaposleni(int id);

}
