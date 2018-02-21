package com.softtek.incidenciasCompletas;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidenciasCompletasRepository extends MongoRepository<IncidenciasCompletas, String> {

	public List<IncidenciasCompletas> findAll();
	
//	public void deleteAll();
	
	public IncidenciasCompletas findByidIncidencia (String idIncidencia);
	
	public IncidenciasCompletas findByidPeticion (String idPeticion);
	
	public List<IncidenciasCompletas> findAllByFechaApertura (String FechaApertura);
	
	public List<IncidenciasCompletas> findAllByEstado (String estado);
	
	public List<IncidenciasCompletas> findAllByMotivoEstado (String motivoEstado);
	
	public List<IncidenciasCompletas> findAllByprioridad (String prioridad);
	
	public List<IncidenciasCompletas> findAllByGrupoAsignado (String grupoAsignado);
	
	public List<IncidenciasCompletas> findAllByResumen(String resumen);
	
	public List<IncidenciasCompletas> findAllByUsuarioAsignado(String usuarioAsignado);
	
	public List<IncidenciasCompletas> findAllByEntorno(String entorno);
	
	public List<IncidenciasCompletas> findAllByServicio(String servicio);
	
	public List<IncidenciasCompletas> findAllByFechaCompromiso(String fechaCompromiso);
	
	public List<IncidenciasCompletas> findAllByApellidos(String apellidos);
	
	public List<IncidenciasCompletas> findAllByNombre(String nombre);
	
	public List<IncidenciasCompletas> findAllByCausaRaiz(String causaRaiz);
	
	public List<IncidenciasCompletas> findAllByCanalEntrada(String canalEntrada);
	
	public List<IncidenciasCompletas> findAllByEstadoSLM(String estadoSLM);
	
	public List<IncidenciasCompletas> findAllByFechaReapertura(String fechaReapertura);
	
	
	
}
