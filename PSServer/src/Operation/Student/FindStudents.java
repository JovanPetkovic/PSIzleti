/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Student;

import Domain.Student;
import Operation.AbstractGenericOperation;
import java.util.List;

/**
 *
 * @author SoniXx
 */
public class FindStudents extends AbstractGenericOperation {

    private List<Student> students;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        students = repository.find((Student) param);
    }

    public List<Student> getStudents() {
        return students;
    }
}