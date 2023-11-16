/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Communication.Operation.ADD_TEACHER;
import Communication.Receiver;
import Communication.Request;
import Communication.Response;
import Communication.Sender;
import Controller.Controller;
import Domain.Agency;
import Domain.School;
import Domain.Student;
import Domain.Teacher;
import Domain.Trip;
import Domain.TripStudent;
import Domain.TripTeacher;
import Domain.User;
import java.util.List;

/**
 *
 * @author Cartman
 */
public class ProcessClientsRequests extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;

    public ProcessClientsRequests(Socket socket) {
        this.socket = socket;        
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        

        while (true) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            User user = (User) request.getArgument();
                            response.setResult(Controller.getInstance().login(user.getUsername(), user.getPassword()));
                            break;
                        case ADD_TEACHER:
                            Teacher teacherInsert = (Teacher) request.getArgument();
                            Controller.getInstance().addTeacher(teacherInsert);
                            response.setResult(teacherInsert);
                            break;
                        case ADD_STUDENT:
                            Student studentInsert = (Student) request.getArgument();
                            Controller.getInstance().addStudent(studentInsert);
                            response.setResult(studentInsert);
                            break;
                        case ADD_TRIP:
                            Trip tripInsert = (Trip) request.getArgument();
                            Controller.getInstance().addTrip(tripInsert);
                            response.setResult(tripInsert);
                            break;
                        case ADD_TRIPTEACHER:
                            TripTeacher tt = (TripTeacher) request.getArgument();
                            Controller.getInstance().addTripTeacher(tt);
                            response.setResult(tt);
                            break;
                        case ADD_TRIPSTUDENT:
                            TripStudent ts = (TripStudent) request.getArgument();
                            Controller.getInstance().addTripStudent(ts);
                            response.setResult(ts);
                            break;
                        case GET_ALL_TEACHERS:
                            response.setResult(Controller.getInstance().getAllTeachers());
                            break;
                        case GET_ALL_STUDENTS:
                            response.setResult(Controller.getInstance().getAllStudents());
                            break;
                        case GET_ALL_TRIPTEACHERS:
                            response.setResult(Controller.getInstance().getAllTripTeachers());
                            break;
                        case GET_ALL_TRIPSTUDENTS:
                            response.setResult(Controller.getInstance().getAllTripStudents());
                            break;   
                        case GET_ALL_SCHOOLS:
                            response.setResult(Controller.getInstance().getAllSchools());
                            break;
                        case GET_ALL_TRIPS:
                            response.setResult(Controller.getInstance().getAllTrips());
                            break;   
                        case GET_ALL_AGENCIES:
                            response.setResult(Controller.getInstance().getAllAgencies());
                            break;
                        case EDIT_TEACHER:
                            Teacher teacherEdit = (Teacher) request.getArgument();
                            Controller.getInstance().editTeacher(teacherEdit);
                            response.setResult(teacherEdit);
                            break;
                        case EDIT_STUDENT:
                            Student studentEdit = (Student) request.getArgument();
                            Controller.getInstance().editStudent(studentEdit);
                            response.setResult(studentEdit);
                            break;
                        case EDIT_TRIP:
                            Trip tripEdit = (Trip) request.getArgument();
                            Controller.getInstance().editTrip(tripEdit);
                            response.setResult(tripEdit);
                            break;
                        case DELETE_TRIPTEACHER:
                            TripTeacher tripT = (TripTeacher) request.getArgument();
                            Controller.getInstance().deleteTripTeacher(tripT);
                            response.setResult(tripT);
                            break;
                        case DELETE_TRIPSTUDENT:
                            TripStudent tripS = (TripStudent) request.getArgument();
                            Controller.getInstance().deleteTripStudent(tripS);
                            response.setResult(tripS);
                            break;
                        case GET_TEACHER:
                            Teacher teacher = (Teacher) request.getArgument();
                            teacher = Controller.getInstance().getTeacher(teacher);
                            response.setResult(teacher);
                            break;
                        case GET_STUDENT:
                            Student student = (Student) request.getArgument();
                            student = Controller.getInstance().getStudent(student);
                            response.setResult(student);
                            break;
                        case GET_TRIP:
                            Trip trip = (Trip) request.getArgument();
                            trip = Controller.getInstance().getTrip(trip);
                            response.setResult(trip);
                            break;
                        case GET_SCHOOL:
                            School school = (School) request.getArgument();
                            school = Controller.getInstance().getSchool(school);
                            response.setResult(school);
                            break;
                        case GET_AGENCY:
                            Agency agency = (Agency) request.getArgument();
                            agency = Controller.getInstance().getAgency(agency);
                            response.setResult(agency);
                            break;
                        case FIND_TEACHERS:
                            Teacher teacherFind = (Teacher) request.getArgument();
                            List<Teacher> teacherList = Controller.getInstance().findTeachers(teacherFind);
                            response.setResult(teacherList);
                            break;
                        case FIND_STUDENTS:
                            Student studentFind = (Student) request.getArgument();
                            List<Student> studentList = Controller.getInstance().findStudents(studentFind);
                            response.setResult(studentList);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
            } catch (Exception ex) {
                Logger.getLogger(ProcessClientsRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
