/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.menu.callback;

import com.building.agency.cofigure.menu.MenuItemModel;

/**
 * 
 * @author vbohudskyi
 * @version 1.1
 */
public interface MenuItemChosenListener {
    /**
     * Method is fired when a menu item is chosen
     * @param item chosen menu item
     * @param menuType defines a menu type
     */
    public void onItemChosen(MenuItemModel item, int menuType);
    
}
