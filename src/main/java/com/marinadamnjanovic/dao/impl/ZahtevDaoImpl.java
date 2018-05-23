package com.marinadamnjanovic.dao.impl;

import com.marinadamnjanovic.dao.AbstractDao;
import com.marinadamnjanovic.dao.ZahtevDao;
import com.marinadamnjanovic.model.Zahtev;
import jdk.nashorn.internal.objects.NativeUint8Array;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("zahtevDAO")
@Transactional
public class ZahtevDaoImpl extends AbstractDao<Integer, Zahtev> implements ZahtevDao {

    public void addZahtev(Zahtev zahtev){
        persist(zahtev);
    }

    @SuppressWarnings("unchecked")
    public List<Zahtev> listZahtev(){
        Criteria criteria = createEntityCriteria();
        return (List<Zahtev>) criteria.list();
    }

    public Zahtev getZahtevById(int id){
        return getByKey(id);
    }

    public void removeZahtev(int id){
        Query query = getSession().createSQLQuery("delete from zahtev where id = :id");
        query.setString("id", Integer.valueOf(id).toString());
        query.executeUpdate();
    }

}