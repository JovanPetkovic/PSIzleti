/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.School;

import Domain.School;
import Operation.AbstractGenericOperation;

/**
 *
 * @author SoniXx
 */
public class GetSchool extends AbstractGenericOperation{

    private School school;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        // TODO Preconditions, validation etc.
        if (param == null || !(param instanceof School)) {
            throw new Exception("Invalid school data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        school = (School) repository.get((School) param);
    }
    
    public School getSchool(){
        return school;
    }
    
    
    
}
