/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Trip;

import Domain.Trip;
import Operation.AbstractGenericOperation;

/**
 *
 * @author SoniXx
 */
public class AddTrip extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        // TODO Preconditions, validation etc.
        if (param == null || !(param instanceof Trip)) {
            throw new Exception("Invalid trip data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Trip) param);
    }
    
}
