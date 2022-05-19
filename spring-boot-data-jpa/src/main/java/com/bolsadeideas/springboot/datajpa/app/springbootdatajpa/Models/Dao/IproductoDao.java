package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;
import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;


public interface IproductoDao {
    public List<Producto> findAll();
    public void save(Producto producto);
    public Producto findOne(Long id);
    public void delete(Long id);
    
}
