package com.bancolombia.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancolombia.app.dao.IRepositoryDAO;
import com.bancolombia.app.entities.Articulo;

@Service
public class MicroServiceImpl implements IMicroService{

	@Autowired
	private IRepositoryDAO dao;
	

	@Override
	public Articulo insert(Articulo art) {
		return dao.save(art);
	}

	@Override
	public List<Articulo> findAll() {
		return (List<Articulo>)dao.findAll();
	}

	@Override
	public Articulo findById(int id) {
		
		return dao.findById(id).orElseThrow();
	}

	@Override
	public boolean deleteById(int id) {
		if(dao.existsById(id)) {dao.deleteById(id); return true;}
		return false;
	}
	

	

}
