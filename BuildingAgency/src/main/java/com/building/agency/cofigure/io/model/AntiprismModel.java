/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Declares an antiprism json model
 * @author vbohudskyi
 * @version 1.0
 */
public class AntiprismModel {
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("name")
    private String name; // antiprism figure name is stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("type")
    private String type; // antiprism figure type is stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("base")
    private Base base; // antiprism figure base is stored here
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("Height")
    private double height; // antiprism figure height

    // Accesors and mutators
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
     * Declares an antiprism base
     * @author vbohudskyi
     * @version 1.0
     */
    protected static class Base
    {
        @Expose(serialize = false, deserialize = true)
        @SerializedName("type")
        private String type; // base type is stored here
        
        @Expose(serialize = false, deserialize = true)
        @SerializedName("width")
        private double width; // base width is stored here

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }
        
        
    }
}
