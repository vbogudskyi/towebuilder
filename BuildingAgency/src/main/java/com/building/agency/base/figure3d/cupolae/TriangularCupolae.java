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
 * Declares a triangular cupolae
 * @author vbohudskyi
 * @version 1.0
 */
public class TriangularCupolae extends Cupolae {

    private Figure2d base = null; // triangular cupola base figure
    private Figure2d upper_base = null; // triangular cupola
    private double height = -1; // triangular cupola height
    
    /**
     * Default trialgular cupolae constructor
     * @param base - triangular cupolae base figure
     * @param upper - triangular cupolae upper base
     * @param height - triangular cupolae height
     * @version 1.0
     */
    public TriangularCupolae(Figure2d base, Figure2d upper, double height) {
        super(M.figure_3d.TRANGULAR_CUPOLAE, M.figures_2d.POLYGON);
        this.base = base; // triangular cupolae base
        this.upper_base = upper; //triangular upper base
        this.height = height; // triangular cupolae height
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
        return upper_base;
    }  
}
