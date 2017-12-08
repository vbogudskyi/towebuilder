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
 * Declares a wedges menu
 * @author vbohudskyi
 * @version 1.0
 */
public class WedgesMenu extends Menu {

    private List<MenuItemModel> items = null; // Wedge menu items list is stored here
    private static final String HEADER = "----------Wedges bases-----------";
    private ApplicationContext context = null; // application context is stored here
    
    /**
     * 
     * @param context 
     */
    public WedgesMenu(ApplicationContext context) {
        super(HEADER, M.menus.WEDGES_MENU);
        this.context = context;
        items = new ArrayList<>();
        // Menu items are added here
        items.add(new MenuItemModel(1, M.menu_items.PARALLEL_TRIANGLE));
        items.add(new MenuItemModel(2, M.menu_items.TETRAHEDRON));
        items.add(new MenuItemModel(7, M.menu_items.PORTFOLIO));
        items.add(new MenuItemModel(9, M.menu_items.BACK));
        items.add(new MenuItemModel(0, M.menu_items.QUIT));
    }

    @Override
    public void populateMenu() {
        setItems(items); // menu items are set
        setOnItemChosenListener(menuItemChosenListener); // menu listener is set
    }
    
     /**
     * A listeners, which fires, when menu item is chosen
     */
    private final MenuItemChosenListener menuItemChosenListener = (MenuItemModel item, int menuType) -> {
         CompanyContext ctx = (CompanyContext)context;
         switch(item.getItemValue())
         {
             case M.menu_items.PARALLEL_TRIANGLE: // if paallel triangle is chosen
             {
                 // parallel triangle is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.RECTANGLE, M.figure_3d.WEDGE);
                 break;
             }
             
             case M.menu_items.TETRAHEDRON: // if tetrahedron is chosen
             {
                 // tetrahedron is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.RECTANGLE,
                         M.figures_2d.TRIANGLE, M.figure_3d.WEDGE);
                 break;
             }
             case M.menu_items.PORTFOLIO: // if portfolio is chosen
             {
                 InputUtils.chooseMenuItem(context, M.menus.WEDGES_PORTFOLIO_MENU); // portfolio is shown
                 break;
             }
             case M.menu_items.BACK: // Back to main menu
             {
                 InputUtils.chooseMenuItem(context, M.menus.MAIN_MENU);
                 break;
             }
             
             case M.menu_items.QUIT: // quit an application
             {
                 System.exit(0);
                 break;   
             }
         }
    };
    
}
