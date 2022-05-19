package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service;

import java.util.List;


import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Cliente;


public interface Iclienteservice {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
