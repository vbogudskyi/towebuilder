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
 * @param <A> - a parameter type
 */
public abstract class ArrayUtils<A> {
    
    private DataStorage data = null; // data storage is assigned here
    
    public abstract void onSuccess(A data);// method calls in cases of success 
    public abstract void onFailure(A data);// method calls in case of failure
    private Class<A> clazz;//
    
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
           onSuccess(data);//calls the onSuccess method
        } else 
           onFailure(data);//call the onFail method
    }  
    /**
     * Declare add all data method
     * @param data to be added
     * @param n number of data to be added
     * @param start position to add data
     */
    public void addAllData(A[] data, int n, int start){
        this.data.addAllData(data, n, start);//calls the addAllData method
                                             //from data storage
    }
    
    /**
     * Declare method to add all data without start position
     * @param data to be added
     * @param n number of data to be added
     */
    public void addAllData(A[] data, int n){
        addAllData(data,n,0);//calls the addAllData method
    }
    
    /**
     * method to find data
     * @param data looked up for
     * @version 1.0
     */
    public void findData(A data) {
        if(this.data.findData(data) != -1){
            onSuccess(data);//calls the onSuccess method
        } else
            onFailure(data);//calls the onFailure method
    }
    
    
    /**
     * method to find a value based on index
     * @param index of the value
     * @return the value based on index
     * @version 1.0
     */
    public A findData(int index) {
        A value = null;//assign a null value
        if(index >=0) {
           value = (A)this.data.findData(index);//get data by index
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
        int index = 0;//assign 0 value
        if(data != null) {
            index = this.data.findData(data);//get data by data
        }
        return index;
    }
    
    /**
     * method to get the array capacity
     * @return the capacity of the Array
     * @version 1.0
     */
    public int getCapacity(){
        
      return this.data.getCapacity();  //get capacity of the Array
    }
    
    /**
     * method to get the count of data
     * @return the data count
     * @version 1.0
     */
    public int getCount() {
        return this.data.getCount();//get the amount of the elements in the Array
    }
     
    /**
     * method to change data
     * @param data to be changed
     * @param newData changes the old data
     * @version 1.0
     */
    public void changeData(A data, A newData) {
        if(this.data.changeData(data,newData)){
           onSuccess(newData); //calls the onSuccess method
        } else
            onFailure(newData); //calls the onFailure method
    }
    
    /**
     * method to change data by index
     * @param index where the data is located
     * @param newData changes the old data
     * @version 1.0
     */
    public void changeData(int index, A newData) {
        if(this.data.changeData(index, newData)) {
            onSuccess(newData);//calls the onSuccess method
        } else
            onFailure(newData);//calls the onFailure method
    }
    
    /**
     * method to remove data
     * @param data to be removed
     * @version 1.0
     */
    public void removeData(A data) {
        if(this.data.removeData(data)) {
            onSuccess(data);//calls the onSuccess method
        } else
            onFailure(data);//calls the onFailure method
    }
    
    /**
     * method to remove data by index
     * @param index where the data is located
     * @version 1.0
     */
    public void removeData(int index) {
        if(this.data.removeData(index)) {
            onSuccess((A)data);//calls the onSuccess method
        } else
            onFailure((A)data);//calls the onFailure method
    }
    
    /**
     * method to sort the data
     * @param comparator is a function from java.util that compares two arguments
     * @version 1.0
     */
    public void sort(Comparator <A> comparator){
       this.data.sort(comparator);  //sort the data with the comparator's conditions     
    } 
    
    /**
     *Declare extract Element Method
     * @param n number of data to be removed
     * @param start place to remove data
     * @return the extracted data
     */
    public A[] extractElements(int n, int start){
        A[] temp = (A[]) Array.newInstance(clazz, n);//create a new Array of type A 
        if(data != null ){                           //containing n elements
            temp = (A[]) this.data.extractElements(n, start);//extract data from start indext 
        }                                                    //to n elements
        return temp;
    }

    
    /**
     * Declare the Data Storage of incoming data
     * @version 1.0
     * @param <B> parameter type of data
     */
   
    protected static class DataStorage<B> {
        private final B[] data;// Data Sorage data is stored here
        private int count;//how much data is in the Array
        private final int capacity;//maximum Arrays that can be added
        private final Class<B> clazz;//--------->need to check
        /**
         * Default constructor for Data Storage
         * @param clazz - is the information of parameterized type of Array element
         * @param capacity array capacity
         * @version 1.0
         */
        public DataStorage(Class<B> clazz, int capacity){
            this.clazz = clazz;//get type of adata
            this.capacity = capacity;//get capacit
            this.count = 0;//count is 0
            data = (B[])Array.newInstance(clazz, capacity);//creates an Array with B type data and capacity
        }
       
        /**
         * Method to add new data
         * @param data that needs to be added
         * @return return either the data was added or not
         * @version 1.0
         */
        public boolean addData(B data){
            boolean added = false;//default is false
            if (count < capacity) {
               this.data[count++] = data;//adds new data
               added = true;//return true
            }
            return added;
        }
        
        /**
         * Declare add all data method
         * @param data to be added
         * @param n data need to be added
         * @param start position to add data
         */
        public void addAllData(B[] data, int n, int start){           
            if((start > -1) && ((start+n) < data.length)){//verifying that the start is within the Array boundaries
                if((count > -1) && (n < (capacity-count))){//verifing the bounderies of the Array              
                System.arraycopy(data, 0, this.data, start, n);//Writing data into storage
                count+=data.length;//increase the count of the elements
                }
            }
        }
        
        /**
         * Declare add all Data without Start index
         * @param data to be added
         * @param n data need to be added
         */
        public void addAllData(B[] data, int n) {
            addAllData(data,n,0);//Write data from the begining of the Array
        }    
        
        
        /**
         * Method to find specific data
         * @param data looked up for
         * @return the place where the data is located
         * @version 1.0
         */
        public int findData(B data) {
            int place = -1;//adding the default index
            for (int index = 0; index < count; index++){
                if (data==this.data[index]) {//if data is found an index is asigned
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
            if ((index < capacity) && (index >= 0)) {//verify the index 
               value = data[index];//assign the data by index
            }
            return value;
        }
        
        /**
         * Method to get the Array capacity
         * @return the capacity of the Array
         * @version 1.0
         */
        public int getCapacity() {
        return this.capacity;//getting the capacity
        }

        /**
         * Method to get the count of the data
         * @return the count of data
         * @version 1.0
         */
        public int getCount() {
        return this.count;//getting the count of data in the Array
        }
        
        /**
         * Method to change one data with another
         * @param data needed to be replaced
         * @param newData replaces the old data
         * @return either the data was changed or not
         * @version 1.0
         */
        public boolean changeData(B data, B newData) {
            int change = findData(data);//find the data in the Array
            boolean added = false;//default value is false
                if(change != -1){
                   this.data[change] = newData; //change the new data 
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
           
            boolean added = false;//default value is alse
                if((index > -1) || (index < capacity)){//checking the index validity
                    this.data[index] = newData;//change data by index
                    
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
            int remove = findData(data);//finding the data in the Array
            boolean removed = false;//default value is false
                if(remove != -1) {
                    this.data[remove]= null;//assign null to remove the data
                    removed = true;
                 }
            drop();//call the drop method
            count--;//reduce the amount of elements in Array
            return removed;
        }
        /**
         * Replaces data by index replacing it with null
         * @param index where the data is locate
         * @return either the data was removed or not
         * @version 1.0
         */
        public boolean removeData(int index) {
            boolean removed = false;//default value is false
            if((index > -1) || (index < capacity)) {//checking the index validity
                this.data[index] = null;//assign null to remove the data by index
                removed = true;
            }
            drop();//call the drop method
            count--;//reduce the amount of elements in Array
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
        
         /**
          * Declare Extract Elements method
          * @param n is number of data to be removed
          * @param start place to remove data
          * @return the extracted data
          */
        public B[] extractElements(int n, int start){
            B[] temp = (B[])Array.newInstance(clazz, n);//create a new Array of type A containing n elements
            if(start > -1 && n < this.data.length){
                for(int i = start; i<(start+n); i++){
                    temp[i-start]=data[i];//extract elements
                }
            }
            return temp;
        }
        
        /**
         * Declare Extract Elements by Index method
         * @param start place to remove data
         * @param end place to remove data
         * @return 
         */
        public B[] extractElementByIndex(int start, int end){
            
            return extractElements(end-start, start);//Extract elements from start to end
        }
        
        
    }  
}
