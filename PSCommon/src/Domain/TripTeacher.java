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
public class TripTeacher implements GenericEntity {
    Long tripID;
    Long teacherID;

    public TripTeacher(Long tripID, Long teacherID) {
        this.tripID = tripID;
        this.teacherID = teacherID;
        //System.out.println("Instance of TripTeacher created! teacherID = " + this.teacherID + " | tripID = " + this.tripID);
    }

    @Override
    public String toString() {
        return "TripTeacher{" + "tripID=" + tripID + ", teacherID=" + teacherID + '}';
    }

    public TripTeacher() {
    }

    public Long getTripID() {
        return tripID;
    }

    public Long getTeacherID() {
        return teacherID;
    }

    public void setTripID(Long tripID) {
        this.tripID = tripID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }
    
    @Override
    public String getTableName() {
        return "teacher_trip";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "teacher_id,trip_id";
    }

    @Override
    public String getInsertValues() {
        return this.teacherID + "," + this.tripID;
    }

    @Override
    public void setId(Long id) {
    }
    
    @Override
    public TripTeacher createInstance(Object obj[]){
        return new TripTeacher(Long.valueOf(obj[1].toString()),Long.valueOf(obj[0].toString()));
    }
    
    @Override
    public Long getId() {
        return Long.MIN_VALUE;
    }

    @Override
    public String getParametersForUpdate() {
        return "";
    }
    
    @Override
    public String getParametersForDelete() {
        return "trip_id = " + this.tripID + " AND " + "teacher_id = " + this.teacherID;
    }

    @Override
    public GenericEntity createDetailedInstance(Object[] obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParametersForSearch() {
        return "trip_id=" + this.tripID;
    }
    
}
