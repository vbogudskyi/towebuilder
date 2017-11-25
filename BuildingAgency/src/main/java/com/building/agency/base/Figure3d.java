/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base;

/**
 * Declares a base 3D figure
 * @author vbohudskyi
 * @version 1.0
 */
public abstract class Figure3d {
    
    private double scale = -1; //Surface area of 3D figure is stored here
    private Figure2d base = null; //Base 2D figure of 3D figure is stored here
    private double volume = -1; // Volume of 3D figure is stored here
    private int currentFigure = -1; //Current 3D figure type is stored here
    
    /**
     * 3D figure default constructor
     * @param figure - figure type
     * @param base_figure  - base figure type
     */
    public Figure3d(int figure, int base_figure)
    {
        currentFigure = figure;
        base = null;
    }
    /**
     * Method calculates a volume of 3D figure
     * @return volume(double)
     */
    public abstract double getVolumeValue();
    
    /**
     * Method calculates 2 surface area of 3D figure
     * @return scale (double)
     */
    public abstract double getSurfaceArea();
    
    //Accessors and mutators 
    public double getScale() {
        return scale;
     }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    /**
     * Method detects a type of current 3D figure
     * @param figure - detecting figure type
     * @return true if matches
     */
    public boolean isFigure(int figure)
    {
        return currentFigure == figure;
    }
    
}
