package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Refeicao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRefeicao;
	
	private String nome;
	private String ingredientes;
	private String descricao;
	private double preco;
	private int idCategoria;
	
	@JsonIgnore
	@ManyToOne
	private Categoria categoria;
	
	public Refeicao(){}
	
	public Refeicao(int idRefeicao, String nome, String ingredientes, String descricao, double preco){
		this.idRefeicao = idRefeicao;
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getIdRefeicao() {
		return idRefeicao;
	}

	public void setIdRefeicao(int idRefeicao) {
		this.idRefeicao = idRefeicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
