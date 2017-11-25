/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.base.figures2d;

import com.building.agency.utils.M;


/**
 * Declares a romb
 * @author vbohudskyi
 * @version 1.0
 */
public class Romb extends Parallelogramm {
    
    /**
     * Romb default constructor
     * @param width - romb width
     * @param alpha - romb angle
     */
    public Romb(double width, double alpha) {
        super(M.figures_2d.ROMB, width, width, 90);
    }
    
    /**
     * Romb constructor of copy. Creates a new Romb on a base of existing one
     * @param romb base romb
     */
    public Romb(Romb romb)
    {
        this(romb.getWidth(), romb.getHeight());
    }
}
