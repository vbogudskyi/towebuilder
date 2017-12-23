/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

import java.io.File;
import java.net.URL;

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
    
    /**
     * 
     * @param pkg - current package
     * @param filename - current filename
     * @return file
     * @version 1.0
     */
    public static final File getFileAbsolutePath(String pkg, String filename)
    {
        URL root = Thread.currentThread().getContextClassLoader().getResource(pkg.replace(".", "/"));
        String fullPath = root.getFile()+File.separator+filename;
        File seachFile = new File(fullPath);
        return seachFile;
    }
}
