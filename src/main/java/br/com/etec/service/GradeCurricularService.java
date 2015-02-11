/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.GradeCurricular;
import br.com.etec.repository.GradeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class GradeCurricularService extends AbstractService<GradeCurricular> {

    @Deprecated
    public GradeCurricularService(){
        this(null);
    }

    @Autowired
    public GradeCurricularService(GradeCurricularRepository gradeCurricularoRepository){
        super(gradeCurricularoRepository);
    }

}
