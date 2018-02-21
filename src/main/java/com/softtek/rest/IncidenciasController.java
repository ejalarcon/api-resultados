package com.softtek.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.incidencias.Incidencias;
import com.softtek.incidencias.IncidenciasRepository;

@RestController
@RequestMapping(value = "/api/incidencias")
public class IncidenciasController {
	
	private static final Logger log = Logger.getLogger(IncidenciasController.class);

	@Autowired
	IncidenciasRepository incidenciasRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Incidencias> getResultados(){
		return incidenciasRepository.findAll();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addGrupo(@RequestBody Incidencias incidencias){
		incidenciasRepository.insert(incidencias);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateGrupo(@RequestBody Incidencias incidencias){
		log.info("incidencias.getEstado: "+ incidencias.getEstado());
		log.info("incidencias.getGrupo: "+ incidencias.getGrupo());
		
		List<Incidencias> inci = incidenciasRepository.findAllByGrupoAndEstado(incidencias.getGrupo(),incidencias.getEstado());
		if(inci.size()>0){
			log.info("venga va actualizamos!");
			Incidencias updatable = inci.get(0);
			updatable.setAlta(incidencias.getAlta());
			updatable.setBaja(incidencias.getBaja());
			updatable.setCritica(incidencias.getCritica());
			updatable.setMedia(incidencias.getMedia());
			updatable.setEstado(incidencias.getEstado());
			incidenciasRepository.save(updatable);
		}else {
			
			incidenciasRepository.insert(incidencias);
			
		}
		
			
		
		
	}
	
	@RequestMapping(
			  value = "/AllByEstado", 
			  params = {"estado"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Incidencias> findAllByEstado(@RequestParam("estado") String estado){				 
		 return incidenciasRepository.findAllByEstado(estado);
	}
	
//	@RequestMapping(
//			  value = "/AllById", 
//			  params = {"_id"}, 
//			  method = RequestMethod.GET)
//	@ResponseBody
//	public List<Incidencias> findAllBy_Id(@RequestParam("_id") String _id){				 
//		 return incidenciasRepository.findAllBy_Id(_id);
//	}
	
//	@RequestMapping(
//			  value = "/AllByEstadoGrupo", 
//			  params = {"estado","_id"}, 
//			  method = RequestMethod.GET)
//	@ResponseBody
//	public List<Incidencias> findAllByEstadoAndId(@RequestParam("estado") String estado, @RequestParam("_id") String _id){				 
//		 return incidenciasRepository.findAllByEstadoAndId(estado,_id);
//	}

	
	private Incidencias existe (String grupo, String estado) {
		
		List<Incidencias> list = incidenciasRepository.findAllByGrupoAndEstado(grupo, estado);
		return (list.size()>0?list.get(0):null);
	}
	
}
