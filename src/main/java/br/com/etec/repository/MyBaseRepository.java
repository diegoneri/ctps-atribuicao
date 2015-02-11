/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author Diego Neri - #diegoneri
 */
public interface MyBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

}
