/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency;

import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.app.hook.ApplicationShutdownHook;
import com.building.agency.utils.InputUtils;
import com.building.agency.utils.M;
import com.building.agency.utils.PrintUtils;


/**
 * Declares building agency
 * @author vbohudskyi
 * @version 1.0
 */
public class BuildingAgency extends CompanyContext {
   
    /**
     * Building agency default constructor.
     * @version 1.0
     */
    public BuildingAgency(){
        // on application stopped callback is declared here
        Runtime.getRuntime().addShutdownHook(new ApplicationShutdownHook(this)); 
    }
    
    @Override
    public void onApplicationStart() {
       PrintUtils.printMainMenuHeader(); // main menu header is printed
       getBusinessPlayers().getCounselor().print(M.message.GREETING); // the counselor welcomes a customer
       // a customer introduces him/herself
       getBusinessPlayers().getCustomer().setPlayer(InputUtils.getCustomerName(getConsoleScanner())); 
       // a customer welcomes a counselor
       getBusinessPlayers().getCustomer().print(M.message.GREETING);
       // a counselor introduces services of the agency to the customer
       getBusinessPlayers().getCounselor().print(M.message.MANAGER_PROPOSAL);
       // customer asks an agency to build a tower
       getBusinessPlayers().getCustomer().print(M.message.CUSTOMER_REQUEST);
       // a counselor agrees to help
       getBusinessPlayers().getCounselor().print(M.message.MANAGER_ANSWER);
       InputUtils.chooseMenuItem(this, M.menus.MAIN_MENU); // main menu is printed on the console
    }

     @Override
    public void onApplicationTerminate() { // calls on application terminate
    }
    
    @Override
    public void dispose() { // calls when gc is started
    }
}
