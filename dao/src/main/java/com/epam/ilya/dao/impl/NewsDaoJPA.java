package com.epam.ilya.dao.impl;

import com.epam.ilya.dao.api.NewsDaoLocal;
import com.epam.ilya.dao.exceptions.DaoException;
import com.epam.ilya.domain.entities.News;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Dependent
public class NewsDaoJPA implements NewsDaoLocal {

    private static final long serialVersionUID = -6786071613749345605L;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public News create(News entity) throws DaoException {
        try {
            manager.persist(entity);
        } catch (PersistenceException e) {
            throw new DaoException("Not enough information for persist news", e);
        }
        manager.flush();
        return entity;
    }

    @Override
    public News findById(Long id) throws DaoException {
        News news = manager.find(News.class, id);
        if (news == null) {
            throw new DaoException("Cannot find news by id" + id);
        }
        return news;
    }

    @Override
    public News update(News entity) {
        return manager.merge(entity);
    }

    @Override
    public void delete(News entity) {
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
    }

    @Override
    public List<News> findAll() {
        return manager.createQuery("FROM News", News.class).getResultList();
    }

    @Override
    public List<News> getPaginatedList(int pageNumber, int pageSize) {
        Query query = manager.createQuery("From News", News.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public long newsCount() {
        Query queryTotal = manager.createQuery("Select count(news.id) from News news");
        return (long) queryTotal.getSingleResult();
    }
}
