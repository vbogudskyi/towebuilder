/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figures2d;

import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;
/**
 * Declares a parellelogramm
 * @author vbohudskyi
 * @version 1.0
 */
public class Parallelogramm extends Figure2d {

    private double width, height, alpha; // parameters of a parallelogramm
    
    /**
     * Parallelogramm default constructor
     * @param width - width of the parallelogramm
     * @param height - height of the parallelogramm
     * @param alpha - angle between width and height
     */
    public Parallelogramm(double width, double height, double alpha) {
        super(M.figures_2d.PARALLELOGRAMM);
        this.width = width;
        this.height = height;
        this.alpha = alpha;
    }
    
    /**
     * Parallellogramm constructor of copy. Creates a new parallelogramm on the base of existing one
     * @param parallelogramm base parallelogramm
     */
    public Parallelogramm(Parallelogramm parallelogramm)
    {
        this(parallelogramm.getWidth(), parallelogramm.getHeight(), parallelogramm.getAlpha());
    }
    
    /**
     * Constructor, which creates different types of parallelogramm
     * @param figure - type of parallelogramm
     * @param width - width of parallelogramm
     * @param height - height of parallelogramm
     * @param alpha - angle between width and height
     */
    public Parallelogramm(int figure, double width, double height, double alpha)
    {
        super(figure);
        this.width = width;
        this.height = height;
        this.alpha = alpha;
    }

    @Override
    protected double calculateArea() {
        return getMathUtils().calculateParallelogrammScale(this);
    }
    
    //Accessors and mutators
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width>0)
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height>0)
        this.height = height;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        if(alpha>0)
        this.alpha = alpha;
    }
}
