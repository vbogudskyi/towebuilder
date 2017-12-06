/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.building.agency.BuildingAgency;
import com.building.agency.cofigure.app.ApplicationContext;

/**
 * Declares an application entry point
 * @author vbohudskyi
 * @version 1.0
 */
public class ApplicationEntry {

    /** 
     * Application entry main method
     * @param args the command line arguments
     * @version 1.0
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext context = new BuildingAgency(); // application instance is initialized
        context.onApplicationStart(); // application started
    }
    
}
