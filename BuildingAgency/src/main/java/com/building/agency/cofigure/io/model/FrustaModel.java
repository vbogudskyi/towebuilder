/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Declares a frusta json model
 * @author vbohudskyi
 * @version 1.0
 */
public class FrustaModel {
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("name")
    private String name; // a frusta figure name is stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("type")
    private String type; // a frusta figure type is stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("base")
    private Base base; // a frusta figure base is stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("Height")
    private double height; // a frusta figure height is stored here

    // Accessors and mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     * Declares a frusta figure base
     * @author vbohudskyi
     * @version 1.0
     */
    protected static class Base
    {
        @Expose(serialize = false, deserialize = true)
        @SerializedName("type")
        private String type; // a base type is stored here
        
        @Expose(serialize = false, deserialize = true)
        @SerializedName("radius")
        private double radius; // a base adius is store here
        
        // Accessors and mutators
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }
}
