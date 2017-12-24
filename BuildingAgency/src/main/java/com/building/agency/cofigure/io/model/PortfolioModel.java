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
    private AntiprismModel[] antiprism; // serialized antiprisms are stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("prism")
    private PrismModel[] prism; // serialized prisms are stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("pyramid")
    private PyramidModel[] pyramid; // serialized pyramids are stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("cupolae")
    private CupolaeModel[] cupolae; // serialized cupolaes are stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("frusta")
    private FrustaModel[] frusta; // serialized frustas are stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("sphere")
    private SpheresModel[] sphere; // serialized spheres are stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("wedges")
    private WedgesModel[] wedge; // serialized wedges are stored here

    // Accessors and mutators
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

    public PyramidModel[] getPyramid() {
        return pyramid;
    }

    public void setPyramid(PyramidModel[] pyramid) {
        this.pyramid = pyramid;
    }

    public CupolaeModel[] getCupolae() {
        return cupolae;
    }

    public void setCupolae(CupolaeModel[] cupolae) {
        this.cupolae = cupolae;
    }

    public FrustaModel[] getFrusta() {
        return frusta;
    }

    public void setFrusta(FrustaModel[] frusta) {
        this.frusta = frusta;
    }

    public SpheresModel[] getSphere() {
        return sphere;
    }

    public WedgesModel[] getWedges() {
        return wedge;
    }

    public void setWedges(WedgesModel[] wedges) {
        this.wedge = wedges;
    }
    
    
}
