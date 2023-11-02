/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;

/**
 *
 * @author SoniXx
 */
public class TripStudent implements GenericEntity {
    Long tripID;
    Long studentID;

    public Long getTripID() {
        return tripID;
    }

    @Override
    public String toString() {
        return "TripStudent{" + "tripID=" + tripID + ", studentID=" + studentID + '}';
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setTripID(Long tripID) {
        this.tripID = tripID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public TripStudent(Long tripID, Long studentID) {
        this.tripID = tripID;
        this.studentID = studentID;
        //System.out.println("Instance of TripStudent created! studentID = " + this.studentID + " | tripID = " + this.tripID);
    }

    public TripStudent() {
    }
    
    @Override
    public String getTableName() {
        return "student_trip";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "student_id,trip_id";
    }

    @Override
    public String getInsertValues() {
        return this.studentID + "," + this.tripID;
    }

    @Override
    public void setId(Long id) {
    }
    
    
    @Override
    public TripStudent createInstance(Object obj[]){
        return new TripStudent(Long.valueOf(obj[1].toString()),Long.valueOf(obj[0].toString()));
    }

    @Override
    public String getParametersForUpdate() {
        return "";
    }

    @Override
    public Long getId() {
        return Long.MIN_VALUE;
    }

    @Override
    public String getParametersForDelete() {
        return "trip_id = " + this.tripID + " AND " + "student_id = " + this.studentID;
    }
}
