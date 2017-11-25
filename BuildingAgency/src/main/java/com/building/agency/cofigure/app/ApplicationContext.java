/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 * Declares an application context
 * @author vbohudskyi
 * @version 1.0
 */
public abstract class ApplicationContext {
    
    private Scanner scanner = null; // declares an application console reader
    private Scanner fileScanner = null; // declares an application file reader
    
    /**
     * Method declares default application context constructor
     * Initializes console reader
     */
    public ApplicationContext()
    {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Method declares application context constructor
     * @param file reader output file
     * @throws IOException if a file is not found
     */
    public ApplicationContext(File file) throws IOException
    {
         scanner = new Scanner(System.in);
         fileScanner = new Scanner(new FileInputStream(file));
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
        dispose();
    }
    
    
    
    // Accessors and mutators
    public Scanner getConsoleScanner() {
        return scanner;
    }
    
    public Scanner getFileScanner(){
        return fileScanner;
    }
    
}
