package com.softtek.resultados;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultadosRepository extends MongoRepository<Resultados, String> {

	public Resultados findByPais(String pais);
	
	public Resultados findByPaisAndEntorno (String pais, String entorno);
	
	public Resultados findByPaisAndEntornoOrderByFechaDesc (String pais, String entorno);
	
	public Resultados findByPaisAndEntornoOrderByFechaAsc (String pais, String entorno);

}
