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
     */
    public BuildingAgency(){
        Runtime.getRuntime().addShutdownHook(new ApplicationShutdownHook(this));
    }
    
    @Override
    public void onApplicationStart() {
       PrintUtils.printMainMenuHeader();
       getBusinessPlayers().getCounselor().print(M.message.GREETING);
       getBusinessPlayers().getCustomer().setPlayer(InputUtils.getCustomerName(getConsoleScanner()));
       getBusinessPlayers().getCustomer().print(M.message.GREETING);
       getBusinessPlayers().getCounselor().print(M.message.MANAGER_PROPOSAL);
       getBusinessPlayers().getCustomer().print(M.message.CUSTOMER_REQUEST);
       getBusinessPlayers().getCounselor().print(M.message.MANAGER_ANSWER);
       InputUtils.chooseMenuItem(this, M.menus.MAIN_MENU);
    }

     @Override
    public void onApplicationTerminate() {
    }
    
    @Override
    public void dispose() {
    }
}
