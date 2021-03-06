/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Declares a portfolio serialization model.
 * @author vbohudskyi
 * @version 1.0
 */
public class PorfolioSerializer  {
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("portfolio")
    private PortfolioModel protfolio; // a portfolio of serialized figures is stored here 

    // Accessors and mutators
    public PortfolioModel getProtfolio() {
        return protfolio;
    }

    public void setProtfolio(PortfolioModel protfolio) {
        this.protfolio = protfolio;
    }

        
    
    
}
