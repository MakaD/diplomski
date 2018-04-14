package com.marinadamnjanovic.service.impl;

import com.marinadamnjanovic.dao.OdmorDao;
import com.marinadamnjanovic.model.Odmor;
import com.marinadamnjanovic.service.OdmorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("odmorService")
@Transactional
public class OdmorServiceImpl implements OdmorService {

    @Autowired
    private OdmorDao odmorDao;

    public void addOdmor(Odmor odmor){
        odmorDao.addOdmor(odmor);
    }

    public void updateOdmor(Odmor odmor){
        Odmor entity = odmorDao.getOdmorById(odmor.getZahtev().getId());
        if(entity!=null){
            entity.setPovod(odmor.getPovod());
            entity.setDatumOd(odmor.getDatumOd());
            entity.setDatumDo(odmor.getDatumDo());
        }
    }

    public List<Odmor> listOdmor(){
        return odmorDao.listOdmor();
    }

    public Odmor getOdmorById(int zahtevId){
        return odmorDao.getOdmorById(zahtevId);
    }

    public void removeOdmor(int id){
        odmorDao.removeOdmor(id);
    }

}
