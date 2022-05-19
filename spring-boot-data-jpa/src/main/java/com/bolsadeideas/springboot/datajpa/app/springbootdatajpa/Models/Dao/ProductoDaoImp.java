package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional

@Repository("PeoductoDaoJPA")
public class ProductoDaoImp implements IproductoDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {

        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Producto producto) {

        if (producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findOne(Long id) {

        return em.find(Producto.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
       
        Producto producto =findOne(id);
        em.remove(producto);
    }
}
