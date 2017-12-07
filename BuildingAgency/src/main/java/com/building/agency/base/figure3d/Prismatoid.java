/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d;

import com.building.agency.base.Figure3d;

/**
 * Declares a prismatoid
 * @author vbohudskyi
 * @version 1.0
 */
public class Prismatoid extends Figure3d {
     
    /**
     * Prismatoid default constructor
     * @param figure - type of prismatoid
     * @param base_figure - prismatoid base
     */
    public Prismatoid(int figure, int base_figure) {
        super(figure, base_figure);
    }

    @Override
    public double getVolumeValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSurfaceArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
