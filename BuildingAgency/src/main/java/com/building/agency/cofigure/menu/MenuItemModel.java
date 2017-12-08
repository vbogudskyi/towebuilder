/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.menu;
/**
 * Declares an item of menu with behaviour
 * @author vbohudskyi
 * @version 1.0
 */
public final class MenuItemModel {
    
    private int itemPosition = -1; //Menu item number is stored here
    private String itemValue = null; //Menu item name is stored here
    /**
     *  Menu item main constructor
     *  @param itemPosition menu item number according to the list
     *  @param itemValue menu item name;
     */
    public MenuItemModel(int itemPosition, String itemValue)
    {
        this.itemPosition = itemPosition; // item position is assigned here
        this.itemValue = itemValue; // item value is assigned here
    }
    /**
     * Constructor of a copy
     * @param model base item model to create a new item 
     */
    public MenuItemModel(MenuItemModel model)
    {
        this(model.getItemPosition(), model.getItemValue());
    }
    /**
     * Prints a menu item at the console
     */
    public void printMenuItem()
    {
        System.out.println(itemPosition+":"+itemValue);
    }
    // Accessors and mutators
    
     public int getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(int itemNumber) {
        this.itemPosition = itemNumber;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }  
}
