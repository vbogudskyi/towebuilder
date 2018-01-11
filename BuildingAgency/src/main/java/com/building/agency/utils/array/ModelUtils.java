/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils.array;
import java.lang.reflect.Array;
import java.util.Comparator;


/**
 * Declare the Model Utils Class
 * @author nnastas
 * @version 1.0
 * @param <M> - a parameter type
 */
public class ModelUtils<M> {
    
    private ArrayUtils<M> data = null;
    private Class<M> clazz = null;//parameter type M
   
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
    
        this.clazz = clazz;
    }
    
    /**
     * Method to add data
     * @param data to be added
     * @return if data was added
     * @version 1.0
     */
    public boolean addData(M data) {
         boolean added = false;//default parameter
         int count = this.data.getCount();//gets the count of data in the Array
         int capacity = this.data.getCapacity();//gets the capacity of the Array
         
         if(count < capacity) {
             this.data.addData(data);//adds the data into the Array
             added = true;
         }
         return added;
     }
    /**
     * Declare the add all data method
     * @param data to be added
     * @param n number of data to be added
     * @param start position to add data
     */
    public void addAllData(M[] data, int n, int start){
        this.data.addAllData(data, n, start);//adds all the data into the Array
    }
    
    /**
     * declare the add all data without the start index method
     * @param data to be added
     * @param n number of data to be added
     */
    public void addAllData(M[] data, int n) {
        addAllData(data, n, 0); //call the addAllData method
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
           value = (M)this.data.findData(index);//call the findData method
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
        
        int index = -1;//assigning default value
        if(data != null){
            index = this.data.findIndex(data);//calling the findIndex method
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
      M change = findData(index);//assigning the index
        if(change != null) {
           this.data.changeData(index, newData);//changes the data by index
        }
        
    }
    
    /**
     * method to change the data in the entire ArrayList
     * @param data needed to be changed
     * @param newData replaces the old data\
     * @version 1.0
     */
    public void changeAllData(M data, M newData) {
        int capacity = this.data.getCapacity();//assigning the capacity of the Array
        
        if(data != null && this.data.findIndex(data) != -1 ){//validates the data and index
             for(int index = 0; index<capacity; index++) {
                M current = findData(index);//assigning the index
                if(current.equals(data)) {
               
                    this.data.changeData(index, newData);//changes all the data
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
        int remove = findIndex(data);//assigning the index based on the data
        boolean removed = false;//default value
            if(remove != -1) {
                this.data= null;//changes the data with null value
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
        M remove = findData(index);//assigning the data based on index
        boolean removed = false;//assigning default value
            if(remove != null) {
                this.data.removeData(index);//calls the removeData method
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
        int capacity =  this.data.getCapacity();//assigning the capacity of th Array
        
        if(data != null && this.data.findIndex(data) != -1) {//validates the data and index
            for(int index =0; index < capacity; index++) {
                M current = findData(index);//assign the data based on the index
                if(current.equals(data)) {
                    this.data.removeData(index);//removes all data
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
        
        this.data.sort(comparator);//call the Sort method
    }
    
    /**
     * Declare Extract Elements method
     * @param n is the number of data to be removed
     * @param start place to remove data     *
     * @return the extracted data
     */
    public M[] extractElements( int n, int start){
        M[] temp = (M[]) Array.newInstance(clazz, n);//create a new Array of type A containing n elements
        if (this.data != null){
            temp = (M[]) this.data.extractElements(n, start);//calls the extractElements method
        }
        return temp;
    }
    
    
    /**
     * Declare the extract Element by index method
     * @param start position to extract element
     * @param end position to extract element
     * @return the entire Array data
     */
    public M[] extractElementsByIndexes(int start, int end) {
        return extractElements(end-start,start); //Extract elements from start to end
            
    }

    // add extract element in data storagge,and arrayutils*
    //create method add all data, check for capacity, in data sotrage and up. *

}
    
    //add element+; find element by index and value+; 
    //replace first+ element or all elements and replace by index+;
    //create a sort method (comparator)+;
    //remove element by index+; remove first element by value+; remove all by value+;
    //extract from StartIndex to EndIndex; extract from StartIndex n elements and boundaries;
    
