package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Controllers;

import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service.Iproductoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    @Autowired
    private Iproductoservice productoservice;

    @GetMapping("/listar2")
    public String listar(Model model){
        
        model.addAttribute("titulo","Listado de productos");
        model.addAttribute("productos", productoservice.findAll());

        return "listar2";
    }
    @GetMapping("/form2")
    public String  crear(Map <String,Object> model)
    {
        Producto producto =new Producto();

        model.put("producto", producto);
        model.put("titulo","formulario de productos");
        return"form2";
    }

    @PostMapping("/form2")
    public String guardar(@Valid Producto producto,BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute( "titulo",  "formulario de productos");
            return "form2";
        }
        productoservice.save(producto);

        return"redirect:listar2";
    }
    @GetMapping("/form2/{id}")
    public String editar(@PathVariable Long id,Map <String,Object> model) 
    {
        Producto producto = null;
        if(id>0)
        {
            producto=productoservice.findOne(id);
        }
        else{
            return "redirect:listar2";
        }

        model.put("producto", producto);
        model.put("titulo","Editar producto");
        return"form2";
        
    }

    @GetMapping("/eliminar2/{id}")
    public String eliminar(@PathVariable Long id)
    {
        if(id>0)
            productoservice.delete(id);
        
        return "redirect:/listar2";
    }

}
