/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d;

import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;

/**
 * Declares a frusta
 * @author vbohudskyi
 * @version 1.0
 */
public class Frusta extends Prismatoid {
    
    private Figure2d base = null; // base figure of frusta
    private Figure2d upper = null; // upper figure of frusta
    private double height = 0; // height of frusta
    
    /**
     * Frusta default constructor
     * @param base - base figure of frusta
     * @param upper - upper base of frusta
     * @param height - height of frusta
     */
    public Frusta(Figure2d base, Figure2d upper, double height) {
        super(M.figure_3d.FRUSTA, base.getCurrentFigure());
        this.upper = upper; // upper base of frusta is assigned here
        this.base = base; // base of frusta is assigned here
        this.height = height; // height of frusta is assigned here
    }
    
}
