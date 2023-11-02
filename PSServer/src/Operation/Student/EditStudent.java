/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Student;

import Domain.Student;
import Operation.AbstractGenericOperation;

/**
 *
 * @author SoniXx
 */
public class EditStudent extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        // TODO Preconditions, validation etc.
        if (param == null || !(param instanceof Student)) {
            throw new Exception("Invalid teacher data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Student) param);
    }
    
}
