package com.softtek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Resultados> getEjecucionPorPais(@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return this.getResultResponse(resultadosRepository.findByPaisAndEntorno(pais, entorno));
	}
	
	@RequestMapping(
			  value = "/paisEntornoDesc", 
			  params = { "pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public  ResponseEntity<Resultados> getEjecucionPorPaisDesc(@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return this.getResultResponse(resultadosRepository.findByPaisAndEntornoOrderBySysdateDesc(pais, entorno));
	}
	
	@RequestMapping(
			  value = "/UuaaPaisEntornoDesc", 
			  params = { "uuaa","pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public  ResponseEntity<Resultados> getEjecucionPorUUAAPaisDesc(@RequestParam("uuaa") String uuaa,@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return this.getResultResponse(resultadosRepository.findByUuaasLikeAndPaisAndEntornoOrderBySysdateDesc(uuaa, pais, entorno));
	}
	
	@RequestMapping(
			  value = "/UuaaPaisEntornoAsc", 
			  params = { "uuaa","pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public  ResponseEntity<Resultados> getEjecucionPorUUAAPaisAsc(@RequestParam("uuaa") String uuaa,@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return this.getResultResponse(resultadosRepository.findByUuaasLikeAndPaisAndEntornoOrderBySysdateAsc(uuaa, pais, entorno));
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
	public  ResponseEntity<Resultados> getEjecucionPorTipoEjecucionAsc(@RequestParam("tipoEjecucion") String tipoEjecucion){				 
		 return this.getResultResponse(resultadosRepository.findByTipoEjecucionOrderBySysdateAsc(tipoEjecucion));
	}
	
	@RequestMapping(
			  value = "/tipoEjecucionDesc", 
			  params = { "tipoEjecucion"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public  ResponseEntity<Resultados> getEjecucionPorTipoEjecucionDesc(@RequestParam("tipoEjecucion") String tipoEjecucion){				 
		 return this.getResultResponse(resultadosRepository.findByTipoEjecucionOrderBySysdateDesc(tipoEjecucion));
	}

	@RequestMapping(
			  value = "/paisEntornoAsc", 
			  params = { "pais", "entorno" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public  ResponseEntity<Resultados> getEjecucionPorPaisAsc(@RequestParam("pais") String pais, @RequestParam("entorno") String entorno){				 
		 return this.getResultResponse(resultadosRepository.findByPaisAndEntornoOrderBySysdateAsc(pais, entorno));
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
	public  ResponseEntity<Resultados> findByTipoEjecucionAndEntornoOrderBySysdateAsc(@RequestParam("tipoEjecucion") String tipoEjecucion, @RequestParam("entorno") String entorno){				 
		 return this.getResultResponse(resultadosRepository.findByTipoEjecucionAndEntornoOrderBySysdateAsc(tipoEjecucion, entorno));
	}
	
	@RequestMapping(
			  value = "/tipoEjecucionEntornoDesc", 
			  params = {"tipoEjecucion","entorno"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public  ResponseEntity<Resultados> findByTipoEjecucionAndEntornoOrderBySysdateDesc(@RequestParam("tipoEjecucion") String tipoEjecucion, @RequestParam("entorno") String entorno){				 
		 return this.getResultResponse(resultadosRepository.findByTipoEjecucionAndEntornoOrderBySysdateDesc(tipoEjecucion, entorno));
	}
	
	@RequestMapping(
			  value = "/AllByTipoEjecucionEntorno", 
			  params = {"tipoEjecucion","entorno"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Resultados> findAllByTipoEjecucionAndEntornoOrderBySysdateDesc(@RequestParam("tipoEjecucion") String tipoEjecucion, @RequestParam("entorno") String entorno){				 
		 return resultadosRepository.findAllByTipoEjecucionAndEntornoOrderBySysdateAsc(tipoEjecucion, entorno);
	}
	
	@RequestMapping(
			  value = "/AllByTipoEjecucion", 
			  params = {"tipoEjecucion"}, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Resultados> findAllByTipoEjecucionOrderBySysdateDesc(@RequestParam("tipoEjecucion") String tipoEjecucion){				 
		 return resultadosRepository.findAllByTipoEjecucionOrderBySysdateAsc(tipoEjecucion);
	}

	private ResponseEntity<Resultados> getResultResponse( List<Resultados> results) {
		
		if (results != null && !results.isEmpty()) {

			return ResponseEntity.ok()
			        .body(results.get(0));
		} else {
			return ResponseEntity.noContent().build();

		}
			
		
	}
	
}
