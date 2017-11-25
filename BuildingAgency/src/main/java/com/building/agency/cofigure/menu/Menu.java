/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.menu;

import com.building.agency.cofigure.menu.callback.MenuItemChosenListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Declares a menu
 * @author vbohudskyi
 * @version 1.1
 */
public abstract class Menu {
    
    private String header; //Menu header is stored here
    private List<MenuItemModel> items = null; //A list of possible menu items is stored here
    private MenuItemChosenListener onItemChosenListener; // Menu callback is desclared here
    private int menuType; // Menu type is stored here

    /**
     * Main menu constructor
     * @param header declares a header of menu
     * @param menuType stores a type of menu
     */
    public Menu(String header, int menuType)
    {
        this.header = header;
        this.menuType = menuType;
        items = new ArrayList<>();
    }
    
    /**
     * Sub constructor of menu
     * @param header declares a header of menu
     * @param items  declares items if menu
     * @param menuType the type of a menu is stored here
     */
    public Menu(String header, int menuType, List<MenuItemModel> items)
    {
        this.header = header;
        this.menuType = menuType;
        this.items = items;
    }
    
    /**
     * Constructor of a copy
     * @param menu 
     */
    public Menu(Menu menu)
    {
        this(menu.getHeader(), menu.getMenuType(), menu.getItems());
    }
    
    /**
     * Adds new menu item
     * @param item new menu item
     * @return menu
     */
    public Menu addMenuItem(MenuItemModel item)
    {
        items.add(item);
        return this;
    }
    
    /**
      * Sets itemChosen event callback
      * @param onItemChosenListener - listener
      */
    public void setOnItemChosenListener(MenuItemChosenListener onItemChosenListener) {
        this.onItemChosenListener = onItemChosenListener;
    }
    
    /**
     * method populates user decision and fires item chosen listener
     * @param choice user choice
     */
    public void populateUserDesicion(String choice)
    {
        if(onItemChosenListener != null)
        {
            MenuItemModel item = getMenuItembyUserChoice(choice);
            onItemChosenListener.onItemChosen(item, menuType);
        }
    }
    
    private MenuItemModel getMenuItembyUserChoice(String choice)
    {
        MenuItemModel searchingMenuItem = null;
        if(items != null)
        {
            for(MenuItemModel item : items)
            {
                if(String.valueOf(item.getItemPosition()).equalsIgnoreCase(choice))
                {
                    searchingMenuItem = item;
                    break;
                }
            }
        }
        return searchingMenuItem;
    }
    
     /**
     * Method provides possible menu positions
     * @return list of positions
     */
    public List<String> getItemsPositions()
    {
        List<String> positions = new ArrayList<>();
        if(items != null)
        {
            items.forEach((item) -> {
                positions.add(item.getItemPosition()+"");
            });
        }
        return positions;
    }
    
    /**
     * Method populates items
     */
    public abstract void populateMenu();
    
    //Accessors and mutators    
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<MenuItemModel> getItems() {
        return items;
    }
    
    public void setItems(List<MenuItemModel> items)
    {
        this.items = items;
    }
    
    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }
}
