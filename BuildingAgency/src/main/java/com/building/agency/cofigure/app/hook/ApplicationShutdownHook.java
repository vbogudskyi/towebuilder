/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.app.hook;

import com.building.agency.cofigure.app.ApplicationContext;

/**
 * Declares application terminate callback
 * @author vbohudskyi
 * @version 1.0
 */
public class ApplicationShutdownHook extends Thread{
    
    private ApplicationContext context = null; //application context is stored here
    
    /**
     * Application shutdown hook default constructor
     * @param context - application context
     */
    public ApplicationShutdownHook(ApplicationContext context)
    {
        this.context = context; // context is stored here
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        context.onApplicationTerminate(); // application terminate callback is called here
    }
    
    
    
}
