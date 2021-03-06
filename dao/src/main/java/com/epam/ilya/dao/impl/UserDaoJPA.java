package com.epam.ilya.dao.impl;

import com.epam.ilya.dao.api.UserDaoLocal;
import com.epam.ilya.dao.exceptions.DaoException;
import com.epam.ilya.domain.entities.User;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;

/**
 * {@inheritDoc}
 *
 * @author Ilya_Bondarenko
 */
@Dependent
@Named("userDaoJPA")
public class UserDaoJPA implements UserDaoLocal, Serializable {

    private static final long serialVersionUID = 7304243809121174813L;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     **/
    @Override
    public User findByName(String name) throws DaoException {
        User user;
        Query query = entityManager.createQuery("SELECT user from User user where user.name LIKE :value");
        query.setParameter("value", name);
        user = (User) query.getSingleResult();
        if (user == null) {
            throw new DaoException("Have no such user");
        }
        return user;
    }
}
