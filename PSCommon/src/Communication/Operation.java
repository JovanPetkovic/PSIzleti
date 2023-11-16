/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public enum Operation  implements Serializable{
    LOGIN,
    GET_ALL_MANUFACTURERS,
    GET_ALL_PRODUCTS,
    ADD_PRODUCT,
    EDIT_PRODUCT,
    DELETE_PRODUCT,
    ADD_INVOICE,
    ADD_TEACHER,
    ADD_STUDENT,
    GET_ALL_TEACHERS,
    EDIT_TEACHER,
    GET_ALL_STUDENTS,
    EDIT_STUDENT,
    ADD_TRIP,
    ADD_TRIPTEACHER,
    ADD_TRIPSTUDENT,
    GET_ALL_TRIPS,
    GET_ALL_TRIPTEACHERS,
    GET_ALL_TRIPSTUDENTS,
    EDIT_TRIP,
    DELETE_TRIPTEACHER,
    DELETE_TRIPSTUDENT,
    GET_ALL_SCHOOLS,
    GET_ALL_AGENCIES,
    GET_STUDENT,
    GET_TEACHER,
    GET_TRIP,
    GET_SCHOOL,
    GET_AGENCY,
    FIND_STUDENTS,
    FIND_TEACHERS,
}
