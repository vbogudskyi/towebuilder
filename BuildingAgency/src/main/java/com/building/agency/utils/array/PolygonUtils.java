/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils.array;

/**
 * Declare Polygon Utils class
 * @author nnastas
 * @version 1.0
 */
public class PolygonUtils extends ArrayUtils{

    /**
     * Declare the default constructor for PolygonUtils
     * @param capacity of the Array of data
     * @version 1.0
     */
    public PolygonUtils(int capacity) {
        super(capacity);
    }

    @Override
    public void onSuccess(double data) {
       
    }

    @Override
    public void onFailure(double data) {
        
    }
    
    /**
     * Create a method that can calculate a sum of all elements of an Array 
     * @return the sum of the data
     * @version 1.0
     */
     
    public double sumData() {
        double sum = 0; //variable to hold the sum of data
        for(int i = 0; i < this.getCapacity(); i++) {
            sum += findData(i); //Calculats the sum of elements of an Array
        }
        return sum;
    }
}
