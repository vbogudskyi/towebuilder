/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.players;

import com.building.agency.utils.M;

/**
 * Declares a customer
 * @author vbohudskyi
 * @version 1.0
 */
public class Customer extends BusinessPlayer {
        
    /**
     * Default customer constructor
     * @param player - customer name
     * @version 1.0
     */
    public Customer(String player) {
        super(player);
    }

    @Override
    public String getGreeting() {
        return String.format(M.dialogs.CUSTOMER_GREETINGS, player, player);
    }

    @Override
    public String getSpeech(int speechId) {
        String message = null;
        switch(speechId)
        {
            case M.message.CUSTOMER_REQUEST:
            {
                message = String.format(M.dialogs.CUSTOMER_SPEECH1, player);
                break;
            }
        }
        return message;
    }

    @Override
    public String getName() {
        return player;//InputUtils.getCustomerName(scanner);
    }
    
}
