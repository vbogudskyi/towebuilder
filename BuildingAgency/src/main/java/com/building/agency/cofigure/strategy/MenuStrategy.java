/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy;


import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.menu.Menu;
import com.building.agency.cofigure.menu.MenuItemModel;
import com.building.agency.cofigure.strategy.menu.AntiprismMenu;
import com.building.agency.cofigure.strategy.menu.CupolaeMenu;
import com.building.agency.cofigure.strategy.menu.FrustaMenu;
import com.building.agency.cofigure.strategy.menu.MainMenu;
import com.building.agency.cofigure.strategy.menu.PrismMenu;
import com.building.agency.cofigure.strategy.menu.PyramidsMenu;
import com.building.agency.cofigure.strategy.menu.ResourcesMenu;
import com.building.agency.cofigure.strategy.menu.SpheresMenu;
import com.building.agency.cofigure.strategy.menu.WedgesMenu;
import com.building.agency.utils.M;
import java.util.List;
import java.util.Scanner;

/**
 * Declares different types of menu and maintains it
 * @author vbohudskyi
 * @version 1.0
 */
public class MenuStrategy {
    
    private ApplicationContext context = null; // Context of application
    
    private Menu mainMenu = null; //Main menu reference is stored here
    private Menu pyramidSubMenu = null; //Pyramids submenu is ctored here 
    private Menu prismsSubMenu = null; // Prisms submenu is stored here
    private Menu spheresSubMenu = null; // Spheres sub menu us stored here
    private Menu frustaMenu = null; // Frusta sub menu is stored here
    private Menu resourceMenu = null; //Resources menu is stored here
    private Menu cupolaeMenu = null; // Cupola menu is stored here
    private Menu antiprismMenu = null; // antiprism menu is stored here
    private Menu wedgesMenu = null; // wedges menu is stored here
    /**
     * Menu strategy default constructor
     * @param context application context
     */
    public MenuStrategy(ApplicationContext context)
    {
        this.context = context;
    }
    /**
     * Method creates a new menu
     * @param menu_type type of creating menu
     * @return created menu object
     */ 
    private Menu createMenu(int menu_type)
    {
        Menu menu = null;
        switch(menu_type)
        {
            case M.menus.RESOURCE_MENU:
            {
                menu = new ResourcesMenu();
                break;
            }
            case M.menus.MAIN_MENU:
            {
                menu = new MainMenu(context);
                break;
            }
            case M.menus.PYRAMIDS_MENU:
            {
                menu = new PyramidsMenu(context);
                break;
            }
            case M.menus.PRISM_MENU:
            {
                menu = new PrismMenu(context);
                break;
            }
            case M.menus.SPHERE_MENU:
            {
                menu = new SpheresMenu(context);
                break;
            }
            case M.menus.FRUSTA_MENU:
            {
                menu = new FrustaMenu(context);
                break;
            }
            case M.menus.CUPOLAE_MENU:
            {
                menu = new CupolaeMenu(context);
                break;
            }
            case M.menus.ANTIPRISM_MENU:
            {
                menu = new AntiprismMenu(context);
                break;
            }
            case M.menus.WEDGES_MENU:
            {
                menu = new WedgesMenu(context);
                break;
            }
        }
        return menu;
    }
    
    /**
     * Method generates a main menu
     * @return menu
     */
    public Menu getMainMenu()
    {
        if(mainMenu == null)
        {
           mainMenu = createMenu(M.menus.MAIN_MENU);
           mainMenu.populateMenu();
        }
        
        return mainMenu;
    }
    
    /**
     * Method generates a resource menu
     * @return menu
     */
    public Menu getResourceMenu()
    {
        //System.out.println(String.format(M.dialogs.MANAGER_SPEECH3, MANAGER));
        if(resourceMenu == null)
        {
           resourceMenu = createMenu(M.menus.RESOURCE_MENU);
        }
        
        return resourceMenu;
    }
    
    /**
     * Method generates sub menus
     * @param position - type of sub menu
     * @return menu
     */
    public Menu getSubMenu(int position)
    {
        Menu currentMenu = null;
        switch(position)
         {
             case M.menus.SPHERE_MENU: // if Spheres are chosen
             {
                 if(spheresSubMenu == null)
                 {
                     spheresSubMenu = createMenu(position);
                 }
                 currentMenu = spheresSubMenu;
                 break;
             }
             case M.menus.PYRAMIDS_MENU: // if Pyramids are chosen
             {
                 if(pyramidSubMenu == null)
                 {
                     pyramidSubMenu = createMenu(position);
                 }
                 currentMenu = pyramidSubMenu;
                 break;
             }
             case M.menus.PRISM_MENU: // if Prisms are chosen
             { 
                 if(prismsSubMenu == null)
                 {
                     prismsSubMenu = createMenu(position);
                 }
                 currentMenu = prismsSubMenu;
                 break;
             }
             case M.menus.FRUSTA_MENU: // if Frustas are chosen
             {
                 if(frustaMenu == null)
                 {
                     frustaMenu = createMenu(position);
                 }
                 currentMenu = frustaMenu;
                 break;
             }
             case M.menus.CUPOLAE_MENU:
             {
                 if(cupolaeMenu == null)
                 {
                     cupolaeMenu = createMenu(position);
                 }
                 currentMenu = cupolaeMenu;
                 break;
             }
             case M.menus.ANTIPRISM_MENU:
             {
                 if(antiprismMenu == null)
                 {
                     antiprismMenu = createMenu(position);
                 }
                 currentMenu = antiprismMenu;
                 break;
             }
             case M.menus.WEDGES_MENU:
             {
                 if(wedgesMenu == null)
                 {
                     wedgesMenu = createMenu(position);
                 }
                 currentMenu = wedgesMenu;
                 break;
             }
         }
         return currentMenu;   
    }
    
    /**
     * method prints an avaliable menu at the console
     * @param menu printing menu
     */
    public void printMenu(Menu menu)
    {
        if(menu != null)
        {
            System.out.println(menu.getHeader());
            List<MenuItemModel> items = menu.getItems();
            items.forEach((item) -> {
                System.out.println(item.getItemPosition()+": "+item.getItemValue());
            });
        }
    }
    
    /**
     * Method asks a user to make a choice according to menu
     * @param items available choices
     * @param scanner - console scanner
     * @return choice
     */
     public String makeUserChoice(List<String> items, Scanner scanner)
     {
        String message = "Please, make your choice: ";
        String error_message = "This option is not available in the menu. Please try again";
        String choice = "";
        while(true)
        {
            System.out.print(message);
            choice = scanner.nextLine();
            if(items.contains(choice))
                break;
            else
            {
                System.out.println(error_message);
            }
        }
        return choice;
     }
}
