package com.softtek.resultados;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultadosRepository extends MongoRepository<Resultados, String> {

	public Resultados findByPais(String pais);
	
	public Resultados findByPaisAndEntorno (String pais, String entorno);
	
	public Resultados findByPaisAndEntornoOrderBySysdateDesc (String pais, String entorno);
	
	public Resultados findByUuaasLikeAndPaisAndEntornoOrderBySysdateDesc (String pais, String uuaa, String entorno);

	public Resultados findByUuaasLikeAndPaisAndEntornoOrderBySysdateAsc (String pais, String uuaa, String entorno);
	
	public List<Resultados> findByPaisOrderBySysdateDesc (String pais);
	
	public List<Resultados> findAllByUuaasLikeAndPaisOrderBySysdateDesc (String uuaa, String pais);
	
	public List<Resultados> findAllByUuaasLikeAndPaisOrderBySysdateAsc (String uuaa, String pais);
	
	public Resultados findByPaisAndEntornoOrderBySysdateAsc (String pais, String entorno);
	
	public Resultados findByTipoEjecucionOrderBySysdateAsc (String tipoEjecucion);
	
	public Resultados findByTipoEjecucionOrderBySysdateDesc (String tipoEjecucion);
	
	public Resultados findByTipoEjecucionAndEntornoOrderBySysdateAsc (String tipoEjecucion, String entorno);
	
	public Resultados findByTipoEjecucionAndEntornoOrderBySysdateDesc (String tipoEjecucion, String entorno);

}
