package com.softtek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.incidenciasCompletas.IncidenciaCompleta;
import com.softtek.incidenciasCompletas.IncidenciasCompletasRepository;

@RestController
@RequestMapping(value = "/api/incidenciasCompletas")
public class IncidenciasCompletasController {
	
	@Autowired
	IncidenciasCompletasRepository incidenciasCompletasRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<IncidenciaCompleta> getIncidencias(){
		return incidenciasCompletasRepository.findAll();
	}
	
	
	
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public void addIncidencia(@RequestBody IncidenciaCompleta incidencia){
//		incidenciasCompletasRepository.insert(incidencia);
//	}
//	
//	@RequestMapping(value = "", method = RequestMethod.DELETE)
//	public void deleteAll(){
//		incidenciasCompletasRepository.deleteAll();
//	}
	
	@RequestMapping(value = "/byIdIncidencia",
			params = { "idIncidencia"},
			method = RequestMethod.GET)
	public IncidenciaCompleta getIncidenciasPorIdIncidencia(@RequestParam("idIncidencia") String idIncidencia){
		return incidenciasCompletasRepository.findByidIncidencia(idIncidencia);
	}
	
	@RequestMapping(value = "/byIdPeticion",
			params = { "idPeticion"},
			method = RequestMethod.GET)
	public IncidenciaCompleta getIncidenciasPorIdPeticion(@RequestParam("idPeticion") String idPeticion){
		return incidenciasCompletasRepository.findByidPeticion(idPeticion);
	}
	
	
}
