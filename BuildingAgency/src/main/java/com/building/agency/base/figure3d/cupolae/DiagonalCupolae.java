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
 * Declares a diagonal cupolae
 * @author vbogudskyi
 * @version 1.0
 */
public class DiagonalCupolae extends Cupolae{
    
    private Figure2d base = null; // cupolae base is stored here
    private double height = -1; // cupolae height is stored here
    
    /**
     * Default constructor of diagonal cupolae
     * @param base - cupolae base figure
     * @param height - cupolae height
     * @version 1.0
     */
    public DiagonalCupolae(Figure2d base, double height) {
        super(M.figure_3d.DIAGONAL_CUPOLAE, M.figures_2d.TRIANGLE);
        this.base = base; // cupolae base is assigned here
        this.height = height; // cupolae height is assigned here
    }

    @Override
    public Figure2d getCupolaeBase() {
        return base;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public Figure2d getCupolaeUpperBase() {
        return base;
    }
}
