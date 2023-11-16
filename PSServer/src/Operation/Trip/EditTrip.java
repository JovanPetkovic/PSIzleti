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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SoniXx
 */
public class EditTrip extends AbstractGenericOperation {

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
        repository.edit(trip);
        
        List<TripTeacher> ttList = (List<TripTeacher>) repository.find(new TripTeacher(trip.getId(), 0L));
        List<TripStudent> tsList = (List<TripStudent>) repository.find(new TripStudent(trip.getId(), 0L));
        
        List<Student> studentList = new ArrayList<>();
        
        for(TripStudent ts:tsList){
            studentList.add(((List<Student>) repository.find(new Student(ts.getStudentID()))).get(0));
        }
        
        List<Teacher> teacherList = new ArrayList<>();
        
        for(TripTeacher tt:ttList){
            teacherList.add(((List<Teacher>) repository.find(new Teacher(tt.getTeacherID()))).get(0));
        }
        
        for(Teacher teacher:trip.getTripTeachers()){
            if(!teacherList.contains(teacher)){
                repository.add(new TripTeacher(trip.getId(),teacher.getId()));
                teacherList.remove(teacher);
            }else{
                teacherList.remove(teacher);
            }
        }
        
        for(Student student:trip.getTripStudents()){
            if(!studentList.contains(student)){
                repository.add(new TripStudent(trip.getId(),student.getId()));             
            }else{
                studentList.remove(student);
            }
        }
        
        for(Teacher teacher: teacherList){
            repository.delete(new TripTeacher(trip.getId(),teacher.getId()));
        }
        
        for(Student student: studentList){
            repository.delete(new TripStudent(trip.getId(),student.getId()));
        }
    }
       
}
