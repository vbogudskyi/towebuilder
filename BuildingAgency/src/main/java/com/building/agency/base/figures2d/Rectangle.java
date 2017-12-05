/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figures2d;

import com.building.agency.utils.M;

/**
 * Declares a rectangle
 * @author vbohudskyi
 * @version 1.0
 */
public class Rectangle extends Parallelogramm{
   
    /**
     * Rectangle default constructor
     * @param width - width of the rectangle
     * @param height - height of the rectangle;
     * @version 1.0
     */
    public Rectangle(double width, double height) {
        super(M.figures_2d.RECTANGLE, width, height, 90);
    }
    
    /**
     * Rectangle constructor of copy. Creates a new rectangle on the base of existing one
     * @param rect base rectangle
     * @version 1.0
     */
    public Rectangle(Rectangle rect)
    {
        this(rect.getWidth(), rect.getHeight());
    }
}
