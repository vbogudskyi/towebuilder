/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Declares a prism json model
 * @author vbohudskyi
 * @version 1.0
 */
public class PrismModel {
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("name")
    private String name;
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("type")
    private String type;
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("base")
    private Base base;
    
    @Expose(serialize = false, deserialize = true)
    @SerializedName("height")
    private double height;

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
     * 
     */
    protected static class Base
    {
        @Expose(serialize = false, deserialize = true)
        @SerializedName("type")
        private String type;
        
        @Expose(serialize = false, deserialize = true)
        @SerializedName("width")
        private double width;
        
        @Expose(serialize = false, deserialize = true)
        @SerializedName("height")
        private double height;

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

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }
        
        
    }
}
