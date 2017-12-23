/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu.portfolio;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.io.model.PortfolioModel;
import com.building.agency.cofigure.io.model.PrismModel;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.utils.M;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Declare Prism Portfolio Menu
 * @author nnastas
 * @version 1.0
 */
public class PrismPortfolioMenu extends PortfolioMenu{
    
    private PrismModel []prisms = null; // parsed prisms are stored here
    
    /**
     * Default constructor for Prism Portfolio Menu
     * @param context - application context
     * @version 1.0
     * @throws java.io.IOException
     */
    public PrismPortfolioMenu(ApplicationContext context) throws IOException {
        super(context, M.menus.PRISM_PORTFOLIO_MENU);
        PortfolioModel porfolios = ((CompanyContext)context).getApplicationContentProvider().
                getFiguresPorfolio(); // portfolio figures a created here
        prisms = porfolios.getPrisms(); // serialized prisms are stored here
    }

    @Override
    public List<MenuItemModel> retrieveItems() {
     List<MenuItemModel> items = new ArrayList<>();
     int i = 1;
     for(PrismModel prism:prisms)
     {
         items.add(new MenuItemModel(i++, prism.getName()));
     }
     items.add (new MenuItemModel(9, M.menu_items.BACK));
     items.add (new MenuItemModel(0, M.menu_items.QUIT));
     
        return items;   
    }
}
