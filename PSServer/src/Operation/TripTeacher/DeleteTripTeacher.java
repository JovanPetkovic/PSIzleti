/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.TripTeacher;

import Domain.TripTeacher;
import Operation.AbstractGenericOperation;

/**
 *
 * @author SoniXx
 */
public class DeleteTripTeacher extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        // TODO Preconditions, validation etc.
        if (param == null || !(param instanceof TripTeacher)) {
            throw new Exception("Invalid teacher data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((TripTeacher) param);
    }
    
}
