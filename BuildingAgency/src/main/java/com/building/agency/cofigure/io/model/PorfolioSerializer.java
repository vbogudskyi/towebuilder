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
 */
public class PorfolioSerializer  {
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("porfolio")
    private PortfolioModel protfolio;

   
    public PortfolioModel getProtfolio() {
        return protfolio;
    }

    public void setProtfolio(PortfolioModel protfolio) {
        this.protfolio = protfolio;
    }

        
    
    
}
