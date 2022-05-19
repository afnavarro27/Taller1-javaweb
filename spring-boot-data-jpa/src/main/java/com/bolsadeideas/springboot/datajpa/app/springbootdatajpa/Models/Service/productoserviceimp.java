package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao.IproductoDao;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class productoserviceimp implements Iproductoservice{
    @Autowired
    private IproductoDao productoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {      
        return productoDao.findAll();
    }

    @Transactional
    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findOne(Long id) {  
        return productoDao.findOne(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        productoDao.delete(id);
    }
    
}
