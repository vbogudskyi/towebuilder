/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d;

import com.building.agency.base.Figure2d;

/**
 * Declares cupolae
 * @author vbohudskyi
 * @version 1.0
 */
public abstract class Cupolae extends Prismatoid{
    
    private Figure2d base = null; // cupolae base figure is stored here
    private Figure2d upper_base = null; // cupolae upper base is stored here
    private double height = -1; // cupolae height is stored here
    
    /**
     * Cupolae default constructor
     * @param figure - type of cupolae
     * @param base_figure - base of cupolae
     */
    public Cupolae(int figure, int base_figure) {
        super(figure, base_figure);
    }
    
    /**
     * Method retrieves a cupolae base
     * @return cupolae base figure
     */
    public abstract Figure2d getCupolaeBase();
    
    /**
     * Method retrieves a cupolae upper base
     * @return cupolae upper base
     */
    public abstract Figure2d getCupolaeUpperBase();
    
    /**
     * Method retrieves a cupolae height
     * @return height
     */
    public abstract double getHeight();
    
    /**
     * Method applies a received data 
     */
    public void apply()
    {
        base = getCupolaeBase();
        upper_base = getCupolaeUpperBase();
        height = getHeight();
    }
    
}
