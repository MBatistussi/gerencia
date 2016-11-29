package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Critica {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCritica;
	
	private String pergunta;
	private String resposta;
	private int avaliacao;
	private String sugestao;
	private int idMesa;
	
	@JsonIgnore
	@ManyToOne
	private Mesa mesa;
	
	public Critica(){
		
	}
	
	public Critica(int idCritica, String pergunta, String resposta, int avaliacao, String sugestao){
		this.idCritica = idCritica;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.avaliacao = avaliacao;
		this.sugestao = sugestao;
	}
	
	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getIdCritica() {
		return idCritica;
	}

	public void setIdCritica(int idCritica) {
		this.idCritica = idCritica;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	
}
