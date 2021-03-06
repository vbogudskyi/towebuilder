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
        String message = "Please enter your name: "; // Main prompt message
        String updated_message = "Please re-enter your name: "; // Updated prompt message
        String current_message = message; // current message is set
        String customer = null; // customer reference is stored here
         while (StringUtils.isNullOrEmpty(customer)) { // a loop works until the customer name is entered
            System.out.print(current_message); // current message is printed on the console
            customer = scanner.nextLine(); // customer name is expected here
            if (StringUtils.isNullOrEmpty(customer)) { //check if the customer name is entered
                current_message = updated_message; //current message is updated message
                scanner.nextLine(); // customer name is expected here
            }
        }
         
       return customer; //return a customer name
    }
    
    /**
     * Prints menu and chooses a menu item
     * @param context - application context
     * @param menuType - type of current menu
     */
    public static final void chooseMenuItem(ApplicationContext context, int menuType)
    {
       CompanyContext ctx = (CompanyContext)context; // context explicit cast to CpmpanyContext
       Menu menu = ctx.getMenus().getCurrentMenu(menuType); // menu is built and created
       if(menu != null)
       {
           menu.populateMenu(); // menu ites and listeners are set
           ctx.getMenus().printMenu(menu); // menu is printed on the console
           // item menu is chosen by the user
           String choice = ctx.getMenus().makeUserChoice(menu.getItemsPositions(), ctx.getConsoleScanner());
           menu.populateUserDesicion(choice); // check if user decision is relevant
       }
    }
    
    /**
     * Gets a double value from console
     * @param context - application context
     * @param message - console message
     * @param error_message - error console method
     * @return - double value
     */
    public static final double getDoubleValue(ApplicationContext context, String message, String error_message)
    {
        PrintUtils.printMessage(message); // main message is printed
        Scanner scanner = context.getConsoleScanner(); // console scanner is assigned
        double value = 0; // current value is assigned
        while(!scanner.hasNextDouble()) // if value is not double
        {
            PrintUtils.printMessage(error_message); // error message is printed
            scanner.nextLine(); // skip current line
        }
        value = Double.parseDouble(scanner.nextLine()); // get entered double value
        return value;
    }
    
    /**
     * Gets an integer value from a console
     * @param context - application context
     * @param message - console message
     * @param error_message - error console message
     * @return integer value
     */
    public static final int getIntValue(ApplicationContext context, String message, String error_message)
    {
        return (int)getDoubleValue(context, message, error_message); // truncate double to int
    }    
    
}
