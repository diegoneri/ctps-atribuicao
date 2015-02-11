/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.PeriodoLetivo;
import br.com.etec.repository.PeriodoLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class PeriodoLetivoService extends AbstractService<PeriodoLetivo> {

    @Deprecated
    public PeriodoLetivoService(){
        this(null);
    }

    @Autowired
    public PeriodoLetivoService(PeriodoLetivoRepository periodoLetivoRepository){
        super(periodoLetivoRepository);
    }

}
