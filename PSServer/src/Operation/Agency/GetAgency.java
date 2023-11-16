/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Agency;

import Domain.Agency;
import Operation.AbstractGenericOperation;

/**
 *
 * @author SoniXx
 */
public class GetAgency extends AbstractGenericOperation{

    private Agency agency;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        // TODO Preconditions, validation etc.
        if (param == null || !(param instanceof Agency)) {
            throw new Exception("Invalid agency data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        agency = (Agency) repository.get((Agency) param);
    }
    
    public Agency getAgency(){
        return agency;
    }
    
    
    
}