/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d.cupolae;

import com.building.agency.base.Figure2d;
import com.building.agency.base.figure3d.Cupolae;
import com.building.agency.utils.M;

/**
 * Declares a square cupolae
 * @author vbohudskyi
 * @version 1.0
 */
public class SquareCupolae extends Cupolae {

    private Figure2d base = null; // square cupolae base
    private double height = -1; // square cupolae height
    
    public SquareCupolae(Figure2d base, double height) {
        super(M.figure_3d.SQUARE_CUPOLAE, M.figures_2d.POLYGON);
        this.base = base; // square cupolae base is assigned here
        this.height = height; // square cupolae height is assigned here
    }

    @Override
    public Figure2d getCupolaeBase() {
        return base;
    }

    @Override
    public Figure2d getCupolaeUpperBase() {
        return base;
    }

    @Override
    public double getHeight() {
        return height;
    }
    
}
