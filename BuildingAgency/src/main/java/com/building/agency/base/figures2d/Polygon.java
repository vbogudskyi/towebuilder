/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figures2d;

import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;

/**
 * Declares a polygon
 * @author vbohudskyi
 * @version 1.0
 */
public class Polygon extends Figure2d {

    private double[] sides; //Sides of a polygon
    private double radius; // radius of internal circle inside a polygon

    /**
     * Polygon default constructor
     * @param radius - radius of internal circle of the polygon
     * @param sides - sides of the polygon
     */
    public Polygon(double radius, double[] sides) {
        super(M.figures_2d.POLYGON);
        this.sides = sides;
        this.radius = radius;
    }
    
    /**
     * Polygon constructor of copy. Creates a polygon on the base of existing one
     * @param polygon base polygon
     */
    public Polygon(Polygon polygon)
    {
        this(polygon.getRadius(), polygon.getSides());
    }
    
    /**
     * Constructor, which creates different types of polygons
     * @param figure - polygon type
     * @param radius - radius of internal circle
     * @param sides - sides of polygon 
     */
    public Polygon(int figure, double radius, double[] sides)
    {
        super(figure);
        this.sides = sides;
        this.radius = radius;
    }
            
    
    @Override
    protected double calculateArea() {
        
        return getMathUtils().calculatePolygonScale(this);
    }

    //Accessors and mutators
    public double[] getSides() {
        return sides;
    }

    public void setSides(double[] sides) {
        this.sides = sides;
    }
    
     public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius>0)
        this.radius = radius;
    }

}
