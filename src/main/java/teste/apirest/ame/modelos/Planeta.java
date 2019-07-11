package teste.apirest.ame.modelos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "planeta")
public class Planeta {
	@Id
	private ObjectId _id;
	@NotBlank(message = "Digite um nome para o planeta")
	private String nome;
	@NotBlank(message = "Digite o clima do planeta")
	private String clima;
	@NotBlank(message = "Digite o terreno do planeta")
	private String terreno;
	private int qtdAparicoesFilmes;
	
		
	
	
	public Planeta() {
		
	}
	public Planeta(ObjectId _id, String nome, String clima, String terreno, int qtdAparicoesFilmes) {
		this._id = _id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.qtdAparicoesFilmes = qtdAparicoesFilmes;
	}
	
	
	
	
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public int getQtdAparicoesFilmes() {
		return qtdAparicoesFilmes;
	}
	public void setQtdAparicoesFilmes(int qtdAparicoesFilmes) {
		this.qtdAparicoesFilmes = qtdAparicoesFilmes;
	}
	
	
	
	

}
