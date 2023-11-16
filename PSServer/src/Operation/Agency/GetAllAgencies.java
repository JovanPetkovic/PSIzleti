/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Agency;

import Domain.Agency;
import Operation.AbstractGenericOperation;
import java.util.List;

/**
 *
 * @author SoniXx
 */
public class GetAllAgencies extends AbstractGenericOperation {

    private List<Agency> agencies;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        agencies = repository.getAll((Agency) param);
    }
    
    public List<Agency> getAgencies(){
        return agencies;
    }
    
}