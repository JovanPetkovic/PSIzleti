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
public class Teacher implements GenericEntity {
    
    private Long id;
    private String firstName;
    private String lastName;

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

    public Teacher(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String getTableName() {
        return "teacher";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "first_name,last_name";
    }

    @Override
    public String getInsertValues() {
        return "'" + this.firstName + "','" + this.lastName + "'";
    }
    
    @Override
    public Teacher createInstance(Object obj[]){
        return new Teacher(Long.valueOf(obj[0].toString()),obj[1].toString(),obj[2].toString());
    }

    @Override
    public String getParametersForUpdate() {
        return "first_name = '" + this.firstName + "', last_name = '" + this.lastName
                + "'";
    }

    @Override
    public String getParametersForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
