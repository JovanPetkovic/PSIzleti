/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Trip implements GenericEntity{
    
    private Long id;
    private String destination;
    private Date startDate;
    private Date endDate;
    private Long price;
    private Agency agency;
    private List<Teacher> teacherList;
    private List<Student> studentList;

    @Override
    public String toString() {
        return "Trip{" + "id=" + id + ", destination=" + destination + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + '}';
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getDestination() {
        return destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    public String getStartDateString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getEndDateString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(endDate);
    }
    
    public Long getPrice() {
        return price;
    }

    public Agency getAgency() {
        return agency;
    }


    public Trip() {
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    public Trip(Long id, String name) {
        this.id = id;
        this.destination = name;
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
    }
    
     public Trip(Long id, String destination, Date startDate, Date endDate) {
        this.id = id;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
    }
    
    public Trip(Long id, String name, Date startDate, Date endDate, Long price, Agency agency) {
        this.id = id;
        this.destination = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.agency = agency;
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
    }
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return destination;
    }

    public void setName(String name) {
        this.destination = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.destination);
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
        final Trip other = (Trip) obj;
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String getTableName() {
        return "trip";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,destination,start_date,end_date,price,agency_id";
    }

    @Override
    public String getInsertValues() {
        long miliseconds;
        miliseconds = this.getStartDate().getTime();
        java.sql.Date sDate = new java.sql.Date(miliseconds);
        miliseconds = this.getEndDate().getTime();
        java.sql.Date eDate = new java.sql.Date(miliseconds);
        String insertValues = this.id + ",'" + this.destination + "','" + sDate + "','" +
        eDate + "'," + this.price + "," + this.agency.getId();
        return insertValues;
    }
    
    @Override
    public Trip createInstance(Object obj[]){
        Long id = Long.valueOf(obj[0].toString());
        String destination = obj[1].toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        Date endDate;
        try {
            startDate = dateFormat.parse(obj[2].toString());
            endDate = dateFormat.parse(obj[3].toString());
            return new Trip(id,destination,startDate,endDate);
        } catch (ParseException ex) {
            Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getParametersForUpdate() {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = dateFormat.format(this.startDate);
        String endDate = dateFormat.format(this.endDate);
        String sql = "destination = '" + this.destination + "', start_date = '" + startDate + 
                "', end_date = '" + endDate + "', price = " + this.price + ", agency_id = " + this.agency.getId();
        
        return sql;
    }

    @Override
    public String getParametersForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void clearTeacherList(){
        teacherList = new ArrayList<>();
    }
    
    public void clearStudentList(){
        studentList = new ArrayList<>();
    }
    
    public List<Teacher> getTripTeachers(){
        return teacherList;
    }
    
    public List<Student> getTripStudents(){
        return studentList;
    }

    @Override
    public GenericEntity createDetailedInstance(Object[] obj) {
        Long id = Long.valueOf(obj[0].toString());
        String destination = obj[1].toString();
        Long price = Long.valueOf(obj[4].toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Agency agency = new Agency(Long.valueOf(obj[5].toString()));
        Date startDate;
        Date endDate;
        try {
            startDate = dateFormat.parse(obj[2].toString());
            endDate = dateFormat.parse(obj[3].toString());
            return new Trip(id,destination,startDate,endDate,price, agency);
        } catch (ParseException ex) {
            Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getParametersForSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
