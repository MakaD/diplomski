package com.marinadamnjanovic.dao.impl;

import com.marinadamnjanovic.dao.AbstractDao;
import com.marinadamnjanovic.dao.ZaposleniDao;
import com.marinadamnjanovic.model.Zaposleni;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("zaposleniDao")
public class ZaposleniDaoImpl extends AbstractDao<Integer, Zaposleni> implements ZaposleniDao {

    public void addZaposleni(Zaposleni zaposleni){
        persist(zaposleni);
    }

    @SuppressWarnings("unchecked")
    public List<Zaposleni> listZaposleni(){
        Criteria criteria = createEntityCriteria();
        return (List<Zaposleni>) criteria.list();
    }

    public Zaposleni getZaposleniById(int id){
        return getByKey(id);
    }

    public void removeZaposleni(int id){
        Query query = getSession().createSQLQuery("delete from zaposleni where id = :id");
        query.setString("id", Integer.valueOf(id).toString());
        query.executeUpdate();
    }

}
