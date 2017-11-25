/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.players;

import com.building.agency.utils.M;

/**
 * Declares a product manager business player
 * @author vbohudskyi
 * @version 1.0
 */
public class ProductManager extends BusinessPlayer {

    public ProductManager() {
        super(M.person.MANAGER);
    }

    @Override
    public String getGreeting() {
        return String.format(M.dialogs.MANAGER_GREETING, player, player.substring(0, player.length() - 2));
    }

    @Override
    public String getSpeech(int speechId) {
       String message = null;
       switch(speechId)
       {
           case M.message.MANAGER_SPEECH:
           {
               message = String.format(M.dialogs.MANAGER_SPEECH2, M.person.MANAGER);
               break;
           }
       }
       return message;
    }

    @Override
    public String getName() {
        return M.person.MANAGER;
    }
    
}
