/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Trip;

import Domain.Agency;
import Domain.Student;
import Domain.Teacher;
import Domain.Trip;
import Domain.TripStudent;
import Domain.TripTeacher;
import Operation.AbstractGenericOperation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SoniXx
 */
public class GetTrip extends AbstractGenericOperation{

    private Trip trip;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        // TODO Preconditions, validation etc.
        if (param == null || !(param instanceof Trip)) {
            throw new Exception("Invalid trip data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        trip = (Trip) repository.get((Trip) param);
        trip.setAgency((Agency) repository.get(new Agency(trip.getAgency().getId())));
        
        List<TripTeacher> ttList = (List<TripTeacher>) repository.find(new TripTeacher(trip.getId(), 0L));
        List<TripStudent> tsList = (List<TripStudent>) repository.find(new TripStudent(trip.getId(), 0L));
    
        List<Student> studentList = new ArrayList<>();
        
        for(TripStudent ts:tsList){
            studentList.add(((List<Student>) repository.find(new Student(ts.getStudentID()))).get(0));
        }
        trip.setStudentList(studentList);
        
        List<Teacher> teacherList = new ArrayList<>();
        
        for(TripTeacher tt:ttList){
            teacherList.add(((List<Teacher>) repository.find(new Teacher(tt.getTeacherID()))).get(0));
        }
        trip.setTeacherList(teacherList);
    
    
    }
    
    public Trip getTrip(){
        return trip;
    }
    
    
    
}
