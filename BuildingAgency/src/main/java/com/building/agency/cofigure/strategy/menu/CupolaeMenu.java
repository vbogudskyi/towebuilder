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
 * Declares a cupola menu
 * @author vbohudskyi
 * @version 1.0
 */
public class CupolaeMenu extends Menu {

    private List<MenuItemModel> items = null; // Cupola menu items list is stored here
    private static final String HEADER = "----------Cupola bases-----------";
    private ApplicationContext context = null; // application context is stored here
    
    /**
     * Default constructor of a cupola menu
     * Create a cupola menu
     * @param context - application context
     */
    public CupolaeMenu(ApplicationContext context) {
        super(HEADER, M.menus.CUPOLAE_MENU);
        this.context = context;
        // menu items are added here
        items = new ArrayList<>();
        items.add(new MenuItemModel(1, M.menu_items.DIAGONAL));
        items.add(new MenuItemModel(2, M.menu_items.TRIANGULAR));
        items.add(new MenuItemModel(3, M.menu_items.SQUARE));
        items.add(new MenuItemModel(7, M.menu_items.PORTFOLIO));
        items.add(new MenuItemModel(9, M.menu_items.BACK));
        items.add(new MenuItemModel(0, M.menu_items.QUIT));
    }

    @Override
    public void populateMenu() {
        setItems(items); //menu items are set
        setOnItemChosenListener(menuItemChosenListener); //menu listener is set
    }
    
    /**
     * A listeners, which fires, when menu item is chosen
     */
    private final MenuItemChosenListener menuItemChosenListener = (MenuItemModel item, int menuType) -> {
         CompanyContext ctx = (CompanyContext)context;
         switch(item.getItemValue())
         {
             case M.menu_items.DIAGONAL: // if diagonal cupolae is chosen
             {
                 // diagonal cupolae is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.RECTANGLE,
                         M.figure_3d.DIAGONAL_CUPOLAE);
                 break;
             }
             
             case M.menu_items.TRIANGULAR: // if triangular cupolae is chosen
             {
                 // triangular cupolae is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.POLYGON, 
                         M.figures_2d.TRIANGLE, M.figure_3d.TRANGULAR_CUPOLAE);
                 break;
             }
             
             case M.menu_items.SQUARE: // if square cupolae is chosen
             {
                 // square cupolae is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.POLYGON, 
                         M.figures_2d.RECTANGLE, M.figure_3d.TRANGULAR_CUPOLAE);
                 break;
             }
             
             case M.menu_items.PORTFOLIO: // if portfolio is chosen
             {
                 InputUtils.chooseMenuItem(context, M.menus.CUPOLAE_PORTFOLIO_MENU); // show a portfolio
                 break;
             }
             case M.menu_items.BACK: // back to main menu
             {
                 InputUtils.chooseMenuItem(context, M.menus.MAIN_MENU);
                 break;
             }
             
             case M.menu_items.QUIT: // leave an application
             {
                 System.exit(0);
                 break;   
             }
         }
    };
    
}
