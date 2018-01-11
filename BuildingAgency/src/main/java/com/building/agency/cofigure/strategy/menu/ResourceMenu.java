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
import com.building.agency.utils.M;
import java.util.ArrayList;
import java.util.List;

/**
 * Declares a building resource menu
 * @author vbohudskyi
 * @version 1.0
 */
public class ResourceMenu extends Menu {
    
    private static final String HEADER = "*********Possible material shapes and sizes***********"; // menu header 
    private List<MenuItemModel> items = null; // resource menu items are stored here
    private ApplicationContext context = null; // application context is stored here

    /**
     * Default constructor of resource menu
     * @param context - application context
     * @version 1.0
     */
    public ResourceMenu(ApplicationContext context) {
        super(HEADER, M.menus.RESOURCE_MENU);
        this.context = context;
        // menu items are added
        items = new ArrayList<>();
        items.add(new MenuItemModel(1, M.menu_items.TRIANGLE));
        items.add(new MenuItemModel(2, M.menu_items.RECTANGLE));
        items.add(new MenuItemModel(3, M.menu_items.CIRCLE));
        items.add(new MenuItemModel(4, M.menu_items.ROMB));
        items.add(new MenuItemModel(5, M.menu_items.POLYGON));
        items.add(new MenuItemModel(6, M.menu_items.PARALLELOGRAMM));
        
    }

    @Override
    public void populateMenu() {
        setItems(items); // menu items are set
        setOnItemChosenListener(menuItemChosenListener); // menu listener is set
    }
    
    /**
     * A listeners, which fires, when menu item is chosen
     */
    private final MenuItemChosenListener menuItemChosenListener = (MenuItemModel item, int menuType1) -> {
        CompanyContext ctx = (CompanyContext)context;
        switch(item.getItemValue())
        {
            case M.menu_items.TRIANGLE: // if triangle is chosen
            {
                // Triangle resource is created
                ctx.getFigures().buildFigure2D(M.figures_2d.TRIANGLE);
                break;
            }
            case M.menu_items.RECTANGLE: // if rectangle is chosen
            {
                // Rectangle resource is created
                ctx.getFigures().buildFigure2D(M.figures_2d.RECTANGLE);
                break;
            }
            case M.menu_items.CIRCLE: // if circle is chosen
            {
                // Circle resource is created
                ctx.getFigures().buildFigure2D(M.figures_2d.CIRCLE);
                break;
            }
            case M.menu_items.ROMB: // if romb is chosen
            {
                // Romb resource is created
                ctx.getFigures().buildFigure2D(M.figures_2d.ROMB);
                break;
            }
            case M.menu_items.POLYGON: // if polygon is chosen
            {
                // Polygon resource is created
                ctx.getFigures().buildFigure2D(M.figures_2d.POLYGON);
                break;
            }
            case M.menu_items.PARALLELOGRAMM: // if parallelogramm is chosen
            {
                // Parallelogramm resource is created
                ctx.getFigures().buildFigure2D(M.figures_2d.PARALLELOGRAMM);
                break;
            }
        }
    };
}
