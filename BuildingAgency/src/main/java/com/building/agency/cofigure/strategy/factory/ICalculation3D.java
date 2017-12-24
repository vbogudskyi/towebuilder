/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.factory;

import com.building.agency.base.Figure3d;

/**
 * Declares a calculation of parameters of 3d figure
 * @author vbohudskyi
 * @version 1.0
 */
public interface ICalculation3D {
    /**
     * 
     * @param <T> - figure type
     * @param figure - figure 3d
     * @return surface area
     */
    public <T extends Figure3d> double calcualteSurfaceArea(T figure);
    
    /**
     * 
     * @param <T> - figure type
     * @param figure - figure 3d
     * @return figure 3d volume
     */
    public <T extends Figure3d> double calculateVolume(T figure);
}
