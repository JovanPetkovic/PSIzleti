/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.GenericEntity;
import java.util.List;
import Domain.Trip;
import Domain.Student;
import Domain.Teacher;
import Domain.TripStudent;
import Domain.TripTeacher;
import Domain.User;
import Repository.Repository;
import Repository.db.DbRepository;
import Repository.db.impl.RepositoryDBGeneric;

/**
 *
 * @author Cartman
 */
public class Controller {

    private final Repository repositoryGeneric;

    private static Controller controller;

    private Controller() {
        this.repositoryGeneric = new RepositoryDBGeneric();
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public User login(String username, String password) throws Exception {
        List<User> users = repositoryGeneric.getAll(new User());
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        //return null;
        throw new Exception("Unknown user!");
    }

    public void add(GenericEntity entity) throws Exception {
        ((DbRepository) repositoryGeneric).connect();
        try {
            repositoryGeneric.add(entity);
            ((DbRepository) repositoryGeneric).commit();
        } catch (Exception e) {
            e.printStackTrace();
            ((DbRepository) repositoryGeneric).rollback();
            throw e;
        } finally {
            ((DbRepository) repositoryGeneric).disconnect();
        }
    }

    
    public List<GenericEntity> getAll(GenericEntity entity) throws Exception {
        List<GenericEntity> entities = null;
        ((DbRepository)repositoryGeneric).connect();
        try {
            entities = repositoryGeneric.getAll(entity);
            ((DbRepository)repositoryGeneric).commit();
        } catch (Exception e) {
            e.printStackTrace();
            ((DbRepository)repositoryGeneric).rollback();
            throw e;
        } finally {
            ((DbRepository)repositoryGeneric).disconnect();
        }
        return entities;
    }
    
    public void edit(GenericEntity entity) throws Exception {
        ((DbRepository) repositoryGeneric).connect();
        try {
            repositoryGeneric.edit(entity);
            ((DbRepository) repositoryGeneric).commit();
        } catch (Exception e) {
            e.printStackTrace();
            ((DbRepository) repositoryGeneric).rollback();
            throw e;
        } finally {
            ((DbRepository) repositoryGeneric).disconnect();
        }
    }
    
    public void delete(GenericEntity entity) throws Exception {
        ((DbRepository) repositoryGeneric).connect();
        try {
            repositoryGeneric.delete(entity);
            ((DbRepository) repositoryGeneric).commit();
        } catch (Exception e) {
            e.printStackTrace();
            ((DbRepository) repositoryGeneric).rollback();
            throw e;
        } finally {
            ((DbRepository) repositoryGeneric).disconnect();
        }
    }
}
