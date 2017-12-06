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
        this.context = context; // application context is assigned here
    }
    /**
     * Method creates a new menu
     * @param menu_type type of creating menu
     * @return created menu object
     */ 
    private Menu createMenu(int menu_type)
    {
        Menu menu = null; // current menu
        switch(menu_type)
        {
            case M.menus.RESOURCE_MENU: // resources menu is chosen
            { 
                menu = new ResourcesMenu(); //resources menu is created
                break;
            }
            case M.menus.MAIN_MENU: // main menu is chosen
            {
                menu = new MainMenu(context); //main menu is created
                break;
            }
            case M.menus.PYRAMIDS_MENU: // pyramids menu is chosen
            {
                menu = new PyramidsMenu(context); //pyramids menu is created
                break;
            }
            case M.menus.PRISM_MENU: // prism menu is chosen
            {
                menu = new PrismMenu(context); //prism menu is created
                break;
            }
            case M.menus.SPHERE_MENU: // sphere menu is chosen
            {
                menu = new SpheresMenu(context); //spheres menu is created
                break;
            }
            case M.menus.FRUSTA_MENU: // frusta menu is chosen
            {
                menu = new FrustaMenu(context); //frusta menu is created
                break;
            }
            case M.menus.CUPOLAE_MENU: // cupolae menu is chosen
            {
                menu = new CupolaeMenu(context); //cupolae menu is created
                break;
            }
            case M.menus.ANTIPRISM_MENU: // antiprism menu is chosen
            {
                menu = new AntiprismMenu(context); //antiprism menu is created
                break;
            }
            case M.menus.WEDGES_MENU: // wedges menu is chosen
            {
                menu = new WedgesMenu(context); //wedges menu is created
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
        if(mainMenu == null) //if main menu is not instantiated
        {
           mainMenu = createMenu(M.menus.MAIN_MENU); // creates a main menu
           mainMenu.populateMenu(); //
        }
        
        return mainMenu;
    }
    
    /**
     * Method generates a resource menu
     * @return menu
     */
    public Menu getResourceMenu()
    {
        if(resourceMenu == null) // if resources menu is not instantiated
        {
           resourceMenu = createMenu(M.menus.RESOURCE_MENU); // creates a resources menu
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
        Menu currentMenu = null; // a current sub menu to work
        switch(position)
         {
             case M.menus.SPHERE_MENU: // if Spheres are chosen
             {
                 if(spheresSubMenu == null) // check if spheres sub menu is created
                 {
                     spheresSubMenu = createMenu(position); // creates a spheres sub menu
                 }
                 currentMenu = spheresSubMenu; // current menu is spheres menu
                 break;
             }
             case M.menus.PYRAMIDS_MENU: // if Pyramids are chosen
             {
                 if(pyramidSubMenu == null)
                 {
                     pyramidSubMenu = createMenu(position); // creates a pyramids sub menu
                 }
                 currentMenu = pyramidSubMenu; // current menu is pyramids sub menu
                 break;
             }
             case M.menus.PRISM_MENU: // if Prisms are chosen
             { 
                 if(prismsSubMenu == null)
                 {
                     prismsSubMenu = createMenu(position); // creates a prism sub menu
                 }
                 currentMenu = prismsSubMenu; // current menu is prism sub menu
                 break;
             }
             case M.menus.FRUSTA_MENU: // if Frustas are chosen
             {
                 if(frustaMenu == null)
                 {
                     frustaMenu = createMenu(position); // creates a frusta sub menu
                 }
                 currentMenu = frustaMenu; // current menu is frusta sub menu
                 break;
             }
             case M.menus.CUPOLAE_MENU: // if Cupolae are chosen
             {
                 if(cupolaeMenu == null)
                 {
                     cupolaeMenu = createMenu(position); // creates a cupolae sub menu
                 }
                 currentMenu = cupolaeMenu; // current menu is cupolae sub menu
                 break;
             }
             case M.menus.ANTIPRISM_MENU: // if Antiprism are chosen
             {
                 if(antiprismMenu == null)
                 {
                     antiprismMenu = createMenu(position); // creates a antiprism sub menu
                 }
                 currentMenu = antiprismMenu; // current menu is antiprism sub menu
                 break;
             }
             case M.menus.WEDGES_MENU: // if Wedges are chosen
             {
                 if(wedgesMenu == null)
                 {
                     wedgesMenu = createMenu(position); // creates a wedges sub menu
                 }
                 currentMenu = wedgesMenu; // current menu is wedges sub menu
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
            System.out.println(menu.getHeader()); // header menu is displayed
            List<MenuItemModel> items = menu.getItems(); // menu items are retrieved
            items.forEach((item) -> {
                System.out.println(item.getItemPosition()+": "+item.getItemValue()); // each element of menu is printed
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
        String message = "Please, make your choice: "; // current console message
        String error_message = "This option is not available in the menu. Please try again"; // error message
        String choice = ""; // user choice is stored here
        while(true)
        {
            System.out.print(message); // console message is printed
            choice = scanner.nextLine(); // user choice is expected here
            if(items.contains(choice)) // if choice is relevant - choice is accepted
                break;
            else
            {
                System.out.println(error_message); // else - error message is printed
            }
        }
        return choice;
     }
}
