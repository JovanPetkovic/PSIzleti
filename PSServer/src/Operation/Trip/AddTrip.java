/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Trip;


import Domain.Student;
import Domain.Teacher;
import Domain.Trip;
import Domain.TripStudent;
import Domain.TripTeacher;
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
        Trip trip = (Trip) param;
        repository.add(trip);
        for(Teacher t: trip.getTripTeachers())
            repository.add(new TripTeacher(trip.getId(),t.getId()));
        for(Student s: trip.getTripStudents())
            repository.add(new TripStudent(trip.getId(),s.getId()));
    }
    
}
