package com.marinadamnjanovic.dao;

import com.marinadamnjanovic.model.LicniPodaci;

import java.util.List;

public interface LicniPodaciDao {

    void addLicniPodaci(LicniPodaci licniPodaci);
    List<LicniPodaci> listLicniPodaci();
    LicniPodaci getLicniPodaciById(int id);
    void removeLicniPodaci(int id);

}
