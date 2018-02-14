package com.softtek.incidencias;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.resultados.Resultados;

public interface IncidenciasRepository extends MongoRepository<Incidencias, String> {

	public List<Incidencias> findAll();
	
	public List<Incidencias> findAllByEstado (String estado);
	
	public List<Incidencias> findAllByEstadoAndId (String estado, String id);

}
