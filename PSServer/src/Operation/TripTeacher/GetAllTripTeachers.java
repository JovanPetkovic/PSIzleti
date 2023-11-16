/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation.TripTeacher;

import Domain.TripTeacher;
import Operation.AbstractGenericOperation;
import java.util.List;


/**
 *
 * @author Cartman
 */
public class GetAllTripTeachers extends AbstractGenericOperation {

    private List<TripTeacher> tripTeachers;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tripTeachers = repository.getAll((TripTeacher) param);
    }

    public List<TripTeacher> getTripTeachers() {
        return tripTeachers;
    }
}
