package com.softtek.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
//	@RequestMapping(value = "/{pais}", method = RequestMethod.GET)
//	public List<String> getUltimaEjecucionPorPais(@PathVariable (name="pais") String pais){
//		
//		 //Desarrollo
//		 String oksDe = resultadosRepository.findByPaisAndEntorno(pais, "Desarrollo").getOk();
//		 String erroresDe = resultadosRepository.findByPaisAndEntorno(pais, "Desarrollo").getError();
//		 String avisosDe = resultadosRepository.findByPaisAndEntorno(pais, "Desarrollo").getAvisos();
//		 
//		 //Integrado
//		 String oksEI = resultadosRepository.findByPaisAndEntorno(pais, "Integrado").getOk();
//		 String erroresEI = resultadosRepository.findByPaisAndEntorno(pais, "Integrado").getError();
//		 String avisosEI = resultadosRepository.findByPaisAndEntorno(pais, "Integrado").getAvisos();
//		 
//		 //Produccion
//		 String oksPro = resultadosRepository.findByPaisAndEntorno(pais, "Produccion").getOk();
//		 String erroresPro = resultadosRepository.findByPaisAndEntorno(pais, "Produccion").getError();
//		 String avisosPro = resultadosRepository.findByPaisAndEntorno(pais, "Produccion").getAvisos();
//		 
//		 List<String> listaUltimaEjecucion = new ArrayList<String>();
//		 
//		 listaUltimaEjecucion.add("Produccion" + oksPro + erroresPro + avisosPro);
//		 listaUltimaEjecucion.add("Integrado" + oksEI + erroresEI + avisosEI);
//		 listaUltimaEjecucion.add("Desarrollo" + oksDe + erroresDe + avisosDe);
//		 
//		 return listaUltimaEjecucion;
//	}
	
	
	@RequestMapping(value = "/{pais,entorno}", method = RequestMethod.GET)
	public Resultados getEjecucionPorPais(@PathVariable (name="pais") String pais, @PathVariable (name="entorno") String entorno){				 
		 return resultadosRepository.findByPaisAndEntorno(pais, entorno);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addEjecucion(@RequestBody Resultados resultados){
		resultadosRepository.insert(resultados);
	}
	
}
