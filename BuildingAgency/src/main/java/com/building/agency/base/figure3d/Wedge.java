/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d;

import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;

/**
 * Declares a wedge
 * @author vbohudskyi
 * @version 1.0
 */
public class Wedge extends Prismatoid {
    
    private Figure2d base = null; //wedges base figure 2d;
    private Figure2d side = null; // wedge side figure 2d;
    private double height = 0; // wedges height;
    
    /**
     * Wedge default constructor
     * @param base - wedges base figure
     * @param side - wedges side figure
     * @param height - wedges height
     */
    public Wedge(Figure2d base, Figure2d side, double height) {
        super(M.figure_3d.WEDGE, base.getCurrentFigure());
        this.base = base; // base figure 2d of wdge is assigned here
        this.side = side; // side figure 2d of wedge if assigned here
        this.height = height; // height of wedge is assigned here
    }
    
}
