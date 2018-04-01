package com.marinadamnjanovic.service;

import com.marinadamnjanovic.model.LicniPodaci;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LicniPodaciService {

    void addLicniPodaci(LicniPodaci licniPodaci);
    void updateLicniPodaci(LicniPodaci licniPodaci);
    List<LicniPodaci> listLicniPodaci();
    LicniPodaci getLicniPodaciById(int id);
    void removeLicniPodaci(int id);

}
