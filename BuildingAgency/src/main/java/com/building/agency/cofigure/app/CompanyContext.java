/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.app;

import com.building.agency.cofigure.strategy.FigureStrategy;
import com.building.agency.cofigure.strategy.MenuStrategy;
import com.building.agency.cofigure.strategy.players.init.PlayerInit;

/**
 * Declares a builder context
 * @author vbohudskyi
 * @version 1.0
 */
public abstract class CompanyContext extends ApplicationContext {

     private FigureStrategy figureStrategy = null; // Figures strategy reference is stored here
     private MenuStrategy menuStrategy = null; // Menus strategy reference is stored here
     private PlayerInit init = null; // Player's initializer is stored here
     
     /**
      * 
      */
     public CompanyContext()
     {
         init = PlayerInit.getInstance(); // players container instance is got here
         figureStrategy = new FigureStrategy(this); // figure strategy instance is created here
         menuStrategy = new MenuStrategy(this); // menu strategy instance is created here
     }

    // Accessors and mutators 
    public FigureStrategy getFigures() {
        return figureStrategy;
    }

    public MenuStrategy getMenus() {
        return menuStrategy;
    }
     
     public PlayerInit getBusinessPlayers()
     {
         return init;
     }
}
