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
            instance = new Math2dUtils(); // if math utils instance is not created - create it
        }
        return instance; // returns existent math utils 
    }

    /**
     * Calculates one of three angles of a triangle
     * @param triangle current triangle
     * @return angle(double)
     */
    private double calculateGamma(Triangle triangle) {
        if (isTriangleExist(triangle)) { // checks if a triangle exists
            // calculates a cos of the third angle of a triangle
            double cosGamma = (Math.pow(triangle.getB(), 2) + Math.pow(triangle.getC(), 2)
                    - Math.pow(triangle.getA(), 2)) / triangle.getB() / triangle.getC() / 2;
            // calculates an angle
            return Math.acos(cosGamma);
        }
        // returns error code of a triangle does not exist
        return M.errors.TRIANGLE_NOT_EXIST;
    }

     /**
     * Calculates one of three angles of a triangle
     * @param triangle current triangle
     * @return angle(double)
     */
    private double calculateBeta(Triangle triangle) {
        double alpha = calculateGamma(triangle); // calcualtes the third angle of a triangle
        double sinBeta = triangle.getB() * Math.sin(alpha) / triangle.getA(); // calculates the second angle of a triangle
        // retrieves a second angle from sin angle
        return Math.asin(sinBeta);
    }

    /**
     * Method detects if a triangle exists
     * @param triangle current triangle
     * @return true is exists
     */
    public boolean isTriangleExist(Triangle triangle) {
        double a = triangle.getA(); //  get AB edge
        double b = triangle.getB(); // get BC edge
        double c = triangle.getC(); // get AC edge
        return ((b + c) > a) && ((a + b) > c) && ((a + c) > b); // a condition of existence a triangle
    }

    /**
     * Method detects if a parallelogramm exists
     * @param parallelogramm  current parallelogramm
     * @return true is exists
     */
    public boolean isParallelogrammExist(Parallelogramm parallelogramm) {
        double a = parallelogramm.getWidth(); // get a parallelogramm width
        double b = parallelogramm.getHeight(); // get a parallelogramm height
        double alpha = parallelogramm.getAlpha(); // get a parallelogramm alpha
        return (a > 0) && (b > 0) && (alpha > 0); // condition of existence of a parallelogramm
    }
    
    /**
     * Method detects if a polygon exists
     * @param polygon  current polygon
     * @return true is exists
     */
    public boolean isPolygonExist(Polygon polygon) {
        return polygon.getRadius() > 0; // the condition of existencse of a polygon
    }

    /**
     * Method calculates a triangle area
     * @param triangle current triangle
     * @return area (double)
     */
    public double calculateTriangleScale(Triangle triangle) {
        if (isTriangleExist(triangle)) { // if a triangle exists
            // calculate a triangle area
            return triangle.getB() * triangle.getC() * Math.sin(calculateGamma(triangle));
        }
        // error if a triangle does not exist
        return M.errors.TRIANGLE_NOT_EXIST;
    }

    /**
     * Method calculates a circle area
     * @param circle current circle
     * @return area (double)
     */
    public double calculateCircleScale(Circle circle) {

        if (circle.getRadius() > 0) { // if a circle exists
            // calculate a polygon area
            return Math.PI * Math.pow(circle.getRadius(), 2);
        }
        // error if circle does not exist
        return M.errors.CIRCLE_NOT_EXIST;
    }

    /**
     * Method calculates a polygon area
     * @param polygon current polygon
     * @return area (double)
     */
    public double calculatePolygonScale(Polygon polygon) {
        if (isPolygonExist(polygon)) { // if a polygon exists
            double[] sides = polygon.getSides();  // sides of a polygon a stored here
            double perimeter = 0; // a perimeter of a polygon stored here
            for (double side : sides) {
                perimeter = perimeter + side; // a calculation of a perimeter
            }

            return perimeter * polygon.getRadius() / 2; // perimeter is calculated
        }
        // error if a polygon does not exist
        return M.errors.POLYGON_NOT_EXIST;
    }

    /**
     * Method calculates a parallelogramm area
     * @param parallelogramm  current parallelogramm
     * @return area (double)
     */
    public double calculateParallelogrammScale(Parallelogramm parallelogramm) {
        if (isParallelogrammExist(parallelogramm)) { // if a parallegramm exists
            //calculates an area of parallelogramm
            return parallelogramm.getWidth()* parallelogramm.getHeight()* Math.sin(parallelogramm.getAlpha());
        }
        // error if parallelogramm does not exist
        return M.errors.PARALLELOGRAMM_NOT_EXIST;
    }
}
