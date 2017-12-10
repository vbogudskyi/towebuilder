/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d;

import com.building.agency.base.Figure3d;

/**
 * Declares a sphere
 * @author vbohudskyi
 * @version 1.0
 */
public class Sphere extends Figure3d {

    /**
     * Sphere default constructor
     * @param figure - type of sphere
     * @param base_figure - sphere base
     */
    public Sphere(int figure, int base_figure) {
        super(figure);
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
