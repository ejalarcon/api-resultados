package com.softtek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.incidencias.Incidencias;
import com.softtek.incidencias.IncidenciasRepository;
import com.softtek.resultados.Resultados;
import com.softtek.resultados.ResultadosRepository;

@RestController
@RequestMapping(value = "/api/incidencias")
public class IncidenciasController {

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
		incidenciasRepository.save(incidencias);
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
//			  value = "/AllByEstadoGrupo", 
//			  params = {"estado","_id"}, 
//			  method = RequestMethod.GET)
//	@ResponseBody
//	public List<Incidencias> findAllByEstadoAndId(@RequestParam("estado") String estado, @RequestParam("_id") String _id){				 
//		 return incidenciasRepository.findAllByEstadoAndId(estado,_id);
//	}

	
}
