package com.marinadamnjanovic.service;

import com.marinadamnjanovic.model.Odmor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OdmorService {

    void addOdmor(Odmor odmor);
    void updateOdmor(Odmor odmor);
    List<Odmor> listOdmor();
    Odmor getOdmorById(int id);
    void removeOdmor(int id);

}
