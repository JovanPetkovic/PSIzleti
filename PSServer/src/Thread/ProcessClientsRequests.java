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
import Domain.Student;
import Domain.Teacher;
import Domain.Trip;
import Domain.TripStudent;
import Domain.TripTeacher;
import Domain.User;

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
                            Controller.getInstance().add(teacherInsert);
                            response.setResult(teacherInsert);
                            break;
                        case ADD_STUDENT:
                            Student studentInsert = (Student) request.getArgument();
                            Controller.getInstance().add(studentInsert);
                            response.setResult(studentInsert);
                            break;
                        case ADD_TRIP:
                            Trip tripInsert = (Trip) request.getArgument();
                            Controller.getInstance().add(tripInsert);
                            break;
                        case ADD_TRIPTEACHER:
                            TripTeacher tt = (TripTeacher) request.getArgument();
                            Controller.getInstance().add(tt);
                            break;
                        case ADD_TRIPSTUDENT:
                            TripStudent ts = (TripStudent) request.getArgument();
                            Controller.getInstance().add(ts);
                            break;
                        case GET_ALL_TEACHERS:
                            response.setResult(Controller.getInstance().getAll(new Teacher()));
                            break;
                        case GET_ALL_STUDENTS:
                            response.setResult(Controller.getInstance().getAll(new Student()));
                            break;
                        case GET_ALL_TRIPTEACHERS:
                            response.setResult(Controller.getInstance().getAll(new TripTeacher()));
                            break;
                        case GET_ALL_TRIPSTUDENTS:
                            response.setResult(Controller.getInstance().getAll(new TripStudent()));
                            break;    
                        case GET_ALL_TRIPS:
                            response.setResult(Controller.getInstance().getAll(new Trip()));
                            break;
                        case EDIT_TEACHER:
                            Teacher teacherEdit = (Teacher) request.getArgument();
                            Controller.getInstance().edit(teacherEdit);
                            break;
                        case EDIT_STUDENT:
                            Student studentEdit = (Student) request.getArgument();
                            Controller.getInstance().edit(studentEdit);
                            break;
                        case EDIT_TRIP:
                            Trip tripEdit = (Trip) request.getArgument();
                            Controller.getInstance().edit(tripEdit);
                            break;
                        case DELETE_TRIPTEACHER:
                            TripTeacher tripT = (TripTeacher) request.getArgument();
                            Controller.getInstance().delete(tripT);
                            break;
                        case DELETE_TRIPSTUDENT:
                            TripStudent tripS = (TripStudent) request.getArgument();
                            Controller.getInstance().delete(tripS);
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
