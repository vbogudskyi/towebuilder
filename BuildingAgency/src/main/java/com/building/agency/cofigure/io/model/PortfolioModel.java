/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Declares a portfolio json model
 * @author vbohudskyi
 * @version 1.0
 */
public class PortfolioModel {
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("antiprism")
    private AntiprismModel[] antiprism;
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("prism")
    private PrismModel[] prism;

    public AntiprismModel[] getAntiprisms() {
        return antiprism;
    }

    public void setAntiprisms(AntiprismModel[] antiprism) {
        this.antiprism = antiprism;
    }

    public PrismModel[] getPrisms() {
        return prism;
    }

    public void setPrisms(PrismModel[] prism) {
        this.prism = prism;
    }
    
    
}
