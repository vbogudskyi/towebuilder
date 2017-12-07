/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy;

import com.building.agency.base.Figure2d;
import com.building.agency.base.figure3d.Cupolae;
import com.building.agency.base.figure3d.cupolae.DiagonalCupolae;
import com.building.agency.base.figure3d.cupolae.TriangularCupolae;
import com.building.agency.utils.M;

/**
 * Declares a creator of cupolaes
 * @author vbohudskyi
 * @version 1.0
 */
public class CupolaeStrategy {
        
    /**
     * Method creates different types of cupolaes
     * @param cupolae_type - a type of cupolae
     * @param base - base of cupolae
     * @param height - height of cupolae
     * @return cupolae
     * @version 1.0
     */
    public Cupolae buildCupolae(int cupolae_type, Figure2d base, double height)
    {
        Cupolae cupolae = null; // current cupolae is stored here
        switch(cupolae_type)
        {
            case M.figure_3d.DIAGONAL_CUPOLAE: // if diagonal cupolae is chosen
            {
                cupolae = new DiagonalCupolae(base, height); // cupolae is created
                cupolae.apply(); // data is applied
                break;
            }
        }
        
        return cupolae; 
    }
    
    /**
     * Method creates different types of cupolaes
     * @param cupolae_type - a type of cupolae
     * @param base - base of cupolae
     * @param upper - upper base of cupolae
     * @param height - height of cupolae
     * @return cupolae
     * @version 1.0
     */
    public Cupolae buildCupolae(int cupolae_type, Figure2d base, Figure2d upper, double height)
    {
        Cupolae cupolae = null; // current cupolae is stored here
        switch(cupolae_type)
        {
            case M.figure_3d.TRANGULAR_CUPOLAE: // if triangular cupolae is stored
            {
                cupolae = new TriangularCupolae(base, upper, height); // cupolae is created
                cupolae.apply(); // data is applied
                break;
            }
        }
        
        return cupolae;

    }
    
}
