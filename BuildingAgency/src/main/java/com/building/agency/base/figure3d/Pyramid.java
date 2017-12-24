/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d;

import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;

/**
 * Declares a pyramid
 * @author vbohudskyi
 * @version 1.0
 */
public class Pyramid extends Prismatoid {
    
    private Figure2d base = null; // a base figure of a prism
    private double height = 0; // a height of a prism
    /**
     * Pyramid default constructor
     * @param base - base figure of pyramid
     * @param height - pyramid height
     */
    public Pyramid(Figure2d base, double height) {
        super(M.figure_3d.PYRAMID, base.getCurrentFigure());
        this.base = base; // pyramid base is assigned here
        this.height = height; // pyramid height is assigned here
    }
    
}
