/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils.array;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Declare the ArrayUtils Class
 * @author nnastas
 * @version 1.0
 * @param <A>
 */
public abstract class ArrayUtils<A> {
    
    private DataStorage data = null; // data storage is assigned here
    
    public abstract void onSuccess(A data);// method calls in cases of success 
    public abstract void onFailure(A data);// method calls in case of failure
    
    /**
     * Declare the constructor for ArrayUtils 
     * @param clazz contains the data of type A
     * @param capacity of the Array length
     * @version 1.0
     */
    public ArrayUtils(Class<A> clazz, int capacity){
        
        data = new DataStorage<>(clazz, capacity);// creates data storage
    }
    /**
     * method to add data
     * @param data to be added
     * @version 1.0
     */
    public void addData(A data) {
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
    public void findData(A data) {
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
    public A findData(int index) {
        A value = null;
        if(index >=0) {
           value = (A)this.data.findData(index);
        } 
     return value;       
    }
    
    /**
     * method to find the index based on the data
     * @param data that is stored
     * @return the index for the data
     * @version 1.0
     */
    public int findIndex(A data) {
        int index = 0;
        if(data != null) {
            index = this.data.findData(data);
        }
        return index;
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
    public void changeData(A data, A newData) {
        if(this.data.changeData(data,newData)){
           onSuccess(newData); 
        } else
            onFailure(newData);
    }
    
    /**
     * method to change data by index
     * @param index wher the data is located
     * @param newData changes the old data
     * @version 1.0
     */
    public void changeData(int index, A newData) {
        if(this.data.changeData(index, newData)) {
            onSuccess(newData);
        } else
            onFailure(newData);
    }
    
    /**
     * method to remove data
     * @param data to be removed
     * @version 1.0
     */
    public void removeData(A data) {
        if(this.data.removeData(data)) {
            onSuccess(data);
        } else
            onFailure(data);
    }
    
    /**
     * method to remove data by index
     * @param index where the data is located
     * @version 1.0
     */
    public void removeData(int index) {
        if(this.data.removeData(index)) {
            onSuccess((A)data);
        } else
            onFailure((A)data);
    }
    
    /**
     * method to sort the data
     * @param comparator is a function from java.util that compares two arguments
     * @version 1.0
     */
    public void sort(Comparator <A> comparator){
       this.data.sort(comparator);
       
           
      
    }      

    
    /**
     * Declare the Data Storage of incoming data
     * @version 1.0
     */
   
    protected static class DataStorage<B> {
        private B[] data;// Data Sorage data is stored here
        private int count;//how much data is in the Array
        private final int capacity;//maximum Arrays that can be added
        
        /**
         * Default constructor for Data Storage
         * @param clazz - is the information of parameterized type of Array element
         * @param capacity array capacity
         * @version 1.0
         */
        public DataStorage(Class<B> clazz, int capacity){
            this.capacity = capacity;
            this.count = 0;
            data = (B[])Array.newInstance(clazz, capacity);//creates an Array with B type data and capacity
        }
       
        /**
         * Method to add new data
         * @param data that needs to be added
         * @return return either the data was added or not
         * @version 1.0
         */
        public boolean addData(B data){
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
        public int findData(B data) {
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
        public B findData(int index) {
            B value = null;
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
        public boolean changeData(B data, B newData) {
            int change = findData(data);
            boolean added = false;
                if(change != -1){
                   this.data[change] = newData; 
                   added = true;
                }
            
            return added; 
        }
        
        /**
         * Method to change one data with another by index
         * @param index where the data is located
         * @param newData replaces the old data
         * @return either the data was changed or not
         * @version 1.0
         */
        public boolean changeData(int index,B newData) {
           
            boolean added = false;
                if((index > 0) || (index <= capacity)){
                    this.data[index] = newData;
                    
                    added = true;
                }
                return added;
        }
        /**
         * moves the null value to the end of the Array
         * @version 1.0
         */
        private void drop() {
        
            int items = 0;
            //shift all null elements to the end
            for (int j=0; j<data.length; j++){
                  if (data[j]==null){
                    for (int k=j+1; k<data.length; k++){
                    data[k-1] = data[k];
                    }
                data[data.length-1] = null;               
                break;
                }
            }            
        }
        
        /**
         * Removes data from the array by replacing it with null
         * @param data to be removed
         * @return either the data is or not removed
         * @version 1.0
         */
        public boolean removeData(B data) {
            int remove = findData(data);
            boolean removed = false;
                if(remove != -1) {
                    this.data[remove]= null;
                    removed = true;
                 }
            drop();
            count--;
            return removed;
        }
        /**
         * Replaces data by index replacing it with null
         * @param index where the data is locate
         * @return either the data was removed or not
         * @version 1.0
         */
        public boolean removeData(int index) {
            boolean removed = false;
            if((index > 0) || (index <= capacity)) {
                this.data[index] = null;
                removed = true;
            }
            drop();
            count--;
            return removed;
        }
        /**
         * Sorts the data  by comparing them
         * @param comparator is a function from java.util that compares two arguments
         * @version 1.0
         */
         public void sort(Comparator<B> comparator){
             if(comparator != null){
                for (int i=0; i<data.length; i++){
                    for(int j=0; j<data.length; j++) {
                        if (comparator.compare(data[i], data[j]) == 1){
                        B k = data[j]; 
                        data[j]=data[i];
                        data[i] = k;                    
                        break;
                        }
                    }
                }
            }
        }
        
        
    }
    
    
    
}
