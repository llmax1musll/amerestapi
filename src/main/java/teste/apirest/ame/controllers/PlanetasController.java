package teste.apirest.ame.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	public Planeta getPlanetaPorNome(@PathVariable("nome")@Valid String nome) {
		return repositorio.findByNome(nome);
	}
	@RequestMapping( value="/buscar/nome/{nome}", method = RequestMethod.GET)
	public List getBuscarPlanetaPorNome(@PathVariable("nome")@Valid String nome) {
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
	   
	   
	   
	   	
	     
	   	try {
	   		final String uri = "https://swapi.co/api/planets/?search="+planeta.getNome();
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            Object response = restTemplate.exchange(uri, HttpMethod.GET,entity,Object.class);
            
            
            
            System.out.println(response);
            
        } catch (Exception ex) {
           ex.printStackTrace();

        }

	   
	    return planeta;
	  }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void excluirPlaneta(@PathVariable ObjectId id) {
	   repositorio.delete(repositorio.findBy_id(id));
	  }
	
}
