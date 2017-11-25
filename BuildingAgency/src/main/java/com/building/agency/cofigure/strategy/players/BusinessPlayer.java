/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.players;
import com.building.agency.utils.M;
import com.building.agency.utils.*;

/**
 * Declares a business player
 * @author vbohudskyi
 * @version 1.0
 */
public abstract class BusinessPlayer {
   
    protected String player = null; //current business player
    
    /**
     * Business player default constructor. Creates an abstract business player
     * @param player - business player
     */
    public BusinessPlayer(String player)
    {
        this.player = player;
    }
    
    /**
     * Method retrieves a business player greeting
     * @return greeting
     */
    public abstract String getGreeting();
    /**
     * Method retrieves a business player speech
     * @param speechId speech identifier
     * @return message
     */
    public abstract String getSpeech(int speechId);
    
    /**
     * Method retrieves a name of business player
     * @return name
     */
    public abstract String getName();
   /**
    * Method prints business player's quotes
    * @param message 
    */
    public void print(int message)
    {
        switch(message)
        {
            case M.message.GREETING:
            {
                PrintUtils.printMessage(getGreeting());
                break;
            }
            
            default:
            {
                PrintUtils.printMessage(getSpeech(message));
                break;
            }
        }
    }
    
    // Accessors and mutators
    public String getPlayer() {
        if(StringUtils.isNullOrEmpty(player))
        {
            
        }
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    } 
}
