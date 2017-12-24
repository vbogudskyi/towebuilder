/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu.portfolio;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.io.model.CupolaeModel;
import com.building.agency.cofigure.io.model.PortfolioModel;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.utils.M;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Declares Cupolae Portfolio Menu
 * @author nnastas
 * @version 1.0
 */
public class CupolaePortfolioMenu extends PortfolioMenu{
    
    private CupolaeModel[] cupolaes = null; // parsed cupolaes are stored here
    //private ModelUtils<CupolaeModel> cupolaes = null; // parsed cupolaes are stored here
    
     /**
     * Default constructor for Cupolae Portfolio Menu
     * @param context - application context
     * @version 1.0
     * @throws java.io.IOException
     */
    public CupolaePortfolioMenu(ApplicationContext context) throws IOException {
        super(context, M.menus.CUPOLAE_PORTFOLIO_MENU);
        
        PortfolioModel porfolios = ((CompanyContext)context).getApplicationContentProvider().
                getFiguresPorfolio(); // portfolio figures a created here
        cupolaes = porfolios.getCupolae();  // serialized cupolaes are stored here
        //CupolaeModel[] cupolaesTemp = porfolios.getCupolae(); // serialized cupolaes are stored here
        //cupolaes = new ModelUtils<>(CupolaeModel.class, cupolaesTemp.length);
    }

    @Override
    public List<MenuItemModel> retrieveItems() {
        List<MenuItemModel> items = new ArrayList<>();  
        int i = 1;
        for(CupolaeModel cupolae:cupolaes)
        {
           items.add(new MenuItemModel(i++, cupolae.getName()));
        }
        items.add (new MenuItemModel(9, M.menu_items.BACK));
        items.add (new MenuItemModel(0, M.menu_items.QUIT));
        
        return items;
    }
}
