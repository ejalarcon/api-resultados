package com.softtek.resultados;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultadosRepository extends MongoRepository<Resultados, String> {

	public List<Resultados> findByPais(String pais);
	
	public List<Resultados> findByPaisAndEntorno (String pais, String entorno);
	
	public List<Resultados> findByPaisAndEntornoOrderBySysdateDesc (String pais, String entorno);
	
	public List<Resultados> findByUuaasLikeAndPaisAndEntornoOrderBySysdateDesc (String pais, String uuaa, String entorno);

	public List<Resultados> findByUuaasLikeAndPaisAndEntornoOrderBySysdateAsc (String pais, String uuaa, String entorno);
	
	public List<Resultados> findByPaisOrderBySysdateDesc (String pais);
	
	public List<Resultados> findAllByUuaasLikeAndPaisOrderBySysdateDesc (String uuaa, String pais);
	
	public List<Resultados> findAllByUuaasLikeAndPaisOrderBySysdateAsc (String uuaa, String pais);
	
	public List<Resultados> findByPaisAndEntornoOrderBySysdateAsc (String pais, String entorno);
	
	public List<Resultados> findByTipoEjecucionOrderBySysdateAsc (String tipoEjecucion);
	
	public List<Resultados> findByTipoEjecucionOrderBySysdateDesc (String tipoEjecucion);
	
	public List<Resultados> findByTipoEjecucionAndEntornoOrderBySysdateAsc (String tipoEjecucion, String entorno);
	
	public List<Resultados> findByTipoEjecucionAndEntornoOrderBySysdateDesc (String tipoEjecucion, String entorno);

	public List<Resultados> findAllByTipoEjecucionAndEntornoOrderBySysdateAsc (String tipoEjecucion, String entorno);
	
	public List<Resultados> findAllByTipoEjecucionOrderBySysdateAsc (String tipoEjecucion);

}
