/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.utils;

/**
 * Application constants
 * @author vbohudskyi
 * @version 1.0
 */
public final class M {
    
    private M(){};
    
    public static final class figures_2d 
    {
          private figures_2d(){}
          public static final int NONE = 0;
          public static final int TRIANGLE = 1; 
          public static final int RECTANGLE = 2;
          public static final int CIRCLE = 3;
          public static final int ROMB = 4;
          public static final int POLYGON = 5;
          public static final int PARALLELOGRAMM = 6;
   }
    
   public static final class figure_3d
   {
       private figure_3d(){}
       
       public static final int NONE = 0;
       public static final int PYRAMID = 101;
       public static final int ANTIPRISM = 102;
       public static final int CUPOLAE = 103;
       public static final int FRUSTA = 104;
       public static final int PARALLELEPIPED = 105;
       public static final int PRISM = 106;
       public static final int SPHERE = 107;
       public static final int WEDGE = 108;
   }
    
   public static final class errors
   {
       private errors(){}
       public static final int TRIANGLE_NOT_EXIST = -1;
       public static final int PARALLELOGRAMM_NOT_EXIST = -2;
       public static final int CIRCLE_NOT_EXIST = -3;
       public static final int POLYGON_NOT_EXIST = -4;
   }
   
   public static final class dialogs
   {
       private dialogs(){}
       public static final String CONSULTANT_GREETINGS = "%s\"Hello, Sir/Madam, I am your Consultant - %s!\"";
       public static final String CUSTOMER_GREETINGS = "%s: \"Hello, I am %s. Pleased to meet you!\"";
       public static final String CONSULTANT_SPEECH1 = "%s\"May I help you?\"";
       public static final String CUSTOMER_SPEECH1 = "%s: \"Yes, please. Could you help me to build a tower in New York?";
       public static final String CONSULTANT_SPEECH2 = "%s\"Yes, we will be happy to accompany you in your project. "
               + "Which tower type would you like to build? \"";
       public static final String MANAGER_GREETING = "%s\"Hello, Sir/Madam, I am %s.\nI would be grateful to support"
               + " you in this challenge.\"";
       public static final String MANAGER_SPEECH2 = "%s\"OK, Let's decide, which base this tower will have.\"";
       public static final String MANAGER_SPEECH3 = "%s\"Done. Let's discuss available resources\n"
               + "which will be used for building a tower\"";
       public static final String MANAGER_SPEECH4 = "%s\"Well done. Starting building. Please wait...\"";
       public static final String CONSULTANT_SPEECH3 = "%s\"Sure\"";

   }
   
   public static final class person
   {
       private person(){}
       public static final String CONSULTANT = "Lynda Smith: ";
       public static final String MANAGER = "Rob Miller: ";
   }
   
   public static final class menu_items
   {
       private menu_items(){}
       
       public static final String PYRAMID = "Pyramid";
       public static final String SPHERE = "Sphere";
       public static final String PRISM = "Prism";
       public static final String FRUSTA = "Frusta";
       public static final String CUPOLAE = "Cupolae";
       public static final String WEDGE = "Wedge";
       public static final String ANTIPRISM = "Antiprism";
       public static final String QUIT = "Quit";
       public static final String BACK = "Back";
       public static final String PORTFOLIO = "Portfolio";
       /*************************************/
       
       public static final String TRIANGLE = "Triangle"; 
       public static final String RECTANGLE = "Rectangle";
       public static final String CIRCLE = "Circle";
       public static final String ROMB = "Romb";
       public static final String POLYGON = "Polygon";
       public static final String PARALLELOGRAMM = "Parallelogramm";
       /**************************************/
       
       public static final String DIAGONAL = "Diagonal";
       public static final String TRIANGULAR = "Triangular";
       public static final String SQUARE = "Square";
       /***************************************/
       
       public static final String POLYHEDRON = "Polyhedron";
       public static final String TILING = "Tiling";
       /***************************************/
       
       public static final String PARALLEL_TRIANGLE = "Parallel triangle";
       public static final String TETRAHEDRON = "Tetrahedron";
       
   }
   
   public static final class menus
   {
       private menus(){}
       
       public static final int MAIN_MENU = 200;
       public static final int PYRAMIDS_MENU = 201;
       public static final int PRISM_MENU = 202;
       public static final int SPHERE_MENU = 203;
       public static final int RESOURCE_MENU = 204;
       public static final int FRUSTA_MENU = 205;
       public static final int CUPOLAE_MENU = 206;
       public static final int ANTIPRISM_MENU = 207;
       public static final int WEDGES_MENU = 208;
   }
   
   public static final class message
   {
       private message(){}
       
       public static final int GREETING = 1;
       public static final int MANAGER_PROPOSAL = 2;
       public static final int CUSTOMER_REQUEST = 3;
       public static final int MANAGER_ANSWER = 4;
       public static final int MANAGER_SPEECH = 5;
   }
    
}
