package teste.apirest.ame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teste.apirest.ame.repositorios.PlanetaRepositorio;

@RestController
@RequestMapping("/planeta")
public class PlanetasController {
	
	@Autowired
	private PlanetaRepositorio repositorio;
	
	
	@RequestMapping( value= "/", method = RequestMethod.GET)
	public List getPlanetas() {
		return repositorio.findAll();
	}
}
