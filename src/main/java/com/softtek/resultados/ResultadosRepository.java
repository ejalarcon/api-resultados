package com.softtek.resultados;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultadosRepository extends MongoRepository<Resultados, String> {

	public Resultados findByPais(String pais);

}
