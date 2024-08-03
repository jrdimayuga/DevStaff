package com.devstaff.dao;

import com.devstaff.entity.Planted;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantedDAO {

    public List<Planted> getPlantedData (final String farmerCode, final String season, final String farmFieldCode) {
        Transaction transaction = null;
        List<Planted> plantedList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // retrieve data
            String hql = " FROM Planted p WHERE p.farmer.farmerCode = :farmerCode" +
                    " and p.season = :season and p.farmField.code = :farmFieldCode";
            Query query = session.createQuery(hql);
            query.setParameter("farmerCode", farmerCode);
            query.setParameter("season", season);
            query.setParameter("farmFieldCode", farmFieldCode);
            plantedList = query.getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return plantedList;
    }
}
