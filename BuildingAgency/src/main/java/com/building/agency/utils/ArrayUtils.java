/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

/**
 *Declare the Data Storage of incoming data
 * @author colea
 * @version 1.0
 */
public class ArrayUtils {
    
    
   
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
            data = new double[capacity];
        }
       
        //Method to add new data
        public boolean addData(double data){
            boolean added = false;
            if (count < capacity) {
               this.data[count++] = data;
               added = true;
            }
            return added;//return either the data was added or not
        }
        
        //Method to find specific data
        public int findData(double data) {
            int place = -1;
            for (int index = 0; index < count; index++){
                if (data==this.data[index]) {
                    place = index;
                    break;
                }
            }
            return place;//return the place wher ethe data i slocated
        }
        
        //method to change one data with another
        public boolean changeData(double data, double newData) {
            int change = findData(data);
            boolean added = false;
                if(change != -1){
                   this.data[change] = newData; 
                   added = true;
                }else ;//need to add a condition, maybe to add in M menu a error statment
            
            return added;// return either the data was changed or not
        }
        
        //moves the NaN value to the end of the Array
        public void drop() {
        
            int items = 0;
            //shift all null elements to the end
            //Double.NaN is equivalent to null but can be used with doubls
            for (int j=0; j<data.length; j++){
                  if (data[j]==Double.NaN){
                    for (int k=j+1; k<data.length; k++){
                    data[k-1] = data[k];
                    }
                data[data.length-1] = Double.NaN;
                break;
                }
            }            
        }
        
        //removes data from the array by replaceing it with NaN
        //Double.NaN is equivalent to null but can be used with doubls
        public boolean removeData(double data) {
            //int remove = changeData(data, Double.NaN);
            int remove = findData(data);
            boolean removed = false;
                if(remove != -1) {
                    this.data[remove]= Double.NaN;
                    removed = true;
                 }else ;//need to add a condition, maybe to add in M menu a error statment
            return removed;
        }
        
        public int getCapacity() {
        return this.capacity;
        }

        public int getCount() {
        return this.count;
        }
    }
}
