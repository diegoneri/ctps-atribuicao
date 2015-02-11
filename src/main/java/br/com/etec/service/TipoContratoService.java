/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.TipoContrato;
import br.com.etec.repository.TipoContratoRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class TipoContratoService extends AbstractService<TipoContrato> {

    @Deprecated
    public TipoContratoService(){
        this(null);
    }

    @Autowired
    public TipoContratoService(TipoContratoRepository tipoContratoRepository){
        super(tipoContratoRepository);
    }

}
