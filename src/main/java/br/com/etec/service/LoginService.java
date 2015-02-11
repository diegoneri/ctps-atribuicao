/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.Login;
import br.com.etec.login.LoginRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dfelix3
 */
@Service
@Repository
public class LoginService extends AbstractService<Login> {

    @Deprecated
    public LoginService(){
        this(null);
    }

    @Autowired
    public LoginService(LoginRepository loginRepository){
        super(loginRepository);
    }

    @Transactional(readOnly = true)
    public boolean authenticateUser(final Login login) {
        return super.count(getLoginEquals(login)) == 1;
    }

    private Specification<Login> getLoginEquals(final Login login) {
        Specification<Login> loginSpec = new Specification<Login>() {
            @Override
            public Predicate toPredicate(Root<Login> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate usuarioPredicate = cb.equal(root.get("usuario"), login.getUsuario());
                Predicate senhaPredicate = cb.equal(root.get("senha"), login.getHashSenha());
                return cb.and(usuarioPredicate, senhaPredicate);
            }
        };
        return loginSpec;
    }
}
