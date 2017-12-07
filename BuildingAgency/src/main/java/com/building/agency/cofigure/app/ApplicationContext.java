/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.app;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;
/**
 * Declares an application context
 * @author vbohudskyi
 * @version 1.0
 */
public abstract class ApplicationContext {
    
    private Scanner scanner = null; // declares an application console reader 
    private Gson gson = null; // instance of gson library

    /**
     * Method declares default application context constructor
     * Initializes console reader
     */
    public ApplicationContext()
    {
        scanner = new Scanner(System.in); // console scanner instance is created here
        gson = new GsonBuilder().create();//gson library is initialised 

    }  
    /**
     * Fires, when application start
     */
    public abstract void onApplicationStart();
    
    /**
     * Fires, when application stopped
     */
    public abstract void onApplicationTerminate();

    /**
     * Fires on finalization
     */
    public abstract void dispose();

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        dispose(); // calls when gc starts working
    }
    
   
    // Accessors and mutators
    public Scanner getConsoleScanner() {
        return scanner;
    }
    
    public Gson getGson(){
        return gson;
    }

    
}
