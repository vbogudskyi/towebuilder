/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.menu.Menu;
import java.util.Scanner;

/**
 * Declares input utilities
 * @author vbohudskyi
 * @version 1.0
 */
public class InputUtils {
    
    /**
     * Method gets a customer's name
     * @param scanner - scanner, which retrieves a customer's name from a console
     * @return - customer name
     */
    public static final String getCustomerName(Scanner scanner)
    {
        String message = "Please enter your name: ";
        String updated_message = "Please re-enter your name: ";
        String current_message = message;
        String customer = null;
         while (StringUtils.isNullOrEmpty(customer)) {
            System.out.print(current_message);
            customer = scanner.nextLine();
            if (StringUtils.isNullOrEmpty(customer)) {
                current_message = updated_message;
                scanner.nextLine();
            }
        }
         
       return customer;
    }
    
    /**
     * Prints menu and chooses a menu item
     * @param context - application context
     * @param menuType - type of current menu
     */
    public static final void chooseMenuItem(ApplicationContext context, int menuType)
    {
       CompanyContext ctx = (CompanyContext)context; 
       Menu menu;
       switch(menuType)
       {
           case M.menus.MAIN_MENU:
           {
               menu = ctx.getMenus().getMainMenu();
               break;
           }
           
           default:
           {
               menu = ctx.getMenus().getSubMenu(menuType);
               break;
           }
       }
       if(menu != null)
       {
           menu.populateMenu();
           ctx.getMenus().printMenu(menu);
           String choice = ctx.getMenus().makeUserChoice(menu.getItemsPositions(), ctx.getConsoleScanner());
           menu.populateUserDesicion(choice);
       }
    }
    
}
