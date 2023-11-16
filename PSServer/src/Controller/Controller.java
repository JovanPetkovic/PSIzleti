/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.Agency;
import Domain.School;
import java.util.List;
import Domain.Trip;
import Domain.Student;
import Domain.Teacher;
import Domain.TripStudent;
import Domain.TripTeacher;
import Domain.User;
import Operation.AbstractGenericOperation;
import Operation.Agency.GetAgency;
import Operation.Agency.GetAllAgencies;
import Operation.School.GetAllSchools;
import Operation.School.GetSchool;
import Operation.Student.AddStudent;
import Operation.Student.EditStudent;
import Operation.Student.FindStudents;
import Operation.Student.GetAllStudents;
import Operation.Student.GetStudent;
import Operation.Teacher.AddTeacher;
import Operation.Teacher.EditTeacher;
import Operation.Teacher.FindTeachers;
import Operation.Teacher.GetAllTeachers;
import Operation.Teacher.GetTeacher;
import Operation.Trip.AddTrip;
import Operation.Trip.EditTrip;
import Operation.Trip.GetAllTrips;
import Operation.Trip.GetTrip;
import Operation.TripStudent.AddTripStudent;
import Operation.TripStudent.DeleteTripStudent;
import Operation.TripStudent.GetAllTripStudents;
import Operation.TripTeacher.AddTripTeacher;
import Operation.TripTeacher.DeleteTripTeacher;
import Operation.TripTeacher.GetAllTripTeachers;
import Repository.Repository;
import Repository.db.impl.RepositoryDBGeneric;

/**
 *
 * @author Cartman
 */
public class Controller {

    private final Repository repositoryGeneric;

    private static Controller controller;

    private Controller() {
        this.repositoryGeneric = new RepositoryDBGeneric();
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public User login(String username, String password) throws Exception {
        List<User> users = repositoryGeneric.getAll(new User());
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        //return null;
        throw new Exception("Unknown user!");
    }
    
    //Add Methods
    
    
    public void addStudent(Student student) throws Exception{
        AbstractGenericOperation operation = new AddStudent();
        operation.execute(student);
    }
    
    public void addTeacher(Teacher teacher) throws Exception{
        AbstractGenericOperation operation = new AddTeacher();
        operation.execute(teacher);
    }
    
    public void addTrip(Trip trip) throws Exception{
        AbstractGenericOperation operation = new AddTrip();
        operation.execute(trip);
    }
    
    public void addTripTeacher(TripTeacher tripTeacher) throws Exception{
        AbstractGenericOperation operation = new AddTripTeacher();
        operation.execute(tripTeacher);
    }
    
    public void addTripStudent(TripStudent tripStudent) throws Exception{
        AbstractGenericOperation operation = new AddTripStudent();
        operation.execute(tripStudent);
    }
    
    //GetAll Methods
    
    public List<Student> getAllStudents() throws Exception{
        AbstractGenericOperation operation = new GetAllStudents();
        operation.execute(new Student());
        return ((GetAllStudents)operation).getStudents();
    }
    
    public List<Teacher> getAllTeachers() throws Exception{
        AbstractGenericOperation operation = new GetAllTeachers();
        operation.execute(new Teacher());
        return ((GetAllTeachers)operation).getTeachers();
    }
    
    public List<Trip> getAllTrips() throws Exception{
        AbstractGenericOperation operation = new GetAllTrips();
        operation.execute(new Trip());
        return ((GetAllTrips)operation).getTrips();
    }
    
    public List<TripTeacher> getAllTripTeachers() throws Exception{
        AbstractGenericOperation operation = new GetAllTripTeachers();
        operation.execute(new TripTeacher());
        return ((GetAllTripTeachers)operation).getTripTeachers();
    }
    
    public List<TripStudent> getAllTripStudents() throws Exception{
        AbstractGenericOperation operation = new GetAllTripStudents();
        operation.execute(new TripStudent());
        return ((GetAllTripStudents)operation).getTripStudents();
    }

    //Edit Methods
    
    public void editTeacher(Teacher teacherEdit) throws Exception {
        AbstractGenericOperation operation = new EditTeacher();
        operation.execute(teacherEdit);
    }

    public void editStudent(Student studentEdit) throws Exception {
        AbstractGenericOperation operation = new EditStudent();
        operation.execute(studentEdit);
    }

    public void editTrip(Trip tripEdit) throws Exception {
        AbstractGenericOperation operation = new EditTrip();
        operation.execute(tripEdit);
    }

    //Delete Methods
    
    public void deleteTripTeacher(TripTeacher tripT) throws Exception {
        AbstractGenericOperation operation = new DeleteTripTeacher();
        operation.execute(tripT);
    }

    public void deleteTripStudent(TripStudent tripS) throws Exception {
        AbstractGenericOperation operation = new DeleteTripStudent();
        operation.execute(tripS);
    }

    public List<School> getAllSchools() throws Exception {
        AbstractGenericOperation operation = new GetAllSchools();
        operation.execute(new School());
        return ((GetAllSchools)operation).getSchools();
    }

    public List<Agency> getAllAgencies() throws Exception {
        AbstractGenericOperation operation = new GetAllAgencies();
        operation.execute(new Agency());
        return ((GetAllAgencies)operation).getAgencies();
    }

    public Teacher getTeacher(Teacher teacher) throws Exception {
        AbstractGenericOperation operation = new GetTeacher();
        operation.execute(teacher);
        return ((GetTeacher)operation).getTeacher();
    }

    public Student getStudent(Student student) throws Exception {
        AbstractGenericOperation operation = new GetStudent();
        operation.execute(student);
        return ((GetStudent)operation).getStudent();
    }

    public Trip getTrip(Trip trip) throws Exception {
        AbstractGenericOperation operation = new GetTrip();
        operation.execute(trip);
        return ((GetTrip)operation).getTrip();
    }

    public School getSchool(School school) throws Exception {
        AbstractGenericOperation operation = new GetSchool();
        operation.execute(school);
        return ((GetSchool)operation).getSchool();
    }

    public Agency getAgency(Agency agency) throws Exception {
        AbstractGenericOperation operation = new GetAgency();
        operation.execute(agency);
        return ((GetAgency)operation).getAgency();
    }
    
    public List<Student> findStudents(Student student) throws Exception{
        AbstractGenericOperation operation = new FindStudents();
        operation.execute(student);
        return ((FindStudents)operation).getStudents();
    }
    
    public List<Teacher> findTeachers(Teacher teacher) throws Exception{
        AbstractGenericOperation operation = new FindTeachers();
        operation.execute(teacher);
        return ((FindTeachers)operation).getTeachers();
    }
}
