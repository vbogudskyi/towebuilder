/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.menu.portfolio;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.io.model.PortfolioModel;
import com.building.agency.cofigure.io.model.PyramidModel;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.utils.M;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Declare Pyramids Portfolio Menu
 * @author nnastas
 * @version 1.0
 */
public class PyramidsPortfolioMenu extends PortfolioMenu{
    
    private PyramidModel[] pyramids = null; // serialized pyramids are stored here
    
    /**
     * Default constructor for Pyramids Portfolio Menu
     * @param context - application context
     * @version 1.0
     * @throws java.io.IOException
     */
    public PyramidsPortfolioMenu(ApplicationContext context) throws IOException {
        super(context, M.menus.PYRAMIDS_PORTFOLIO_MENU);
        PortfolioModel porfolios = ((CompanyContext)context).getApplicationContentProvider().
                getFiguresPorfolio(); // portfolio figures a created here
        pyramids = porfolios.getPyramid(); // serialized pyramids are stored here
    }
    
    @Override
    public List<MenuItemModel> retrieveItems() {
        List<MenuItemModel> items = new ArrayList<>();
        int i = 1;
        for(PyramidModel pyramid:pyramids)
        {
           items.add(new MenuItemModel(i++, pyramid.getName()));
        }
        items.add (new MenuItemModel(9, M.menu_items.BACK));//menu item BACK is added
        items.add (new MenuItemModel(0, M.menu_items.QUIT));//menu item QUIT is added
     
        return items;   
    }
    
}
