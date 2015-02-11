/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.util.Operacao;

/**
 *
 * @author Diego Neri - #diegoneri
 */
public interface IPagination {


    Integer getActualPage();
    Integer getTotalItems();
    Operacao getOperacao();

}
