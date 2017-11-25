/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figures2d;

import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;

/**
 * Declares a rectangle
 * @author vbohudskyi
 * @version 1.0
 */
public class Circle extends Figure2d {
    
    private double radius; // radius of the circle

    /**
     * Circle constructor by default
     * @param radius radius of the circle
     */
    public Circle(double radius) {
        super(M.figures_2d.CIRCLE);
        this.radius = radius;
    }
    
    /**
     * Circle constructor of copy. Creates a new circle on the base of existing one
     * @param circle base circle
     */
    public Circle(Circle circle)
    {
        this(circle.getRadius());
    }

    @Override
    protected double calculateArea() {
        return getMathUtils().calculateCircleScale(this);
    }
    
    //Accessors and mutators
    public double getRadius()
    {
        return radius;
    }
    
    public void setRadius(double radius)
    {
        if(radius>0)
           this.radius = radius;
    }
}
