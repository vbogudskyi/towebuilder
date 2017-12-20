/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils.array;

import java.util.Comparator;


/**
 * Declare the Model Utils Class
 * @author nnastas
 * @version 1.0
 * @param <M>
 */
public class ModelUtils<M> {
    
    private ArrayUtils<M> data = null;
   
    /**
     * Declare the Model Utils constructor
     * @param clazz contains the data of type M
     * @param capacity of the Array length
     * @version 1.0
     */
    public ModelUtils(Class<M> clazz, int capacity) {
       data = new ArrayUtils<M>(clazz, capacity) {
           @Override
           public void onSuccess(M data) {
           }

           @Override
           public void onFailure(M data) {
           }
       };      
    }
    
    /**
     * Method to add data
     * @param data to be added
     * @return if data was added
     * @version 1.0
     */
    public boolean addData(M data) {
         boolean added = false;
         int count = this.data.getCount();
         int capacity = this.data.getCapacity();
         
         if(count < capacity) {
             this.data.addData(data);
             added = true;
         }
         return added;
     }
    
    /**
     * Method to find data based on the index
     * @param index of the value
     * @return the data
     * @version 1.0
     */
    public M findData(int index) {
         M value = null;
         if(index>=0) {
           value = (M)this.data.findData(index);
         }   
      
          return value;
        }
    
    /**
     * method to find the index based on the data
     * @param data that is stored
     * @return the index
     * @version 1.0
     */
    public int findIndex(M data) {
        
        int index = -1;
        if(data != null){
            index = this.data.findIndex(data);
        }
        return index;
    }
    
    /**
     * method to change the data based on the index
     * @param index where the data is located
     * @param newData replaces the old data
     * @version 1.0
     */
    public void changeData(int index, M newData ) {
      M change = findData(index);
        if(change != null) {
           this.data.changeData(index, newData);
        }
        
    }
    
    /**
     * method to change the data in the entire ArrayList
     * @param data needed to be changed
     * @param newData replaces the old data\
     * @version 1.0
     */
    public void changeAllData(M data, M newData) {
        int capacity = this.data.getCapacity();
        
        if(data != null && this.data.findIndex(data) != -1 ){
             for(int index = 0; index<capacity; index++) {
                M current = findData(index);
                if(current.equals(data)) {
               
                    this.data.changeData(index, newData);
                }
             }
        }
    }
   
    /**
     * method to remove data
     * @param data to be removed
     * @version 1.0
     * @return if the data was removed
     */    
    public boolean removeData(M data) {
        int remove = findIndex(data);
        boolean removed = false;
            if(remove != -1) {
                this.data= null;
                removed = true;
            }
            return removed;
    }
    
    /**
     * method to remove data by index
     * @param index where the data is located
     * @version 1.0     
     * @return if the data was removed    
     */
    public boolean removeData(int index) {
        M remove = findData(index);
        boolean removed = false;
            if(remove != null) {
                this.data.removeData(index);
                removed = true;
            }
            return removed;
    }
    
    /**
     * method to remove identical data from the entire ArrayList
     * @param data that needs to be removed
     * @version 1.0
     */
    public void removeAllData(M data) {
        int capacity =  this.data.getCapacity();
        
        if(data != null && this.data.findIndex(data) != -1) {
            for(int index =0; index < capacity; index++) {
                M current = findData(index);
                if(current.equals(data)) {
                    this.data.removeData(index);
                }
            }
        }
    }
   
    /**
     * method to sort the data
     * @param comparator is a function from java.util that compares two arguments
     * @version 1.0
     */    
    public void sort(Comparator <M> comparator) {
        
        this.data.sort(comparator);
    }
    
    /**
     * Declare Extract Elements method
     * @param data in the Array
     * @param n is the number of data to be removed
     * @param start place to remove data
     * @return 
     */
    public  M[] extractElements(M[] data, int n, int start){
        M[] temp = (M[]) new String[n];
        if(start > -1 && n< this.data.getCapacity()){ //checking the boundaries
            for(int i = start; i < (start+n); i++){
            temp[i-start] = data[i];
             }            
        }
        return temp;
    }
        
        public ArrayUtils<M> getAllData() {
            return data;
        }
       
}
             
    
    
    
    //add element+; find element by index and value+; 
    //replace first+ element or all elements and replace by index+;
    //create a sort method (comparator)+;
    //remove element by index+; remove first element by value+; remove all by value+;
    //extract from StartIndex to EndIndex; extract from StartIndex n elements and boundaries;
    
