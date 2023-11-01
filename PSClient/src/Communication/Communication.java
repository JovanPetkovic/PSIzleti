/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

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

    public void editTeacher(Teacher teacher) throws Exception {
        Request request=new Request(Operation.EDIT_TEACHER, teacher);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            System.out.println("Student edited successfully");
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
    
    
    public void editStudent(Student student) throws Exception {
        Request request=new Request(Operation.EDIT_STUDENT, student);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
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

    public void editTrip(Trip trip) throws Exception {
        Request request=new Request(Operation.EDIT_TRIP, trip);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }

    public void deleteTripTeacher(TripTeacher tt) throws Exception {
        Request request = new Request(Operation.DELETE_TRIPTEACHER,tt);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }

    public void deleteTripStudent(TripStudent ts) throws Exception {
        Request request = new Request(Operation.DELETE_TRIPSTUDENT,ts);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }

}
