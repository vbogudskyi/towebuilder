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
import com.building.agency.cofigure.io.model.PorfolioSerializer;
import com.building.agency.cofigure.io.model.PortfolioModel;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Declares a content provider, which retrieves a data from different sources
 * @author vbohudskyi
 * @version 1.0
 */
public class ContentProvider {
    
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
    
    /**
     * 
     * @param json_file - json file name
     * @return
     * @throws IOException 
     */
    public PortfolioModel getFiguresPorfolio(String json_file) throws IOException
    {
        JsonReader reader = new JsonReader(new FileReader(json_file));
        PorfolioSerializer serializer = context.getGson().fromJson(reader, PorfolioSerializer.class);
        return serializer.getProtfolio();
    }
}
