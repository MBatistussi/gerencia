package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estabelecimento  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEstabelecimento;
	
	private String name;
	private String descricao;
	private String horario;
	private String formaDePagamento;
	private String codIdentificacao;
	
	@JsonIgnore
	@OneToMany(mappedBy="estabelecimento", cascade=CascadeType.ALL)
	private List<Categoria> categorias;
	
	@JsonIgnore
	@OneToMany(mappedBy="estabelecimento", cascade=CascadeType.ALL)
	private List<Mesa> mesas;	
	
	public Estabelecimento(){
		
	}

	public Estabelecimento(int idEstabelecimento, String name, String descricao, String horario, String formaDePagamento, String codIdentificacao){
		this.idEstabelecimento = idEstabelecimento;
		this.name = name;
		this.descricao = descricao;
		this.horario = horario;
		this.formaDePagamento = formaDePagamento;
		this.codIdentificacao = codIdentificacao;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Integer getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Integer idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public String getCodIdentificacao() {
		return codIdentificacao;
	}

	public void setCodIdentificacao(String codIdentificacao) {
		this.codIdentificacao = codIdentificacao;
	}

//	public List<Mesa> getMesas() {
//		return mesas;
//	}
//
//	public void setMesas(List<Mesa> mesas) {
//		this.mesas = mesas;
//	}

	
	
}