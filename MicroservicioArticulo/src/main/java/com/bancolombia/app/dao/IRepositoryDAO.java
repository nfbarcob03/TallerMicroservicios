package com.bancolombia.app.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bancolombia.app.entities.Articulo;

public interface IRepositoryDAO extends CrudRepository<Articulo, Integer>{
	/*select, insert, update, delete*/
	
	Optional<Articulo>findByName(@Param("name") String name);

}
