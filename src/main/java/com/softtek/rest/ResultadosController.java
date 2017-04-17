package com.softtek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addEjecucion(@RequestBody Resultados resultados){
		resultadosRepository.insert(resultados);
	}
	
}
