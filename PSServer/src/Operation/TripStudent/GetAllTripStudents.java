/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation.TripStudent;

import Domain.TripStudent;
import Operation.AbstractGenericOperation;
import java.util.List;

/**
 *
 * @author Cartman
 */
public class GetAllTripStudents extends AbstractGenericOperation {

    private List<TripStudent> tripStudents;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tripStudents = repository.getAll((TripStudent) param);
    }

    public List<TripStudent> getTripStudents() {
        return tripStudents;
    }
}
