/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.factory;

import com.building.agency.base.Figure2d;

/**
 * Declares a calculation parameters of 2d figure
 * @author vbohudskyi
 * @version 1.0
 */
public interface ICalculation2D {
    /**
     * Method calculates an area of 2d figure
     * @param <T> - type of figure
     * @param figure - 3d figure
     * @return a figure area
     */
    public<T extends Figure2d> double calculateArea(T figure); 
}
