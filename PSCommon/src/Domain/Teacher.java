/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Objects;

/**
 *
 * @author SoniXx
 */
public class Teacher implements GenericEntity {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String jmbg;
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
        final Teacher other = (Teacher) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public Teacher() {
        
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    public Teacher(Long id, String firstName, String lastName, String jmbg, School school) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.school = school;
    }

    public Teacher(String firstName, String lastName, String jmbg, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.school = school;
    }
    
    public Teacher(Long id,String firstName, String lastName, School school) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
    }
    
    public Teacher(Long id) {
        this.id = id;
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

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    public String getJmbg() {
        return jmbg;
    }

    public School getSchool() {
        return school;
    }
    
    @Override
    public String getTableName() {
        return "teacher";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "first_name,last_name,jmbg,school_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + this.firstName + "','" + this.lastName + "','" + this.jmbg + "'," + this.school.getId();
    }
    
    @Override
    public Teacher createInstance(Object obj[]){
        return new Teacher(Long.valueOf(obj[0].toString()),obj[1].toString(),obj[2].toString(),new School(Long.valueOf(obj[4].toString())));
    }

    @Override
    public String getParametersForUpdate() {
        return "first_name = '" + this.firstName + "', last_name = '" + this.lastName
                + "', jmbg = '" + this.jmbg + "', school_id = " + this.school.getId();
    }

    @Override
    public String getParametersForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Teacher createDetailedInstance(Object[] obj) {
        return new Teacher(Long.valueOf(obj[0].toString()),obj[1].toString(),obj[2].toString(), obj[3].toString(),new School(Long.valueOf(obj[4].toString())));
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
        if(jmbg!=null&&!this.jmbg.isEmpty()){
            if(!parameters.isEmpty())
                parameters += " AND ";
            parameters+= "grade = " + this.jmbg;
        }
        if(this.school!=null){
            if(!parameters.isEmpty())
                parameters += " AND ";
            parameters+= "school_id =" + this.school.getId();
        }
        return parameters;
    }
    
}
