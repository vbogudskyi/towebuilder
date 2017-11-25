/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.figure.builder.base.figures2d.model;

/**
 * Declares a circle model. Gathers all information about a circle
 * @author vbohudskyi
 * @version 1.0
 */
 /* Class containing  */
public class CircleModel {
    
    private double radius = -1; //Circle radius is stored here
    private double area = -1;  // Circle area is stored here
    
    /**
     * Circle model default constructor
     * @param radius - radius of circle 
     */
    
    public CircleModel(double radius) // Main consctructor
    {
        this.radius = radius;
    }
    
    //Acessors and mutators
    public CircleModel setRadius(double radius)
    {
        this.radius = radius;
        return this;
    }
    
    public double getArea() {
        return area;
    }

    public CircleModel setArea(double area) {
        this.area = area;
        return this;
    }
    
}
