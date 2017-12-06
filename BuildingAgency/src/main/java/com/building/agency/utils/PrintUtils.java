/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

/**
 * Declares print utilities
 * @author vbohudskyi
 * @version 1.0
 */
public final class PrintUtils {
    
    private PrintUtils(){};
    
    /**
     * Method prints the main menu header
     */
    public static final void printMainMenuHeader()
    {
        // prints a main menu header
        System.out.println("----------Welcome to Construct & Build Company!----------");
    }
    
    /**
     * Method prints a business player messages
     * @param message - business player message
     */
    public static final void printMessage(String message)
    {
        System.out.println(message); // prints a message
    }
    
}
