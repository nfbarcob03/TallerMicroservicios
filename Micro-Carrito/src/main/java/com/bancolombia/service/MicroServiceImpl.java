package com.bancolombia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bancolombia.entities.Articulo;
import com.bancolombia.entities.Carrito;
import com.bancolombia.feigns.IFeignClientMicroArticulo;

import feign.FeignException;


@Service
public class MicroServiceImpl implements IMicroService {
	void fakeMethod() {}

	@Autowired
	private Carrito carrito;
	@Autowired
	private IFeignClientMicroArticulo feign;

	@Override
	public boolean addArticulo(int id) {
		try {
			Articulo art = feign.findById(id);
			carrito.getArticulos().add(art);
			return true;
		}catch(FeignException ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public List<Articulo> listShoppingCart() {
		return this.carrito.getArticulos();
	}

	@Override
	public double total() {
		return this.carrito.getArticulos().stream().mapToDouble(t->t.getPrice()).sum();
	}

}
