/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io.console;

import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.io.FileIO;
import java.io.InputStream;

/**
 * Declares a content provider, which retrieves a data from different sources
 * @author vbohudskyi
 * @version
 */
public abstract class ContentProvider {
    
    private FileIO io = null; //file io utils are stored here
    private ApplicationContext context = null; // application context is tored here
    /**
     * Declares a data input stream
     * @param input - data input stream 
     * @version 1.0
     */
    
    public ContentProvider(InputStream input)
    {
        
    }
    
    public ContentProvider(String filename)
    {
        
    }
    
    
}
