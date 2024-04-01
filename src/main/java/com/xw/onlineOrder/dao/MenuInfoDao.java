package com.xw.onlineOrder.dao;

import com.xw.onlineOrder.entity.MenuItem;
import com.xw.onlineOrder.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurants() {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            return session.createCriteria(Restaurant.class).
                    setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return new ArrayList<>();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) {
                return restaurant.getMenuItemList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return null;
    }
}
