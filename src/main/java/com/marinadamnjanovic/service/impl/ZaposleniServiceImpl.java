package com.marinadamnjanovic.service.impl;

import com.marinadamnjanovic.dao.ZaposleniDao;
import com.marinadamnjanovic.model.Zaposleni;
import com.marinadamnjanovic.service.ZaposleniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("zaposleniService")
@Transactional
public class ZaposleniServiceImpl implements ZaposleniService {

    @Autowired
    private ZaposleniDao zaposleniDao;

    public void addZaposleni(Zaposleni zaposleni){
        zaposleniDao.addZaposleni(zaposleni);
    }

    public void updateZaposleni(Zaposleni zaposleni){
        Zaposleni entity = zaposleniDao.getZaposleniById(zaposleni.getId());
        if(entity!=null){
            entity.setRola(zaposleni.getRola());
            entity.setUsername(zaposleni.getUsername());
            entity.setPassword(zaposleni.getPassword());
        }
    }

    public List<Zaposleni> listZaposleni(){
        return zaposleniDao.listZaposleni();
    }

    public Zaposleni getZaposleniById(int id){
        return zaposleniDao.getZaposleniById(id);
    }

    public void removeZaposleni(int id){
        zaposleniDao.removeZaposleni(id);
    }

}
