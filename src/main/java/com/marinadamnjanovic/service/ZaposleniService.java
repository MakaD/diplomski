package com.marinadamnjanovic.service;

import com.marinadamnjanovic.model.Zaposleni;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZaposleniService {

    void addZaposleni(Zaposleni zaposleni);
    void updateZaposleni(Zaposleni zaposleni);
    List<Zaposleni> listZaposleni();
    Zaposleni getZaposleniById(int id);
    void removeZaposleni(int id);

}
