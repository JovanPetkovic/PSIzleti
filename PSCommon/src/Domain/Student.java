/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author SoniXx
 */
public class Student implements GenericEntity{
    
    private Long id;
    private String firstName;
    private String lastName;
    private int grade;

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.grade != other.grade) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public Student() {
        
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public Student(Long id, String firstName, String lastName, int grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    @Override
    public String getTableName() {
        return "student";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "first_name,last_name,grade";
    }

    @Override
    public String getInsertValues() {
        return "'" + this.firstName + "','" + this.lastName + "'," + this.grade;
    }
    
    @Override
    public String getParametersForUpdate(){
        return "first_name = '" + this.firstName + "', last_name = '" + this.lastName
                + "', grade = " + this.grade;
    }
    
    @Override
    public Student createInstance(Object obj[]){
        return new Student(Long.valueOf(obj[0].toString()),obj[1].toString(),obj[2].toString(),Integer.parseInt(obj[3].toString()));
    } 

    @Override
    public String getParametersForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
