package com.bancolombia.service;

import java.util.List;

import com.bancolombia.entities.Articulo;

/*in this interface 
 * needs declare all
 * abstract methods
 * */

public interface IMicroService {
	boolean addArticulo(int id);
	List<Articulo> listShoppingCart();
	double total();
}
