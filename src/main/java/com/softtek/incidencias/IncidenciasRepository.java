package com.softtek.incidencias;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidenciasRepository extends MongoRepository<Incidencias, String> {

	public List<Incidencias> findAll();
	
	public List<Incidencias> findAllByEstado (String estado);
	
//	public List<Incidencias> findAllByEstadoAndId (String estado, String _id);
	
	public List<Incidencias> findAllByGrupoAndEstado (String grupo, String estado);
	

}
