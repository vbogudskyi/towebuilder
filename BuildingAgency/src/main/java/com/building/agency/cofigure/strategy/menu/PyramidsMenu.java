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
 * Declares a menu of a pyramid
 * @author vbohudskyi
 * @version 1.0
 */
public class PyramidsMenu extends Menu {

    private List<MenuItemModel> items = null; //Pyramids menu items list is stored here
    private static final String HEADER = "----------Pyramid bases-----------";
    private ApplicationContext context = null; //application context is stored here
    
    /**
     * Pyramids menu default constructor.
     * Creates a menu of pyramids
     * @param context - application context
     */
    public PyramidsMenu(ApplicationContext context) {
        super(HEADER, M.menus.PYRAMIDS_MENU);
        this.context = context;
        // menu items are added
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
              case M.menu_items.TRIANGLE: // if triangle is chosen
             {   
                  // triangular pyramid is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.TRIANGLE, M.figure_3d.PYRAMID);
                 break;
             }
             
             case M.menu_items.RECTANGLE: // if rectangle is chosen
             {   
                 // rectangular pyramid is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.RECTANGLE, M.figure_3d.PYRAMID);
                 break;
             }
             
             case M.menu_items.CIRCLE: // if circle is chosen
             {   
                 // conus is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.CIRCLE, M.figure_3d.PYRAMID);
                 break;
             }
             
             case M.menu_items.ROMB: // if romb is chosen
             {   
                 // romb pyramid is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.ROMB, M.figure_3d.PYRAMID);
                 break;
             }
             
             case M.menu_items.POLYGON: // if polygon is chosen
             {   
                 // polygon pyramid is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.POLYGON, M.figure_3d.PYRAMID);
                 break;
             }
             
             case M.menu_items.PARALLELOGRAMM: // if polygon is chosen
             {   
                 // parallelogramm pyramid is created
                 ctx.getApplicationContentProvider().getFigure3D(M.figures_2d.PARALLELOGRAMM, M.figure_3d.PYRAMID);
                 break;
             }
              case M.menu_items.PORTFOLIO: //if portfolio is chosen
              {
                  InputUtils.chooseMenuItem(context, M.menus.PYRAMIDS_PORTFOLIO_MENU); // porfolio is shown
                  break;
              }
              case M.menu_items.BACK: // Back to main menu
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
