/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author SoniXx
 */
public class School implements GenericEntity{

    private final String tableName = "school";
    
    private Long id;
    private String name;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return "School{" + "tableName=" + tableName + ", id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public School(Long id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public School(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public School(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public School() {
    }

    public School(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParametersForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParametersForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity createInstance(Object[] obj) {
        return new School(Long.valueOf(obj[0].toString()),obj[1].toString());
    }

    @Override
    public GenericEntity createDetailedInstance(Object[] obj) {
        return new School(Long.valueOf(obj[0].toString()),obj[1].toString(),obj[2].toString(),obj[3].toString());
    }

    @Override
    public String getParametersForSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
