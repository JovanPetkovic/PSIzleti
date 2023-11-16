/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.School;

import Domain.School;
import Operation.AbstractGenericOperation;
import java.util.List;

/**
 *
 * @author SoniXx
 */
public class GetAllSchools extends AbstractGenericOperation {

    private List<School> schools;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        schools = repository.getAll((School) param);
    }
    
    public List<School> getSchools(){
        return schools;
    }
    
}
