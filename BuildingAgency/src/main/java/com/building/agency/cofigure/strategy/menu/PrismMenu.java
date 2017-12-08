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
 * Declares a prism menu
 * @author vbohudskyi
 * @version 1.0
 */
public class PrismMenu extends Menu {
    
    private List<MenuItemModel> items = null; // Prism menu items list is stored here
    private static final String HEADER = "----------Prism bases-----------";
    private ApplicationContext context = null; // application context is stored here
    /**
     * Prism menu default constructor. 
     * Creates a menu of prisms
     * @param context - application context
     */
    public PrismMenu(ApplicationContext context) {
        super(HEADER, M.menus.PRISM_MENU);
        this.context = context;
        // Menu elements are added
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
        setItems(items); // menu elements are set
        setOnItemChosenListener(menuItemChosenListener); // menu listener is set
    }
    
     /**
     * A listeners, which fires, when menu item is chosen
     */
    private final MenuItemChosenListener menuItemChosenListener = (MenuItemModel item, int menuType) -> {
         CompanyContext ctx = (CompanyContext)context;
         switch(item.getItemValue())
         {
             case M.menu_items.TRIANGLE:// If triangle is chosen
             {   
                 //triangular prism is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.TRIANGLE, M.figure_3d.PRISM);
                 break;
             }
             
             case M.menu_items.RECTANGLE: // If rectangle is chosen
             {   
                 //rectangular prism is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.RECTANGLE, M.figure_3d.PRISM);
                 break;
             }
             
             case M.menu_items.CIRCLE: // If circle is chosen
             {   
                //cylinder is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.CIRCLE, M.figure_3d.PRISM);
                 break;
             }
             
             case M.menu_items.ROMB: // If romb is chosen
             {   
                 //romb prism is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.ROMB, M.figure_3d.PRISM);
                 break;
             }
             
             case M.menu_items.POLYGON: // If polygon is chosen
             {   
                 //polygon prism is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.POLYGON, M.figure_3d.PRISM);
                 break;
             }
             
             case M.menu_items.PARALLELOGRAMM: // If parallelogramm is chosen
             {   
                 //parallelogramm prism is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.PARALLELOGRAMM, M.figure_3d.PRISM);
                 break;
             }
             
             case M.menu_items.PORTFOLIO: // if portfolio is chosen
             {
                 InputUtils.chooseMenuItem(context, M.menus.PRISM_PORTFOLIO_MENU); // show portfolio
                 break;
             }
             case M.menu_items.BACK: // Back to main menu
             {
                 InputUtils.chooseMenuItem(context, M.menus.MAIN_MENU);
                 break;
             }
             
             case M.menu_items.QUIT: // leave the application
             {
                 System.exit(0);
                 break;   
             }
         }
    };
}
