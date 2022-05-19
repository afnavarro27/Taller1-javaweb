package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service;
import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao.IClienteDao;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class clienteserviceimp implements Iclienteservice {
    @Autowired
    private IClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {      
        return clienteDao.findAll();
    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
       clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {  
        return clienteDao.findOne(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        clienteDao.delete(id);
    }

   
    
}
