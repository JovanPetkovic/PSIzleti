/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();
    
    String getParametersForUpdate();
    
    String getParametersForDelete();
    
    String getParametersForSearch();
    
    Long getId();

    String getInsertValues();
    
    GenericEntity createInstance(Object obj[]);
    
    GenericEntity createDetailedInstance(Object obj[]);

    void setId(Long id);

}
