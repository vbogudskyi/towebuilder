/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.strategy.players;

import com.building.agency.utils.M;
import static com.building.agency.utils.M.person.CONSULTANT;

/**
 *
 * Declares a consulting 
 * @author vbohudskyi
 * @version 1.0
 */
public class ConsultingManager extends BusinessPlayer {
     
    public ConsultingManager() {
        super(M.person.CONSULTANT);
    }

    @Override
    public String getGreeting() {
        return String.format(M.dialogs.CONSULTANT_GREETINGS, CONSULTANT,
                CONSULTANT.substring(0, M.person.CONSULTANT.length() - 2));
    }

    @Override
    public String getSpeech(int speechId) {
        String message = null;
        switch(speechId)
        {
            case M.message.MANAGER_PROPOSAL:
            {
                message = String.format(M.dialogs.CONSULTANT_SPEECH1, player);
                break;
            }
            
            case M.message.MANAGER_ANSWER:
            {
                message = String.format(M.dialogs.CONSULTANT_SPEECH2, player);
                break;
            }
        }
        return message;
    }

    @Override
    public String getName() {
        return M.person.CONSULTANT;
    }
    
}
