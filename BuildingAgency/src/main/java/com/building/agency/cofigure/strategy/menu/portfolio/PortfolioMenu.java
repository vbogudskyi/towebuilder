/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu.portfolio;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.menu.Menu;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.cofigure.menu.callback.MenuItemChosenListener;
import com.building.agency.utils.InputUtils;
import com.building.agency.utils.M;
import java.util.List;

/**
 * Declares the Portfolio of existing achievements
 * @author nnastas
 * @version 1.0
 */
public abstract class PortfolioMenu extends Menu {
    
    private List<MenuItemModel> items = null; // portfolio menu items list is stored here
    private static final String HEADER = "----------Portfolio Menu-----------";
    private ApplicationContext context = null; // application context is stored here
   
    /**
     * Default constructor for Portfolio Menu
     * @param context -application context
     * @param menuType - portfolio menu type
     * @version 1.0
     */ 
    public PortfolioMenu(ApplicationContext context, int menuType) {
        super(HEADER, menuType);
        this.context = context;
   
    }
    
    /**
     * Method retrieve Menu items
     * @return - Menu items
     * @version 1.0
     */
    public abstract List<MenuItemModel> retrieveItems();
    
    @Override
    public void populateMenu() {
        
        items = retrieveItems();//retrieve the item number and name
        setItems(items); // set the item number and name into the menu
        setOnItemChosenListener(menuItemChosenListener);//set the item number and name on the Item Chose Listener
        
    }
    //calling abstract class and implementing methods
    //the Listener calls when the menu item is chosen
    private final MenuItemChosenListener menuItemChosenListener = new MenuItemChosenListener() {
        @Override
        public void onItemChosen(MenuItemModel item, int menuType) {
           CompanyContext comCtx = (CompanyContext) context;
           
           switch (item.getItemValue()) {
               case M.menu_items.BACK: {
                   InputUtils.chooseMenuItem(context, M.menus.MAIN_MENU);
                   break;
               }
               case M.menu_items.QUIT: {
                   System.exit(0);
                   break;
               }
               case M.menu_items.EVOLUTION_TOWER: {
                   System.out.println("Evolution Tower Parameters");
                   break;
               }
               case M.menu_items.WORLD_TRADE_CENTER: {
                   System.out.println("One World Trade Center");
                   break;
               }
           }
        }
    };
    
}
