package com.bancolombia.app.service;

import java.util.List;

import com.bancolombia.app.entities.Articulo;

public interface IMicroService {
     Articulo insert(Articulo art);
     List<Articulo>findAll();
     Articulo findById(int id);
     boolean deleteById(int id);
}
