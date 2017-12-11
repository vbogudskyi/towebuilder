/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figures2d;
import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;

/**
 * Declares a triangle
 * @author vbohudskyi
 * @version 1.0
 */
public class Triangle extends Figure2d{

    private double a;
    private double b;
    private double c;


    
    /**
     * Default triangle constructor
     * @param a - first triangle side
     * @param b - second triangle side
     * @param c - third triangle side
     */
    public Triangle(double a, double b, double c) {
        super(M.figures_2d.TRIANGLE);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /**
     * Constructor of copy. Creates a triangle on the base of existing one
     * @param triangle base triangle
     */
    public Triangle (Triangle triangle)
    {
        this(triangle.getA(), triangle.getB(), triangle.getC());
    }

    /**
     * calculates and area of a triangle
     * @return area (double)
     */
    @Override
    protected double calculateArea() {
        return getMathUtils().calculateTriangleScale(this);
    }

    // Accessors and mutators
    public double getA() {
        return a;
    }

    public void setA(double a) {
        if(a>0)
           this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if(b>0)
          this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if(c>0)  
          this.c = c;
    }
}
