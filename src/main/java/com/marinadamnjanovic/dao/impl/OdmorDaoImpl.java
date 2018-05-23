package com.marinadamnjanovic.dao.impl;

import com.marinadamnjanovic.dao.AbstractDao;
import com.marinadamnjanovic.dao.OdmorDao;
import com.marinadamnjanovic.model.Odmor;
import com.marinadamnjanovic.model.Zahtev;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("odmorDAO")
@Transactional
public class OdmorDaoImpl extends AbstractDao<Integer, Odmor> implements OdmorDao{

    public void addOdmor(Odmor odmor){
        persist(odmor);
    }

    @SuppressWarnings("unchecked")
    public List<Odmor> listOdmor(){
        Criteria criteria = createEntityCriteria();
        return (List<Odmor>) criteria.list();
    }

    public Odmor getOdmorById(int id){
        return getByKey(id);
    }

    public void removeOdmor(int id){
        Query query = getSession().createSQLQuery("delete from odmor where id = :id");
        query.setString("id", Integer.valueOf(id).toString());
        query.executeUpdate();
    }

}
