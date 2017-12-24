/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base;

import com.building.agency.utils.M;
import com.building.agency.utils.Math2dUtils;

/**
 * Declares a base 2D figure
 * @author vbohudskyi
 * @version 1.0
 */
public abstract class Figure2d {
  
   private int currentFigure = M.figures_2d.NONE; //Current figure type is stored here
   private Math2dUtils utils = null; // math utils are stored here
   
   /**
    * Figure 2D base constructor
    * @param figure - figure type
    */
   public Figure2d(int figure)
   {
       this.currentFigure = figure; // current figure is assigned here
       utils = Math2dUtils.getInstance(); // an instance of math utils is stored here
   }
   /**
    * Abstract method for calculating an area of 2D figure
    * @return area
    */ 
   protected abstract double calculateArea();
   
   /**
    * Method retrieves math utilities
    * @return math utilities
    */
   protected Math2dUtils getMathUtils()
   {
       return utils;
   }
   
   /**
    * Method detects a current 2D figure
    * @param figure detecting figure type
    * @return true if matches
    */
   public boolean isFigure(int figure)
   {
       return currentFigure == figure;
   }
   
   /**
    * Method returns current figure value
    * @return current figure
    */
   public int getCurrentFigure()
   {
       return currentFigure;
   }
}
