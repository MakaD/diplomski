package com.marinadamnjanovic.dao;

import com.marinadamnjanovic.model.Odmor;

import java.util.List;

public interface OdmorDao {

    void addOdmor(Odmor odmor);
    List<Odmor> listOdmor();
    Odmor getOdmorById(int id);
    void removeOdmor(int id);

}
