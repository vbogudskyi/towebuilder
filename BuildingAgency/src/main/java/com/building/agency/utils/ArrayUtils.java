/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

/**
 * Declare the ArrayUtils Class
 * @author nnastas
 * @version 1.0
 */
public abstract class ArrayUtils {

    private DataStorage data ;
    
    public abstract void onSuccess(double data);// method calls in cases of success 
    public abstract void onFailure(double data);// method calls in case of failure
    
    /**
     * method to add data
     * @param data to be added
     * @version 1.0
     */
    public void addData(double data) {
        if (this.data.addData(data)) {
           onSuccess(data);//calls the onSuccess class
        } else 
           onFailure(data);
    }  
    
    /**
     * method to find data
     * @param data looked up for
     * @version 1.0
     */
    public void findData(double data) {
        if(this.data.findData(data) != -1){
            onSuccess(data);
        } else
            onFailure(data);
    }
    
    /**
     * method to find a value based on index
     * @param index of the value
     * @return the value based on index
     * @version 1.0
     */
    public double findData(int index) {
        double value = 0;
        if(index >=0) {
           value = this.data.findData(index);
        } 
     return value;       
    }
    
    /**
     * method to get the array capacity
     * @return the capacity of the Array
     * @version 1.0
     */
    public int getCapacity(){
        
      return this.data.getCapacity();  
    }
    
    /**
     * method to get the count of data
     * @return the data count
     * @version 1.0
     */
    public int getCount() {
        return this.data.getCount();
    }
     
    /**
     * method to change data
     * @param data to be changed
     * @param newData changes the old data
     * @version 1.0
     */
    public void changData(double data, double newData) {
        if(this.data.changeData(data,newData)){
           onSuccess(newData); 
        } else
            onFailure(newData);
    }
    
    /**
     * method to remove data
     * @param data to be removed
     * @version 1.0
     */
    public void removeData(double data) {
        if(this.data.removeData(data)) {
            onSuccess(data);
        } else
            onFailure(data);
    }
    
    /**
     * Declare the Data Storage of incoming data
     * @version 1.0
     */
   
    protected static class DataStorage {
        private double[] data;// Data Sorage data is stored here
        private int count;//how much data is in the Array
        private final int capacity;//maximum Arrays that can be added
        
        /**
         * Default constructor for Data Storage
         * @param capacity array capacity
         * @version 1.0
         */
        public DataStorage(int capacity){
            this.capacity = capacity;
            this.count = 0;
            data = new double[capacity];//creates a new Array
        }
       
        /**
         * Method to add new data
         * @param data that needs to be added
         * @return return either the data was added or not
         * @version 1.0
         */
        public boolean addData(double data){
            boolean added = false;
            if (count < capacity) {
               this.data[count++] = data;
               added = true;
            }
            return added;
        }
        
        /**
         * Method to find specific data
         * @param data looked up for
         * @return the place where the data is located
         * @version 1.0
         */
        public int findData(double data) {
            int place = -1;
            for (int index = 0; index < count; index++){
                if (data==this.data[index]) {
                    place = index;
                    break;
                }
            }
            return place;
        }
        
        /**
         * Method to find the data by specific index
         * @param index of the value
         * @return the value based on the index
         * @version 1.0
         */
        public double findData(int index) {
            double value = 0;
            if ((index < capacity) && (index >= 0)) {
               value = data[index];
            }
            return value;
        }
        
        /**
         * Method to get the Array capacity
         * @return the capacity of the Array
         * @version 1.0
         */
        public int getCapacity() {
        return this.capacity;
        }

        /**
         * Method to get the count of the data
         * @return the count of data
         * @version 1.0
         */
        public int getCount() {
        return this.count;
        }
        
        /**
         * Method to change one data with another
         * @param data needed to be replaced
         * @param newData replaces the old data
         * @return either the data was changed or not
         * @version 1.0
         */
        public boolean changeData(double data, double newData) {
            int change = findData(data);
            boolean added = false;
                if(change != -1){
                   this.data[change] = newData; 
                   added = true;
                }
            
            return added; 
        }
        
        /**
         * moves the NaN value to the end of the Array
         * @version 1.0
         */
        public void drop() {
        
            int items = 0;
            //shift all null elements to the end
            for (int j=0; j<data.length; j++){
                  if (data[j]==Double.NaN){
                    for (int k=j+1; k<data.length; k++){
                    data[k-1] = data[k];
                    }
                data[data.length-1] = Double.NaN;
                //Double.NaN is equivalent to null but can be used with doubls
                break;
                }
            }            
        }
        
        /**
         * Removes data from the array by replacing it with NaN
         * Double.NaN is equivalent to null but can be used with doubles
         * @param data to be removed
         * @return either the data is or not removed
         * @version 1.0
         */
        public boolean removeData(double data) {
            int remove = findData(data);
            boolean removed = false;
                if(remove != -1) {
                    this.data[remove]= Double.NaN;
                    removed = true;
                 }
            drop();
            count--;
            return removed;
        }
    }
}
