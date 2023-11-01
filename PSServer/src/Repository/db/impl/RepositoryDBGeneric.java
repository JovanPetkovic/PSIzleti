/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Domain.GenericEntity;
import Repository.db.DbConnectionFactory;
import Repository.db.DbRepository;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *
 * @author Cartman
 */
public class RepositoryDBGeneric implements DbRepository<GenericEntity> {

    @Override
    public void add(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
            }
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(entity.getTableName());
            String query = sb.toString();
            Statement statement = connection.createStatement();
            //U rs ubacujemo podatke iz baze podataka
            ResultSet rs = statement.executeQuery(query);
            //Iniciramo listu koju cemo vratiti kao izlaz iz funkcije
            List<GenericEntity> returnList = new ArrayList<>();
            while(rs.next()){
                ResultSetMetaData rsmd = rs.getMetaData();
                //Uz pomoc ResultSetMetaData dobijamo koliko kolona ima jedan
                //objekat iz baze. Ovo radimo jer razliciti objekti imaju
                //razlicit broj kolona
                int length = rsmd.getColumnCount();
                Object[] obj = new Object[length];
                //Uz pomoc for petlje prolazimo kroz polja jednog objekta i
                //Upisujemo u obj po redosledu pojavljivanja
                for(int i=0;i<length;i++){
                    obj[i] = rs.getObject(i+1);
                }
                //U svakoj klasi koji implementira interfejs GenericEntity imamo
                //metod createInstance
                returnList.add(entity.createInstance(obj));
            } 
            return returnList;
        } catch (SQLException ex) {
            throw ex;
        }

    }

    @Override
    public void edit(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(entity.getTableName())
                    .append(" SET ").append(entity.getParametersForUpdate())
                    .append(" WHERE id = ").append(entity.getId());
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
            }
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ").append(entity.getParametersForDelete());
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
            }
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
