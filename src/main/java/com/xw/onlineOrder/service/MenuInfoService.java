package com.xw.onlineOrder.service;

import com.xw.onlineOrder.dao.MenuInfoDao;
import com.xw.onlineOrder.entity.MenuItem;
import com.xw.onlineOrder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int menuItemId) {
        return menuInfoDao.getMenuItem(menuItemId);
    }

}
