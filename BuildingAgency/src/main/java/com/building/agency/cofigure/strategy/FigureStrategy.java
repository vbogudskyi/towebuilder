/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy;

import com.building.agency.base.Figure2d;
import com.building.agency.base.Figure3d;
import com.building.agency.base.figures2d.Circle;
import com.building.agency.base.figures2d.Parallelogramm;
import com.building.agency.base.figures2d.Rectangle;
import com.building.agency.base.figures2d.Romb;
import com.building.agency.base.figures2d.Triangle;
import com.building.agency.cofigure.app.ApplicationContext;
import com.building.agency.utils.M;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        Figure2d newFigure = null;
        switch(figure)
        {
            case M.figures_2d.TRIANGLE:
            {
                System.out.println("Enter the first side of a triangle: ");
                double a = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the second side of a triangle: ");
                double b = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the third side of a triangle: ");
                double c = Double.parseDouble(scanner.nextLine());
                newFigure = new Triangle(a, b, c);
                break;
            }
            case M.figures_2d.CIRCLE:
            {
                System.out.println("Enter a radius of the circle: ");
                double radius = Double.parseDouble(scanner.nextLine());
                newFigure = new Circle(radius);
                break;
            }
            
            case M.figures_2d.RECTANGLE:
            {
                System.out.println("Enter the height of rectangle: ");
                double height = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the width of rectangle: ");
                double width = Double.parseDouble(scanner.nextLine());
                newFigure = new Rectangle(width, height);
                break;
            }
            
            case M.figures_2d.PARALLELOGRAMM:
            {
                System.out.println("Enter a width of parallelogramm: ");
                double width = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter a height of parallelogramm: ");
                double height = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter an angle of parallelogramm: ");
                double angle = Double.parseDouble(scanner.nextLine());
                newFigure = new Parallelogramm(width, height, angle);
                break;
            }
            
            case M.figures_2d.ROMB:
            {
                System.out.println("Enter a width of romb: ");
                double width = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter an angle of romb: ");
                double angle = Double.parseDouble(scanner.nextLine());
                newFigure = new Romb(width, angle);
                break;
            }
        }
        return newFigure;
    }
    
    /**
     * Generates a 3D figure
     * @param base - 2D figure, a base of 3D figure
     * @return 3D figure
     */
    public Figure3d buildFigure3D(Figure2d base)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a height of a tower: ");
        double height = Double.parseDouble(scanner.nextLine());
        System.out.println(String.format(M.dialogs.MANAGER_SPEECH4, M.person.MANAGER));

        return null;
    }
}
