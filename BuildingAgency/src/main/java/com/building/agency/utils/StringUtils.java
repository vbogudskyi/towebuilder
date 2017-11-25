/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

/**
 * Declares string utilities
 * @author vbohudskyi
 * @version 1.0
 */
public final class StringUtils {
    /**
     * 
     * @param s a string parameter
     * @return true if a string is null or empty
     */
    public static boolean isNullOrEmpty(String s)
    {
        return (s == null)||(s.isEmpty());
    }  
}
