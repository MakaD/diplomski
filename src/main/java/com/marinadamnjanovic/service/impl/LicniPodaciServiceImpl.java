package com.marinadamnjanovic.service.impl;

import com.marinadamnjanovic.dao.LicniPodaciDao;
import com.marinadamnjanovic.model.LicniPodaci;
import com.marinadamnjanovic.service.LicniPodaciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("licniPodaciService")
@Transactional
public class LicniPodaciServiceImpl implements LicniPodaciService {

    @Autowired
    private LicniPodaciDao licniPodaciDao;

    public void addLicniPodaci(LicniPodaci licniPodaci){
        licniPodaciDao.addLicniPodaci(licniPodaci);
    }

    public void updateLicniPodaci(LicniPodaci licniPodaci){
        LicniPodaci entity = licniPodaciDao.getLicniPodaciById(licniPodaci.getId());
        if(entity!=null){
            entity.setAdresa(licniPodaci.getAdresa());
            entity.setBracnoStanje(licniPodaci.getBracnoStanje());
            entity.setDatumRodenja(licniPodaci.getDatumRodenja());
            entity.setEmail(licniPodaci.getEmail());
            entity.setIme(licniPodaci.getIme());
            entity.setLk(licniPodaci.getLk());
            entity.setOpstina(licniPodaci.getOpstina());
            entity.setPrezime(licniPodaci.getPrezime());
            entity.setTelefon(licniPodaci.getTelefon());
            entity.setZanimanje(licniPodaci.getZanimanje());

        }
    }

    public List<LicniPodaci> listLicniPodaci(){
        return licniPodaciDao.listLicniPodaci();
    }

    public LicniPodaci getLicniPodaciById(int id){
        return licniPodaciDao.getLicniPodaciById(id);
    }

    public void removeLicniPodaci(int id){
        licniPodaciDao.removeLicniPodaci(id);
    }

}
