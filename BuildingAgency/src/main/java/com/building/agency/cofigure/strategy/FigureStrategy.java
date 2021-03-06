/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy;

import com.building.agency.base.Figure2d;
import com.building.agency.base.Figure3d;
import com.building.agency.base.figure3d.Frusta;
import com.building.agency.base.figure3d.Prism;
import com.building.agency.base.figure3d.Pyramid;
import com.building.agency.base.figure3d.Wedge;
import com.building.agency.base.figures2d.Circle;
import com.building.agency.base.figures2d.Parallelogramm;
import com.building.agency.base.figures2d.Polygon;
import com.building.agency.base.figures2d.Rectangle;
import com.building.agency.base.figures2d.Romb;
import com.building.agency.base.figures2d.Triangle;
import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.cofigure.app.CompanyContext;
import com.building.agency.utils.InputUtils;
import com.building.agency.utils.M;
import com.building.agency.utils.array.ModelUtils;

/**
 * Creates 2D and 3D figures. Needs refactoring and data validation
 * @author vbohudskyi
 * @version 1.0
 */
public class FigureStrategy {
    
    private ApplicationContext context = null; // application context is stored here
    
    public FigureStrategy(ApplicationContext context)
    {
        this.context = context; // application context is assigned here
    }
    
    /**
     * Creates a 2D figure
     * @param figure new figure;
     * @return 
     */
    public Figure2d buildFigure2D(int figure)
    {
        Figure2d newFigure = null; // figure 2d should be assigned here
        switch(figure)
        {
            case M.figures_2d.TRIANGLE: // if a triangle is chosen
            {
                double a = InputUtils.getDoubleValue(context, M.dialogs.FIRST_SIDE_OF_A_TRIANGLE,
                        M.dialogs.TRIANGLE_ERROR_MESSAGE); // the AB side length is entered
                double b = InputUtils.getDoubleValue(context, M.dialogs.SECOND_SIDE_OF_A_TRIANGLE,
                        M.dialogs.TRIANGLE_ERROR_MESSAGE); // the BC side length is entered
                double c = InputUtils.getDoubleValue(context, M.dialogs.THIRD_SIDE_OF_A_TRIANGLE,
                        M.dialogs.TRIANGLE_ERROR_MESSAGE); // the AC side length is entered
                newFigure = new Triangle(a, b, c); // a triangle is created
                break;
            }
            case M.figures_2d.CIRCLE: // if a circle is chosen
            {
                double radius = InputUtils.getDoubleValue(context, M.dialogs.CIRCLE_RADIUS_MESSAGE,
                        M.dialogs.CIRCLE_ERROR_MESSAGE); // a circle radius is entered
                newFigure = new Circle(radius); // a circle is created
                break;
            }
            
            case M.figures_2d.RECTANGLE: // if a rectangle is chosen
            {
                double height = InputUtils.getDoubleValue(context, M.dialogs.RECTANGLE_HEIGHT, 
                        M.dialogs.RECTAGLE_ERROR); // a rectangle height is entered 
                double width = InputUtils.getDoubleValue(context, M.dialogs.RECTANGLE_WIDTH, 
                        M.dialogs.RECTAGLE_ERROR); // a rectangle width is entered
                newFigure = new Rectangle(width, height); // a rectangle is created
                break;
            }
            
            case M.figures_2d.PARALLELOGRAMM: // if a parrallelogramm is chosen
            {
                double width = InputUtils.getDoubleValue(context, M.dialogs.PARALLELOGRAMM_WIDTH, 
                        M.dialogs.PARALLELOGRAMM_ERROR); // a parallelogramm width is entered
                double height = InputUtils.getDoubleValue(context, M.dialogs.PARALLELOGRAMM_HEIGHT, 
                        M.dialogs.PARALLELOGRAMM_ERROR); // a parallelogramm height is entered
                double angle = InputUtils.getDoubleValue(context, M.dialogs.PARALLEOLGRAMM_ANGLE, 
                        M.dialogs.PARALLEOLGRAMM_ANGLE);
                newFigure = new Parallelogramm(width, height, angle); // parallelogramm is created 
                break;
            }
            
            case M.figures_2d.ROMB: // if romb is chosen
            {
                // a romb width is entered
                double width = InputUtils.getDoubleValue(context, M.dialogs.ROMB_WIDTH, M.dialogs.ROMB_ERROR);
                double angle = InputUtils.getDoubleValue(context, M.dialogs.ROMB_ANGLE,
                        M.dialogs.ROMB_ANGLE_ERROR); // a romb height is entered
                newFigure = new Romb(width, angle); // a romb is created
                break;
            }
            
            case M.figures_2d.POLYGON: // if polygon is chosen
            {
                int sidesCount = InputUtils.getIntValue(context, M.dialogs.POLYGON_SIDES_COUNT, 
                        M.dialogs.POLYGON_SIDES_COUNT_ERROR); // polygon sides amount is got
                double side = 0; //the length of current polygon side
                //PolygonUtils utils = null; // utils to perform operations with a polygon are stored here
                ModelUtils<Double> polygonModel = new ModelUtils<>(Double.class, sidesCount); // utils to work with polygon sides
                for(int i = 0; i<sidesCount; i++){
                    String message = String.format(M.dialogs.POLYGON_SIDE, i+1); 
                    // the length of i-side of the polygon is set
                    side = InputUtils.getDoubleValue(context, message, M.dialogs.POLYGON_SIDE_ERROR);
                    polygonModel.addData(side); // add a polygon side
                }
                newFigure = new Polygon(M.constants.POLYGON_RADIUS, polygonModel);
                break;
            }
        }
        return newFigure;
    }
    
    /**
     * Generates a 3D figure
     * @param base - 2D figure, a base of 3D figure
     * @param figure - 3D figure type
     * @return 3D figure
     */
    public Figure3d buildFigure3D(int base, int figure)
    {
        CompanyContext ctx = (CompanyContext)context; // application context is explicitly casted into CompanyContext
        Figure3d newFigure = null; // 3d figure is stored here
        Figure2d base_figure = buildFigure2D(base); // base figure is stored here
        double height = 0; // the height of 3d figure is stored here
        switch(figure)
        {
            case M.figure_3d.DIAGONAL_CUPOLAE: // if some kind of cupolae is chosen
            {
                height = InputUtils.getDoubleValue(context, String.format(M.dialogs.FIGURE_3D_HEIGHT, "cupolae"), 
                    String.format(M.dialogs.FIGURE_3D_HEIGHT_ERROR, "cupolae")); // cupolae height is calculated here
                
                newFigure = ctx.getCupolaeStrategy().buildCupolae(figure, 
                        base_figure, height); // cupolae is created
                break;
            }
            
            case M.figure_3d.PRISM:
            {
                height = InputUtils.getDoubleValue(context, String.format(M.dialogs.FIGURE_3D_HEIGHT, "prism") , 
                    String.format(M.dialogs.FIGURE_3D_HEIGHT_ERROR, "prism")); // prism height is calculated here
                newFigure = new Prism(base_figure, height); // prism is created
                break;
            }
            
            case M.figure_3d.WEDGE:
            {
                height = InputUtils.getDoubleValue(context, String.format(M.dialogs.FIGURE_3D_HEIGHT, "wedge") , 
                    String.format(M.dialogs.FIGURE_3D_HEIGHT_ERROR, "wedge")); // prism height is calculated here
                newFigure = new Wedge(base_figure, null, height); // wedge is created
                break;
            }
            
            case M.figure_3d.PYRAMID:
            {
                height = InputUtils.getDoubleValue(context, String.format(M.dialogs.FIGURE_3D_HEIGHT, "pyramid") , 
                    String.format(M.dialogs.FIGURE_3D_HEIGHT_ERROR, "pyramid")); // prism height is calculated here
                newFigure = new Pyramid(base_figure, height); // pyramod is created
                break;
            }
        }
        
        return newFigure;
    }
    
    /**
     * Generates a 3D figure
     * @param base - 2D figure, a base of 3D figure
     * @param upper - 2D figure, an upper base of 3D figure
     * @param figure - 3D figure type
     * @return 3D figure
     */
    public Figure3d buildFigure3D(int base, int upper, int figure)
    {
        CompanyContext ctx = (CompanyContext)context; // application context is explicitly casted into CompanyContext
        Figure3d newFigure = null; // 3d figure is stored here
        Figure2d base_figure = buildFigure2D(base); // 3d figure base is stored here
        Figure2d upper_base = buildFigure2D(upper); // 3d figure upper base is stored here
        switch(figure)
        {
            case M.figure_3d.TRANGULAR_CUPOLAE: // if some kind of cupolae is chosen
            {
                double height = InputUtils.getDoubleValue(context, String.format(M.dialogs.FIGURE_3D_HEIGHT, "cupolae"), 
                    String.format(M.dialogs.FIGURE_3D_HEIGHT_ERROR, "cupolae")); // cupolae height is stored here
                
                newFigure = ctx.getCupolaeStrategy().buildCupolae(figure, 
                        base_figure, upper_base, height); // cupolae is created
                break;
            }
            
            case M.figure_3d.FRUSTA:
            {
                double height = InputUtils.getDoubleValue(context, String.format(M.dialogs.FIGURE_3D_HEIGHT, "frusta"), 
                    String.format(M.dialogs.FIGURE_3D_HEIGHT_ERROR, "frusta")); // frusta height is stored here
                newFigure = new Frusta(upper_base, upper_base, height); // frusta is created
                break;
            }
            
            case M.figure_3d.WEDGE:
            {
                double height = InputUtils.getDoubleValue(context, String.format(M.dialogs.FIGURE_3D_HEIGHT, "wedge"), 
                    String.format(M.dialogs.FIGURE_3D_HEIGHT_ERROR, "wedge")); // wedge height is stored here
                newFigure = new Wedge(upper_base, upper_base, height); // wedge is created
                break;
            }
        }
        return newFigure;
    }
}
