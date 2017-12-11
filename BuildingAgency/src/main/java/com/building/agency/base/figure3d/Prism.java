/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figure3d;

import com.building.agency.base.Figure2d;
import com.building.agency.utils.M;

/**
 * Declares a prism
 * @author vbohudskyi
 * @version 1.0
 */
public class Prism extends Parallelepiped {
    
    
    /**
     * Prism default constructor
     * @param base - base figure of a prism
     * @param height - height of a prism
     */
    public Prism(Figure2d base, double height) {
        super(M.figure_3d.PRISM, base.getCurrentFigure());
    }
    
}
