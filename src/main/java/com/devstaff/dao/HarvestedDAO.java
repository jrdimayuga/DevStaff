package com.devstaff.dao;

import com.devstaff.entity.Harvest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class HarvestedDAO {

    public List<Harvest> getHarvestedData (final String farmerCode, final String season, final String farmFieldCode) {
        Transaction transaction = null;
        List<Harvest> harvestedList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // retrieve data
            String hql = " FROM Harvest h WHERE h.farmer.farmerCode = :farmerCode" +
                    " and h.season = :season and h.farmField.code = :farmFieldCode";
            Query query = session.createQuery(hql);
            query.setParameter("farmerCode", farmerCode);
            query.setParameter("season", season);
            query.setParameter("farmFieldCode", farmFieldCode);
            harvestedList = query.getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return harvestedList;
    }
}
