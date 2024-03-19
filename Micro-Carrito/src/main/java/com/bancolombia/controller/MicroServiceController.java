package com.bancolombia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.entities.Articulo;
import com.bancolombia.service.IMicroService;

/*Mapping the http
 * methods
 * GET, POST, PUT, DELETE
 * */
@RestController
@RequestMapping("/carrito")
public class MicroServiceController {
  
	@Autowired
	private IMicroService servicio;
	
	@PostMapping("/{id}")
	public boolean addArticulo(@PathVariable("id") int id) {
		return servicio.addArticulo(id);
	}
	
	@GetMapping
	public List<Articulo> listShoppingCart(){
		return servicio.listShoppingCart();
	}
	
	
	@GetMapping("/total")
	public double total() {
		return servicio.total();
	}
}
