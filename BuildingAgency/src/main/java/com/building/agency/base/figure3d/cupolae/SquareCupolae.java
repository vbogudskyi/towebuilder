/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d.cupolae;

import com.building.agency.base.Figure2d;
import com.building.agency.base.figure3d.Cupolae;

/**
 * Declares a square cupolae
 * @author vbohudskyi
 * @version 1.0
 */
public class SquareCupolae extends Cupolae {

    public SquareCupolae(int figure, int base_figure) {
        super(figure, base_figure);
    }

    @Override
    public Figure2d getCupolaeBase() {
        return null;
    }

    @Override
    public Figure2d getCupolaeUpperBase() {
        return null;
    }

    @Override
    public double getHeight() {
        return 0;
    }
    
}
