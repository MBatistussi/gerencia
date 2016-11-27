package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategoria;
	
	private String nome;
	private String descricao;
	private int idEstabelecimento;
	
	@JsonIgnore
	@OneToMany(mappedBy="categoria",cascade=CascadeType.ALL)
	private List<Refeicao> refeicao;
	
	@JsonIgnore
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	public Categoria(){}
	
	public Categoria(int idCategoria, String nome, String descricao){
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.descricao = descricao;
	}

	
	
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(int idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public List<Refeicao> getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(List<Refeicao> refeicao) {
		this.refeicao = refeicao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
