package com.softtek.incidenciasCompletas;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidenciasCompletasRepository extends MongoRepository<IncidenciaCompleta, String> {

	public List<IncidenciaCompleta> findAll();
	
//	public void deleteAll();
	
	public IncidenciaCompleta findByidIncidencia (String idIncidencia);
	
	public IncidenciaCompleta findByidPeticion (String idPeticion);
	
	public List<IncidenciaCompleta> findAllByFechaApertura (String FechaApertura);
	
	public List<IncidenciaCompleta> findAllByEstado (String estado);
	
	public List<IncidenciaCompleta> findAllByMotivoEstado (String motivoEstado);
	
	public List<IncidenciaCompleta> findAllByprioridad (String prioridad);
	
	public List<IncidenciaCompleta> findAllByGrupoAsignado (String grupoAsignado);
	
	public List<IncidenciaCompleta> findAllByResumen(String resumen);
	
	public List<IncidenciaCompleta> findAllByUsuarioAsignado(String usuarioAsignado);
	
	public List<IncidenciaCompleta> findAllByEntorno(String entorno);
	
	public List<IncidenciaCompleta> findAllByServicio(String servicio);
	
	public List<IncidenciaCompleta> findAllByFechaCompromiso(String fechaCompromiso);
	
	public List<IncidenciaCompleta> findAllByApellidos(String apellidos);
	
	public List<IncidenciaCompleta> findAllByNombre(String nombre);
	
	public List<IncidenciaCompleta> findAllByCausaRaiz(String causaRaiz);
	
	public List<IncidenciaCompleta> findAllByCanalEntrada(String canalEntrada);
	
	public List<IncidenciaCompleta> findAllByEstadoSLM(String estadoSLM);
	
	public List<IncidenciaCompleta> findAllByFechaReapertura(String fechaReapertura);
	
	
	
}
