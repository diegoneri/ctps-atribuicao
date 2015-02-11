/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.DefaultModel;
import br.com.etec.repository.MyBaseRepository;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author Diego Neri - #diegoneri
 */
public abstract class AbstractService<T extends DefaultModel> {

    private MyBaseRepository<T,? extends Serializable> repository;
    private Integer MAX_RESULTS_PER_PAGE = 10;
    private Integer lastPage;

    public AbstractService(MyBaseRepository repository){
        this.repository = repository;
    }

    /**
     * Returns a new object which specifies the the wanted result page.
     * @param pageIndex The index of the wanted result page
     * @return
     */
    private Pageable constructPageSpecification(Integer pageIndex){
        return new PageRequest(pageIndex , MAX_RESULTS_PER_PAGE);
    }

    public final void setMaxResults(Integer value){
        if (value > 10) {
            MAX_RESULTS_PER_PAGE = value;
            Logger.getLogger(this.getClass()).info("Novo tamanho de página para " + this.getClass().getName() + ": " + value);
        }else{
            Logger.getLogger(this.getClass()).warn("Não foi possível alterar o tamanho de página em " + value + "  para " + this.getClass().getName());
        }
    }

    public Integer getMaxResults(){
        return MAX_RESULTS_PER_PAGE;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public final List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public T saveAndFlush(T t) {
        return repository.saveAndFlush(t);
    }

    public T save(T t) {
        return repository.save(t);
    }

    public void delete(T t) {
        repository.delete(t);
    }

    public T findOne(Specification<T> s) {
        return repository.findOne(s);
    }

    public List<T> findAll(Integer page){
        return findPage(page-1).getContent();
    }

    private Page<T> findPage(Integer page) {
        Page p = repository.findAll(constructPageSpecification(page));
        this.setLastPage(p.getTotalPages());
        return p;
    }

    private Page<T> findPage(Specification<T> s , Integer page) {
        Pageable pgbl = this.constructPageSpecification(page);
        Page p = repository.findAll(s,pgbl);
        this.setLastPage(p.getTotalPages());
        return p;
    }

    private List<T> findPage(Specification<T> s) {
        return repository.findAll(s);
    }

    private List<T> findAll(Specification<T> s , Sort sort) {
        return repository.findAll(s , sort);
    }

    public Long count(Specification<T> s) {
        return repository.count(s);
    }

    public Long count() {
        return repository.count();
    }

    public Integer getLastPage() {
        return lastPage;
    }

    private void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

}
