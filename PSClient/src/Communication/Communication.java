/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import Domain.Agency;
import Domain.School;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import Domain.Trip;
import Domain.Student;
import Domain.Teacher;
import Domain.TripStudent;
import Domain.TripTeacher;
import Domain.User;

/**
 *
 * @author Cartman
 */
public class Communication {
    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;
    private Communication() throws Exception{
        socket=new Socket("127.0.0.1", 9000);
        sender=new Sender(socket);
        receiver=new Receiver(socket);
    }
    public static Communication getInstance() throws Exception{
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }
    
    public User login(String username, String password) throws Exception {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        Request request=new Request(Operation.LOGIN, user);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (User)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public void addTeacher(Teacher teacher) throws Exception {
        Request request=new Request(Operation.ADD_TEACHER, teacher);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("Teacher successfully added");
        }else{
            System.out.println("Error! Couldn't add Teacher: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public void addStudent(Student student) throws Exception {
        Request request=new Request(Operation.ADD_STUDENT, student);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("Student successfully added");
        }else{
            System.out.println("Error! Couldn't add Student: " + response.getResult().toString());
            throw response.getException();
        }
    }
    
    public void addTrip(Trip trip) throws Exception {
        Request request = new Request(Operation.ADD_TRIP,trip);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("Trip successfully added");
        }else{
            System.out.println("Error! Couldn't add Trip: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public void addTripTeacher(TripTeacher tt) throws Exception {
        Request request = new Request(Operation.ADD_TRIPTEACHER,tt);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("TripTeacher successfully added");
        }else{
            System.out.println("Error! Couldn't add TripTeacher: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public void addTripStudent(TripStudent ts) throws Exception {
        Request request = new Request(Operation.ADD_TRIPSTUDENT,ts);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("TripStudent successfully added");
        }else{
            System.out.println("Error! Couldn't add TripStudent: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public List<Teacher> getAllTeachers() throws Exception {
        Request request=new Request(Operation.GET_ALL_TEACHERS, null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Teacher>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<Student> getAllStudents() throws Exception {
        Request request=new Request(Operation.GET_ALL_STUDENTS, null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Student>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public List<Trip> getAllTrips() throws Exception {
        Request request=new Request(Operation.GET_ALL_TRIPS, null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Trip>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public List<TripTeacher> getAllTripTeacher() throws Exception {
        Request request=new Request(Operation.GET_ALL_TRIPTEACHERS, null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<TripTeacher>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public List<TripStudent> getAllTripStudent() throws Exception {
        Request request=new Request(Operation.GET_ALL_TRIPSTUDENTS, null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<TripStudent>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public void editTeacher(Teacher teacher) throws Exception {
        Request request=new Request(Operation.EDIT_TEACHER, teacher);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("Teacher edited successfully");
        }else{
            System.out.println("Error! Couldn't edit Teacher: " + response.getResult().toString());
            throw response.getException();
        }
    }
    
    public void editStudent(Student student) throws Exception {
        Request request=new Request(Operation.EDIT_STUDENT, student);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("Student edited successfully.");
        }else{
            System.out.println("Error! Couldn't edit Student: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public void editTrip(Trip trip) throws Exception {
        Request request=new Request(Operation.EDIT_TRIP, trip);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("Trip edited successfully.");
        }else{
            System.out.println("Error! Couldn't edit Trip: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public void deleteTripTeacher(TripTeacher tt) throws Exception {
        Request request = new Request(Operation.DELETE_TRIPTEACHER,tt);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            System.out.println("TripStudent removed successfully.");
        }else{
            System.out.println("Error! Couldn't remove TripTeacher: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public void deleteTripStudent(TripStudent ts) throws Exception {
        Request request = new Request(Operation.DELETE_TRIPSTUDENT,ts);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            System.out.println("TripTeacher removed successfully.");
        }else{
            System.out.println("Error! Couldn't remove TripStudent: " + response.getResult().toString());
            throw response.getException();
        }
    }

    public List<School> getAllSchools() throws Exception {
        Request request=new Request(Operation.GET_ALL_SCHOOLS, null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<School>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public List<Agency> getAllAgencies() throws Exception {
        Request request=new Request(Operation.GET_ALL_AGENCIES, null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Agency>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    

    public Student getStudent(Student student) throws Exception {
        Request request=new Request(Operation.GET_STUDENT, student);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Student)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public Trip getTrip(Trip trip) throws Exception {
        Request request=new Request(Operation.GET_TRIP, trip);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Trip)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public Teacher getTeacher(Teacher teacher) throws Exception {
        Request request=new Request(Operation.GET_TEACHER, teacher);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Teacher)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public School getSchool(School school) throws Exception {
        Request request=new Request(Operation.GET_SCHOOL, school);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (School)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public Agency getAgency(Agency agency) throws Exception {
        Request request=new Request(Operation.GET_AGENCY, agency);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Agency)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    
    public List<Teacher> findTeachers(Teacher teacher) throws Exception {
        Request request=new Request(Operation.FIND_TEACHERS, teacher);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Teacher>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<Student> findStudents(Student student) throws Exception {
        Request request=new Request(Operation.FIND_STUDENTS, student);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Student>)response.getResult();
        }else{
            throw response.getException();
        }
    }

}
