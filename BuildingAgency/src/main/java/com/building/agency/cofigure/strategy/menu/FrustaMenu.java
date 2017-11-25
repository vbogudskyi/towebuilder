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
 * Declares a frustum menu
 * Create a menu of frustum
 * @author vbohudskyi
 * @version 1.0
 */
public class FrustaMenu extends Menu {

    private List<MenuItemModel> items = null; // Frusta menu items list is stored here
    private static final String HEADER = "----------Frusta bases-----------";
    private ApplicationContext context = null; // application context is stored here
    
    /**
     * Default frustum menu constructor
     * @param context - application context
     * @version 1.0
     * 
     */
    public FrustaMenu(ApplicationContext context) {
        super(HEADER, M.menus.FRUSTA_MENU);
        this.context = context;
        items = new ArrayList<>();
        items.add(new MenuItemModel(1, M.menu_items.TRIANGLE));
        items.add(new MenuItemModel(2, M.menu_items.RECTANGLE));
        items.add(new MenuItemModel(3, M.menu_items.CIRCLE));
        items.add(new MenuItemModel(4, M.menu_items.ROMB));
        items.add(new MenuItemModel(5, M.menu_items.POLYGON));
        items.add(new MenuItemModel(6, M.menu_items.PARALLELOGRAMM));
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
