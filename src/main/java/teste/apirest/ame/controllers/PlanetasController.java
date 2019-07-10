package teste.apirest.ame.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teste.apirest.ame.modelos.Planeta;
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
	
	
	@RequestMapping( value="/{id}", method = RequestMethod.GET)
	public Planeta getPlanetaPorId(@PathVariable("id") @Valid ObjectId id) {
		return repositorio.findBy_id(id);
	}
	@RequestMapping( value="/nome/{nome}", method = RequestMethod.GET)
	public List getPlanetaPorNome(@PathVariable("nome")@Valid String nome) {
		return repositorio.findByNomeLike(nome);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void atualizarPlanetaPorId(@PathVariable("id") ObjectId id, @Valid @RequestBody Planeta planeta) {
		planeta.set_id(id);
		repositorio.save(planeta);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	  public Planeta criarPlaneta(@Valid @RequestBody Planeta planeta) {
	   planeta.set_id(ObjectId.get());
	   repositorio.save(planeta);
	   return planeta;
	  }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void excluirPlaneta(@PathVariable ObjectId id) {
	   repositorio.delete(repositorio.findBy_id(id));
	  }
	
}
