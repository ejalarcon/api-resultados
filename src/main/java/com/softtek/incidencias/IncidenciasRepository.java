package com.softtek.incidencias;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidenciasRepository extends MongoRepository<Incidencias, String> {

	public List<Incidencias> findAll();
	
	

}
