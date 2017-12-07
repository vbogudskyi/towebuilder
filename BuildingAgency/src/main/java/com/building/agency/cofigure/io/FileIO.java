/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io;

import com.building.agency.cofigure.app.ApplicationContext;

/**
 * Declares file I/O instruments
 * @author nnastas
 * @version 1.0
 */
public class FileIO {
    private ApplicationContext context  = null; //application context is stored here
    
    /**
     * Default constructor for FileIO
     * @param context - application context
     * @version 1.0
     */
    public FileIO(ApplicationContext context){
        this.context = context; //application context is assigned
    }
    
   
}
