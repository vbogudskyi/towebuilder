/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu.portfolio;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.io.model.FrustaModel;
import com.building.agency.cofigure.io.model.PortfolioModel;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.utils.M;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Declare Frusta Portfolio Menu
 * @author nnastas
 * @version 1.0
 */
public class FrustaPortfolioMenu extends PortfolioMenu {
    
    private FrustaModel[] frustas = null; //serialized from json frustas are stored here
    
    /**
     * Default constructor for Frusta Portfolio Menu
     * @param context - application context
     * @version 1.0
     * @throws java.io.IOException
     */

    public FrustaPortfolioMenu(ApplicationContext context) throws IOException {
        super(context, M.menus.FRUSTA_PORTFOLIO_MENU);
        PortfolioModel porfolios = ((CompanyContext)context).getApplicationContentProvider().
                getFiguresPorfolio(); // portfolio figures a created here
        frustas = porfolios.getFrusta(); // serialized frustas are stored here
    }

    @Override
    public List<MenuItemModel> retrieveItems() {
       List<MenuItemModel> items = new ArrayList<>();
       int i = 1;
       for(FrustaModel frusta:frustas)
       {
          items.add(new MenuItemModel(i++, frusta.getName()));
       }
       items.add (new MenuItemModel(9, M.menu_items.BACK));
       items.add (new MenuItemModel(0, M.menu_items.QUIT));
       
       return items;
    }
    
}
