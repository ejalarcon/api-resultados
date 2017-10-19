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
			  value = "/UuaaPaisEntornoDesc", 
			  params = { "uuaa","pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados getEjecucionPorUUAAPaisDesc(@RequestParam("uuaa") String uuaa,@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findByUuaasLikeAndPaisAndEntornoOrderBySysdateDesc(uuaa, pais, entorno);
	}
	
	@RequestMapping(
			  value = "/UuaaPaisEntornoAsc", 
			  params = { "uuaa","pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados getEjecucionPorUUAAPaisAsc(@RequestParam("uuaa") String uuaa,@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findByUuaasLikeAndPaisAndEntornoOrderBySysdateAsc(uuaa, pais, entorno);
	}
	
	@RequestMapping(
			  value = "/uuaaPaisDesc", 
			  params = { "uuaa", "pais" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Resultados> getEjecucionPorUUAAPaisDesc(@RequestParam("uuaa") String uuaa, @RequestParam("pais") String pais){				 
		 return resultadosRepository.findAllByUuaasLikeAndPaisOrderBySysdateDesc(uuaa, pais);
	}
	
	@RequestMapping(
			  value = "/uuaaPaisAsc", 
			  params = { "uuaa", "pais" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Resultados> getEjecucionPorUUAAPaisAsc(@RequestParam("uuaa") String uuaa, @RequestParam("pais") String pais){				 
		 return resultadosRepository.findAllByUuaasLikeAndPaisOrderBySysdateAsc(uuaa, pais);
	}
	
	@RequestMapping(
			  value = "/tipoEjecucionAsc", 
			  params = { "tipoEjecucion"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados getEjecucionPorTipoEjecucionAsc(@RequestParam("tipoEjecucion") String tipoEjecucion){				 
		 return resultadosRepository.findByTipoEjecucionOrderBySysdateAsc(tipoEjecucion);
	}
	
	@RequestMapping(
			  value = "/tipoEjecucionDesc", 
			  params = { "tipoEjecucion"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados getEjecucionPorTipoEjecucionDesc(@RequestParam("tipoEjecucion") String tipoEjecucion){				 
		 return resultadosRepository.findByTipoEjecucionOrderBySysdateDesc(tipoEjecucion);
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
	
	@RequestMapping(
			  value = "/tipoEjecucionEntornoAsc", 
			  params = {"tipoEjecucion","entorno"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados findByTipoEjecucionAndEntornoOrderBySysdateAsc(@RequestParam("tipoEjecucion") String tipoEjecucion, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findByTipoEjecucionAndEntornoOrderBySysdateAsc(tipoEjecucion, entorno);
	}
	
	@RequestMapping(
			  value = "/tipoEjecucionEntornoDesc", 
			  params = {"tipoEjecucion","entorno"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public Resultados findByTipoEjecucionAndEntornoOrderBySysdateDesc(@RequestParam("tipoEjecucion") String tipoEjecucion, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findByTipoEjecucionAndEntornoOrderBySysdateDesc(tipoEjecucion, entorno);
	}
	
	@RequestMapping(
			  value = "/AllByTipoEjecucionEntorno", 
			  params = {"tipoEjecucion","entorno"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Resultados> findAllByTipoEjecucionAndEntornoOrderBySysdateDesc(@RequestParam("tipoEjecucion") String tipoEjecucion, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findAllByTipoEjecucionAndEntornoOrderBySysdateDesc(tipoEjecucion, entorno);
	}
	
}
