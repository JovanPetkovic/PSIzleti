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
    private School school;

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
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + ", school=" + school.toString() + '}';
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

    public void setSchool(School school) {
        this.school = school;
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

    public School getSchool() {
        return school;
    }

    public Student(Long id, String firstName, String lastName, int grade, School school) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.school = school;
    }

    public Student(String firstName, String lastName, int grade, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.school = school;
    }
    
    public Student(Long id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Student(Long id) {
        this.id = id;
    }

    @Override
    public String getTableName() {
        return "student";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "first_name,last_name,grade,school_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + this.firstName + "','" + this.lastName + "'," + this.grade + ", " + this.getSchool().getId();
    }
    
    @Override
    public String getParametersForUpdate(){
        return "first_name = '" + this.firstName + "', last_name = '" + this.lastName
                + "', grade = " + this.grade + ", school_id=" + this.getSchool().getId();
    }
    
    @Override
    public Student createInstance(Object obj[]){
        return new Student(Long.valueOf(obj[0].toString()),obj[1].toString(),obj[2].toString());
    } 

    @Override
    public String getParametersForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student createDetailedInstance(Object[] obj) {
        return new Student(Long.valueOf(obj[0].toString()),obj[1].toString(),obj[2].toString(),(int) obj[4],new School(Long.valueOf(obj[3].toString())));
    }

    @Override
    public String getParametersForSearch() {
        String parameters = "";
        if(id!=0){
            parameters+= "id =" + id;
        }
        if(firstName!=null&&!firstName.isEmpty()){
            if(!parameters.isEmpty())
                parameters += " AND ";
            parameters+= "first_name LIKE '" + this.firstName + "%'";
        }
        if(lastName!=null&&!lastName.isEmpty()){
            if(!parameters.isEmpty())
                parameters += " AND ";
            parameters+= "last_name LIKE '" + this.lastName + "%'";
        }
        if(this.grade!=0){
            if(!parameters.isEmpty())
                parameters += " AND ";
            parameters+= "grade = " + this.grade;
        }
        if(this.school!=null){
            if(!parameters.isEmpty())
                parameters += " AND ";
            parameters+= "school_id =" + this.school.getId();
        }
        return parameters;
    }
    
}
