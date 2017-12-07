/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.menu.Menu;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.cofigure.menu.callback.MenuItemChosenListener;
import com.building.agency.utils.InputUtils;
import com.building.agency.utils.M;
import java.util.ArrayList;
import java.util.List;

/**
 * Declares a spheres menu
 * @author vbohudskyi
 * @version 1.0
 */
public class SpheresMenu extends Menu {
    
    private List<MenuItemModel> items = null; //Spheres menu items list is stored here
    private static final String HEADER = "----------Sphere bases-----------";
    private ApplicationContext context = null; // application context is stored here
    /**
     * Spheres menu default constructor.
     * Creates a menu of spheres
     * @param context - application context
     */
    public SpheresMenu(ApplicationContext context) {
        super(HEADER, M.menus.SPHERE_MENU);
        this.context = context;
        items = new ArrayList<>();
        items.add(new MenuItemModel(3, M.menu_items.CIRCLE));
        items.add(new MenuItemModel(7, M.menu_items.PORTFOLIO));
        items.add(new MenuItemModel(9, M.menu_items.BACK));
        items.add(new MenuItemModel(0, M.menu_items.QUIT));
    }

    @Override
    public void populateMenu() {
        setItems(items);
        setOnItemChosenListener(menuItemChosenListener);
    }
    
     /**
     * A listeners, which fires, when menu item is chosen
     */
    private final MenuItemChosenListener menuItemChosenListener = (MenuItemModel item, int menuType) -> {
         CompanyContext ctx = (CompanyContext)context;
         switch(item.getItemValue())
         {
             case M.menu_items.CIRCLE:
             {
                 break;
             }
             
             case M.menu_items.PORTFOLIO:
             {
                 InputUtils.chooseMenuItem(context, M.menus.SPHERE_PORTFOLIO_MENU);
                 break;
             }
             
             case M.menu_items.BACK:
             {
                 InputUtils.chooseMenuItem(context, M.menus.MAIN_MENU);
                 break;
             }
             
             case M.menu_items.QUIT:
             {
                System.exit(0);
                break; 
             }
         }
    };
}
