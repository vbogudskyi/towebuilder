/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu.portfolio;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.utils.M;
import java.util.ArrayList;
import java.util.List;

/**
 * Declares Cupolae Portfolio Menu
 * @author nnastas
 * @version 1.0
 */
public class CupolaePortfolioMenu extends PortfolioMenu{
     /**
     * Default constructor for Cupolae Portfolio Menu
     * @param context - application context
     * @version 1.0
     */
    public CupolaePortfolioMenu(ApplicationContext context) {
        super(context, M.menus.CUPOLAE_PORTFOLIO_MENU);
    }

    @Override
    public List<MenuItemModel> retrieveItems() {
        List<MenuItemModel> items = new ArrayList<>();
        
        
        
        items.add (new MenuItemModel(9, M.menu_items.BACK));
        items.add (new MenuItemModel(0, M.menu_items.QUIT));
        
        return items;
    }
    
}
