package com.coffeeOrderBot.CoffeeBot.model;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class SyrupDAOImpl implements SyrupDAO {
    @Override
    public void addSyrup(Syrup syrup) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(syrup);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateSyrup(Long id, Syrup syrup) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.refresh(syrup);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Syrup> getDistinctByName() throws SQLException {
        List<Syrup> list = new ArrayList<>();
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            log.warn(e.getMessage());
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
        return list;
    }
}
