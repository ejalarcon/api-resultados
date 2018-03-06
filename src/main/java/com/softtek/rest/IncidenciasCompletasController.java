package com.softtek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.incidenciasCompletas.IncidenciasCompletas;
import com.softtek.incidenciasCompletas.IncidenciasCompletasRepository;
import com.softtek.resultados.Resultados;

@RestController
@RequestMapping(value = "/api/incidenciasCompletas")
public class IncidenciasCompletasController {
	
	@Autowired
	IncidenciasCompletasRepository incidenciasCompletasRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<IncidenciasCompletas> getIncidencias(){
		return incidenciasCompletasRepository.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addIncidencia(@RequestBody IncidenciasCompletas incidencia){
		incidenciasCompletasRepository.insert(incidencia);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteAll(){
		incidenciasCompletasRepository.deleteAll();
	}
	
	@RequestMapping(value = "/byIdIncidencia",
			params = { "idIncidencia"},
			method = RequestMethod.GET)
	public IncidenciasCompletas getIncidenciasPorIdIncidencia(@RequestParam("idIncidencia") String idIncidencia){
		return incidenciasCompletasRepository.findByidIncidencia(idIncidencia);
	}
	
	@RequestMapping(value = "/byIdPeticion",
			params = { "idPeticion"},
			method = RequestMethod.GET)
	public IncidenciasCompletas getIncidenciasPorIdPeticion(@RequestParam("idPeticion") String idPeticion){
		return incidenciasCompletasRepository.findByidPeticion(idPeticion);
	}
	
	@RequestMapping(
			  value = "/AllByEstado", 
			  params = {"estado"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByEstado(@RequestParam("estado") String estado){				 
		 return incidenciasCompletasRepository.findAllByEstado(estado);
	}
	
	@RequestMapping(
			  value = "/AllByTipo", 
			  params = {"tipo"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByTipo(@RequestParam("tipo") String tipo){				 
		 return incidenciasCompletasRepository.findAllByTipo(tipo);
	}
	
	@RequestMapping(
			  value = "/AllByFechaApertura", 
			  params = {"fechaApertura"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByFechaApertura(@RequestParam("fechaApertura") String fechaApertura){				 
		 return incidenciasCompletasRepository.findAllByFechaApertura(fechaApertura);
	}
	
	@RequestMapping(
			  value = "/AllByMotivoEstado", 
			  params = {"motivoEstado"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByMotivoEstado(@RequestParam("motivoEstado") String motivoEstado){				 
		 return incidenciasCompletasRepository.findAllByMotivoEstado(motivoEstado);
	}
	
	@RequestMapping(
			  value = "/AllByPrioridad", 
			  params = {"motivoEstado"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByPrioridad(@RequestParam("prioridad") String prioridad){				 
		 return incidenciasCompletasRepository.findAllByprioridad(prioridad);
	}
	
	@RequestMapping(
			  value = "/AllByGrupoAsignado", 
			  params = {"grupoAsignado"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByGrupoAsignado(@RequestParam("grupoAsignado") String grupoAsignado){				 
		 return incidenciasCompletasRepository.findAllByGrupoAsignado(grupoAsignado);
	}
	
	@RequestMapping(
			  value = "/AllByResumen", 
			  params = {"resumen"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByResumen(@RequestParam("resumen") String resumen){				 
		 return incidenciasCompletasRepository.findAllByResumen(resumen);
	}
	
	@RequestMapping(
			  value = "/AllByUsuarioAsignado", 
			  params = {"usuarioAsignado"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByUsuarioAsignado(@RequestParam("usuarioAsignado") String usuarioAsignado){				 
		 return incidenciasCompletasRepository.findAllByUsuarioAsignado(usuarioAsignado);
	}
	
	@RequestMapping(
			  value = "/AllByEntorno", 
			  params = {"entorno"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByEntorno(@RequestParam("entorno") String entorno){				 
		 return incidenciasCompletasRepository.findAllByEntorno(entorno);
	}
	
	@RequestMapping(
			  value = "/AllByServicio", 
			  params = {"servicio"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByServicio(@RequestParam("servicio") String servicio){				 
		 return incidenciasCompletasRepository.findAllByServicio(servicio);
	}
	
	@RequestMapping(
			  value = "/AllByFechaCompromiso", 
			  params = {"fechaCompromiso"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByFechaCompromiso(@RequestParam("fechaCompromiso") String fechaCompromiso){				 
		 return incidenciasCompletasRepository.findAllByFechaCompromiso(fechaCompromiso);
	}
	
	@RequestMapping(
			  value = "/AllByCanalEntrada", 
			  params = {"canalEntrada"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByCanalEntrada(@RequestParam("canalEntrada") String canalEntrada){				 
		 return incidenciasCompletasRepository.findAllByCanalEntrada(canalEntrada);
	}
	
	@RequestMapping(
			  value = "/AllByEstadoSLM", 
			  params = {"estadoSLM"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByEstadoSLM(@RequestParam("estadoSLM") String estadoSLM){				 
		 return incidenciasCompletasRepository.findAllByEstadoSLM(estadoSLM);
	}
	
	@RequestMapping(
			  value = "/AllByFechaReapertura", 
			  params = {"fechaReapertura"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllByFechaReapertura(@RequestParam("fechaReapertura") String fechaReapertura){				 
		 return incidenciasCompletasRepository.findAllByFechaReapertura(fechaReapertura);
	}
	
//	@RequestMapping(
//			  value = "/AllByGrupoYEstado", 
//			  params = {"grupo", "estado"}, 
//			  method = RequestMethod.GET)
//	@ResponseBody
//	public List<IncidenciasCompletas> findAllByGrupoAndEstado(@RequestParam("grupo") String grupo, @RequestParam("estado") String estado){				 
//		 return incidenciasCompletasRepository.findAllByGrupoAndEstado(grupo, estado);
//	}
	
	@RequestMapping(
			  value = "/AllByGrupoAndEstado", 
			  params = { "grupoAsignado", "estado" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllBygrupoAsignadoAndEstado(@RequestParam("grupoAsignado") String grupoAsignado, @RequestParam("estado") String estado){				 
		 return incidenciasCompletasRepository.findAllBygrupoAsignadoAndEstado(grupoAsignado, estado);
	}
	
	@RequestMapping(
			  value = "/AllByGrupoAndMotivoEstado", 
			  params = { "grupoAsignado", "motivoEstado" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<IncidenciasCompletas> findAllBygrupoAsignadoAndMotivoEstado(@RequestParam("grupoAsignado") String grupoAsignado, @RequestParam("motivoEstado") String motivoEstado){				 
		 return incidenciasCompletasRepository.findAllBygrupoAsignadoAndMotivoEstado(grupoAsignado, motivoEstado);
	}
	
	@RequestMapping(value = "/getSysdate", method = RequestMethod.GET)
	public String getSysDate(){
		return incidenciasCompletasRepository.findAll().get(0).getSysdate();
	}

	
	
}
