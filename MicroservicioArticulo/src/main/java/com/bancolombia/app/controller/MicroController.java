package com.bancolombia.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bancolombia.app.entities.Articulo;
import com.bancolombia.app.service.IMicroService;

@RestController // Restfull  
@RequestMapping("/articulo") // http://ip:port/articulo
public class MicroController {
	//GET- select, PUT- update, POST- insert, DELETE- delete
	
	@Autowired
	private IMicroService servicio;
	
	@PostMapping
	public Articulo insert(@RequestBody Articulo a) {
		return servicio.insert(a);
	}
	
	@GetMapping
	public List<Articulo> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/{id}") //http://ip:port/articulo/{id}
	public Articulo findById(@PathVariable("id") int id) {
		try {
			
			return servicio.findById(id); 
			
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT found", e);
		}
	}
	
	@DeleteMapping("/{id}") //DELETE http://ip:port/articulo/{id}
	public boolean deleteById(@PathVariable("id") int id) {
		return servicio.deleteById(id);
	}
	
}
