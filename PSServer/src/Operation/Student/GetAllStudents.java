/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation.Student;

import Domain.Student;
import Operation.AbstractGenericOperation;
import java.util.List;


/**
 *
 * @author Cartman
 */
public class GetAllStudents extends AbstractGenericOperation {

    private List<Student> students;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        students = repository.getAll((Student) param);
    }

    public List<Student> getStudents() {
        return students;
    }
}
