package com.marinadamnjanovic.service.impl;

import com.marinadamnjanovic.dao.ZahtevDao;
import com.marinadamnjanovic.model.Zahtev;
import com.marinadamnjanovic.service.ZahtevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("zahtevService")
@Transactional
public class ZahtevServiceImpl implements ZahtevService {

    @Autowired
    private ZahtevDao zahtevDao;

    public void addZahtev(Zahtev zahtev){
        zahtevDao.addZahtev(zahtev);
    }

    public void updateZahtev(Zahtev zahtev){
        Zahtev entity = zahtevDao.getZahtevById(zahtev.getId());
        if(entity!=null){
            entity.setDatum(zahtev.getDatum());
            entity.setPredmet(zahtev.getPredmet());
            entity.setStatus(zahtev.getStatus());
        }
    }

    public List<Zahtev> listZahtev(){
        return zahtevDao.listZahtev();
    }

    public Zahtev getZahtevById(int id){
        return zahtevDao.getZahtevById(id);
    }

    public void removeZahtev(int id){
        zahtevDao.removeZahtev(id);
    }

}
