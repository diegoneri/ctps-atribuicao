/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.Modulo;
import br.com.etec.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class ModuloService extends AbstractService<Modulo> {

    @Deprecated
    public ModuloService(){
        this(null);
    }

    @Autowired
    public ModuloService(ModuloRepository moduloRepository){
        super(moduloRepository);
    }

}
