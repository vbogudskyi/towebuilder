/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu;

import com.building.agency.cofigure.menu.Menu;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.cofigure.menu.callback.MenuItemChosenListener;
import com.building.agency.utils.M;
import java.util.ArrayList;
import java.util.List;

/**
 * Declared a resources menu
 * @author vbohudskyi
 * @version 1.0
 */
public class ResourcesMenu extends Menu {
    
    private List<MenuItemModel> items = null; // Resources menu items list is stored here
    private static final String HEADER = "----------Possible material shapes and sizes-----------";
    
    /**
     * Resources menu default constructor. 
     * Creates a resources menu
     */
    public ResourcesMenu() {
        super(HEADER, M.menus.RESOURCE_MENU);
        items = new ArrayList<>();
        items.add(new MenuItemModel(1, M.menu_items.ANTIPRISM));
        items.add(new MenuItemModel(2, M.menu_items.CUPOLAE));
        items.add(new MenuItemModel(3, M.menu_items.FRUSTA));
        items.add(new MenuItemModel(4, M.menu_items.PRISM));
        items.add(new MenuItemModel(5, M.menu_items.PYRAMID));
        items.add(new MenuItemModel(6, M.menu_items.SPHERE));
        items.add(new MenuItemModel(9, M.menu_items.WEDGE));
        items.add(new MenuItemModel(0, M.menu_items.QUIT));
    }
    
    @Override
    public void populateMenu()
    {
        setItems(items);
        setOnItemChosenListener(menuItemChosenListener);
    }
    
    /**
     * A listeners, which fires, when menu item is chosen
     */
    private final MenuItemChosenListener menuItemChosenListener = (MenuItemModel item, int menuType) -> {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    };
    
}
