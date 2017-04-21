package com.softtek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.resultados.Resultados;
import com.softtek.resultados.ResultadosRepository;

@RestController
@RequestMapping(value = "/api/resultados")
public class ResultadosController {

	@Autowired
	ResultadosRepository resultadosRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Resultados> getResultados(){
		return resultadosRepository.findAll();
	}

	@RequestMapping(
			  value = "/paisEntorno", 
			  params = { "pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados getEjecucionPorPais(@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findByPaisAndEntorno(pais, entorno);
	}
	
	@RequestMapping(
			  value = "/paisEntornoDesc", 
			  params = { "pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados getEjecucionPorPaisDesc(@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findByPaisAndEntornoOrderBySysdateDesc(pais, entorno);
	}
	
	@RequestMapping(
			  value = "/paisEntornoAsc", 
			  params = { "pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados getEjecucionPorPaisAsc(@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findByPaisAndEntornoOrderBySysdateAsc(pais, entorno);
	}
	
	@RequestMapping(
			  value = "/paisDesc", 
			  params = {"pais"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Resultados> getEjecucionesPorPaisDesc(@RequestParam("pais") String pais){				 
		 return resultadosRepository.findByPaisOrderBySysdateDesc(pais);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addEjecucion(@RequestBody Resultados resultados){
		resultadosRepository.insert(resultados);
	}
	
}
