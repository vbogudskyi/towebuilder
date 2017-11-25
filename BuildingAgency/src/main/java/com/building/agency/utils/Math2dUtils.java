/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

import com.building.agency.base.figures2d.Circle;
import com.building.agency.base.figures2d.Parallelogramm;
import com.building.agency.base.figures2d.Polygon;
import com.building.agency.base.figures2d.Triangle;

/**
 *
 * Declares necessary math utilities
 * @author vbohudskyi
 * @version 1.0
 */
public class Math2dUtils {

    private static Math2dUtils instance = null; //Instance of MathUtils

    /**
     * Private constructor - required by singleton pattern
     */
    private Math2dUtils() {
    }

    /**
     * Method provides an instance of MathUtils
     * @return 
     */
    public synchronized static Math2dUtils getInstance() {
        if (instance == null) {
            instance = new Math2dUtils();
        }
        return instance;
    }

    /**
     * Calculates one of three angles of a triangle
     * @param triangle current triangle
     * @return angle(double)
     */
    private double calculateGamma(Triangle triangle) {
        if (isTriangleExist(triangle)) {
            double cosGamma = (Math.pow(triangle.getB(), 2) + Math.pow(triangle.getC(), 2)
                    - Math.pow(triangle.getA(), 2)) / triangle.getB() / triangle.getC() / 2;
            return Math.acos(cosGamma);
        }
        return M.errors.TRIANGLE_NOT_EXIST;
    }

     /**
     * Calculates one of three angles of a triangle
     * @param triangle current triangle
     * @return angle(double)
     */
    private double calculateBeta(Triangle triangle) {
        double alpha = calculateGamma(triangle);
        double sinBeta = triangle.getB() * Math.sin(alpha) / triangle.getA();
        return Math.asin(sinBeta);
    }

    /**
     * Method detects if a triangle exists
     * @param triangle current triangle
     * @return true is exists
     */
    public boolean isTriangleExist(Triangle triangle) {
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();
        return ((b + c) > a) && ((a + b) > c) && ((a + c) > b);
    }

    /**
     * Method detects if a parallelogramm exists
     * @param parallelogramm  current parallelogramm
     * @return true is exists
     */
    public boolean isParallelogrammExist(Parallelogramm parallelogramm) {
        double a = parallelogramm.getWidth();
        double b = parallelogramm.getHeight();
        double alpha = parallelogramm.getAlpha();
        return (a > 0) && (b > 0) && (alpha > 0);
    }
    
    /**
     * Method detects if a polygon exists
     * @param polygon  current polygon
     * @return true is exists
     */
    public boolean isPolygonExist(Polygon polygon) {
        return polygon.getRadius() > 0;
    }

    /**
     * Method calculates a triangle area
     * @param triangle current triangle
     * @return area (double)
     */
    public double calculateTriangleScale(Triangle triangle) {
        if (isTriangleExist(triangle)) {
            return triangle.getB() * triangle.getC() * Math.sin(calculateGamma(triangle));
        }
        return M.errors.TRIANGLE_NOT_EXIST;
    }

    /**
     * Method calculates a circle area
     * @param circle current circle
     * @return area (double)
     */
    public double calculateCircleScale(Circle circle) {

        if (circle.getRadius() > 0) {
            return Math.PI * Math.pow(circle.getRadius(), 2);
        }

        return M.errors.CIRCLE_NOT_EXIST;
    }

    /**
     * Method calculates a polygon area
     * @param polygon current polygon
     * @return area (double)
     */
    public double calculatePolygonScale(Polygon polygon) {
        if (isPolygonExist(polygon)) {
            double[] sides = polygon.getSides();
            double perimeter = 0;
            for (double side : sides) {
                perimeter = perimeter + side;
            }

            return perimeter * polygon.getRadius() / 2;
        }
        
        return M.errors.POLYGON_NOT_EXIST;
    }

    /**
     * Method calculates a parallelogramm area
     * @param parallelogramm  current parallelogramm
     * @return area (double)
     */
    public double calculateParallelogrammScale(Parallelogramm parallelogramm) {
        if (isParallelogrammExist(parallelogramm)) {
            return parallelogramm.getWidth()* parallelogramm.getHeight()* Math.sin(parallelogramm.getAlpha());
        }

        return M.errors.PARALLELOGRAMM_NOT_EXIST;
    }
}
