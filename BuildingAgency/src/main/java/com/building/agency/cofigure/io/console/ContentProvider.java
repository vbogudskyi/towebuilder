/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.io.console;

import com.building.agency.base.Figure2d;
import com.building.agency.base.Figure3d;
import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.cofigure.io.FileIO;

/**
 * Declares a content provider, which retrieves a data from different sources
 * @author vbohudskyi
 * @version 1.0
 */
public class ContentProvider {
    
    private FileIO io = null; //file io utils are stored here
    private ApplicationContext context = null; // application context is tored here
    
    /**
     * Declares a data input stream
     * @param context - data input stream 
     * @version 1.0
     */
    public ContentProvider(ApplicationContext context)
    {
        this.context = context; // application context is assigned here
    }
    
    /**
     * Creates a 2d figure 
     * @param figure - figure type
     * @return 2d figure
     */
    public Figure2d getFigure2D(int figure)
    {
         CompanyContext ctx = (CompanyContext) context; // application context is explicitly cast to CompanyContext
         return ctx.getFigures().buildFigure2D(figure); // 2d figure is created
    }
    
    /**
     * Creates a 3d figure
     * @param base - base of 3d figure
     * @param figure - type of 3d figure
     * @return 3d figure
     */
    public Figure3d getFigure3D(int base, int figure)
    {
        CompanyContext ctx = (CompanyContext) context; // application context is explicitly cast to CompanyContext
        return ctx.getFigures().buildFigure3D(base, figure); // 3d figure is created
    }
    
    /**
     * Creates a 3d figure
     * @param base - base of 3d figure
     * @param upper - upper base of figure 3D
     * @param figure - type of 3d figure
     * @return 3d figure
     */
    public Figure3d getFigure3D(int base, int upper, int figure)
    {
        CompanyContext ctx = (CompanyContext) context; // application context is explicitly cast to CompanyContext
        return ctx.getFigures().buildFigure3D(base, upper, figure); // 3d figure is created
    }
}
