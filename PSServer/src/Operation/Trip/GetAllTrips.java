/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation.Trip;

import Domain.Trip;
import Operation.AbstractGenericOperation;
import java.util.List;


/**
 *
 * @author Cartman
 */
public class GetAllTrips extends AbstractGenericOperation {

    private List<Trip> trips;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        trips = repository.getAll((Trip) param);
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
