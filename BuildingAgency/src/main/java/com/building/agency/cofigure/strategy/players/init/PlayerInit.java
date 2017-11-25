/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.players.init;

import com.building.agency.cofigure.strategy.players.BusinessPlayer;
import com.building.agency.cofigure.strategy.players.ConsultingManager;
import com.building.agency.cofigure.strategy.players.Customer;
import com.building.agency.cofigure.strategy.players.ProductManager;



/**
 * Declares an initializer 
 * @author vbohudskyi
 * @version 1.0
 */
public final class PlayerInit {
    
    private ConsultingManager counselor = null; //Counselor reference is stored here
    private ProductManager manager = null; //Product manager reference is stored here
    private Customer customer = null;
    private static PlayerInit instance = null;
   
    /**
     * Private singletone constructor
     */
    private PlayerInit()
    {
        counselor = new ConsultingManager();
        manager = new ProductManager();
        customer = new Customer("Anonymous");
    }
    
    public static synchronized final PlayerInit getInstance()
    {
        if(instance == null)
        {
            instance = new PlayerInit();
        }
        
        return instance;
    }

    // Accessors
    public BusinessPlayer getCounselor() {
        return counselor;
    }

    public BusinessPlayer getManager() {
        return manager;
    }

    public BusinessPlayer getCustomer() {
        return customer;
    }
    
}
