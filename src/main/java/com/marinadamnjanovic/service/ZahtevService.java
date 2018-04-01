package com.marinadamnjanovic.service;

import com.marinadamnjanovic.model.Zahtev;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZahtevService {

    void addZahtev(Zahtev zahtev);
    void updateZahtev(Zahtev zahtev);
    List<Zahtev> listZahtev();
    Zahtev getZahtevById(int id);
    void removeZahtev(int id);

}
