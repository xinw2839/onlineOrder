package com.xw.onlineOrder.dao;

import org.hibernate.SessionFactory;
import com.xw.onlineOrder.entity.OrderItem;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemOrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(OrderItem orderItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(orderItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }
}
