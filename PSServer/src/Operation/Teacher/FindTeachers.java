/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operation.Teacher;

import Domain.Teacher;
import Operation.AbstractGenericOperation;
import java.util.List;

/**
 *
 * @author SoniXx
 */
public class FindTeachers extends AbstractGenericOperation {

    private List<Teacher> teachers;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        teachers = repository.find((Teacher) param);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
    
}
