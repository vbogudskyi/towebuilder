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
import com.building.agency.utils.PrintUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Declares a main menu 
 * @author vbohudskyi
 * @version 1.0
 */
public class MainMenu extends Menu {
    
    private List<MenuItemModel> items = null; // Main menu items list is stored there
    private static final String HEADER = "----------Tower construction types-----------";
    private ApplicationContext context = null; // application context is stored here
    /**
     * 
     * Main menu default constructor. 
     * Creates a main menu 
     * @param context - application context
     */
    public MainMenu(ApplicationContext context) {
        super(HEADER, M.menus.MAIN_MENU);
        this.context = context;
        items = new ArrayList<>();
        items.add(new MenuItemModel(1, M.menu_items.ANTIPRISM));
        items.add(new MenuItemModel(2, M.menu_items.CUPOLAE));
        items.add(new MenuItemModel(3, M.menu_items.FRUSTA));
        items.add(new MenuItemModel(4, M.menu_items.PRISM));
        items.add(new MenuItemModel(5, M.menu_items.PYRAMID));
        items.add(new MenuItemModel(6, M.menu_items.SPHERE));
        items.add(new MenuItemModel(7, M.menu_items.WEDGE));
        items.add(new MenuItemModel(0, M.menu_items.QUIT));
    }
    
    @Override
    public void populateMenu() {
        setItems(items);
        setOnItemChosenListener(itemChosenListener);
    }
    
    /**
     * A listeners, which fires, when menu item is chosen
     */
    private final MenuItemChosenListener itemChosenListener = (MenuItemModel item, int menuType) -> {  
        String managerGreeting = ((CompanyContext)context).getBusinessPlayers().getManager().getGreeting();
        String speech = ((CompanyContext)context).getBusinessPlayers().getManager().
                getSpeech(M.message.MANAGER_SPEECH);
        if(!item.getItemValue().equals(M.menu_items.QUIT))
        {
            PrintUtils.printMessage(managerGreeting);
            PrintUtils.printMessage(speech);
        }
        switch(item.getItemValue())
        {
            case M.menu_items.PYRAMID:
            {
                InputUtils.chooseMenuItem(context, M.menus.PYRAMIDS_MENU);
                break;
            }
            
            case M.menu_items.PRISM:
            {
                InputUtils.chooseMenuItem(context, M.menus.PRISM_MENU);
                break;
            }
            
            case M.menu_items.SPHERE:
            {
                InputUtils.chooseMenuItem(context, M.menus.SPHERE_MENU);
                break;
            }
            
            case M.menu_items.FRUSTA:
            {
                InputUtils.chooseMenuItem(context, M.menus.FRUSTA_MENU);
                break;
            }
            
            case M.menu_items.CUPOLAE:
            {
                
                InputUtils.chooseMenuItem(context, M.menus.CUPOLAE_MENU);
                break;
            }
            
            case M.menu_items.ANTIPRISM:
            {
                InputUtils.chooseMenuItem(context, M.menus.ANTIPRISM_MENU);
                break;
            }
            
            case M.menu_items.WEDGE:
            {
                InputUtils.chooseMenuItem(context, M.menus.WEDGES_MENU);
                break;
            }
            
            case M.menu_items.QUIT:
            {
                System.exit(0);
                break;
            }
        }
    };
    
}
