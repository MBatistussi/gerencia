package domain;

import java.sql.Date;
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
public class Mesa {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMesa;
	
	private int numero;
	private int capacidade;
	private String situacao;
	private Date horarioAbertura;
	private Date horarioTermino;
	
	@JsonIgnore
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	@JsonIgnore
	@OneToMany(mappedBy="mesa", cascade=CascadeType.ALL)
	private List<Pedido> pedidos;
	
	@JsonIgnore
	@OneToMany(mappedBy="mesa", cascade=CascadeType.ALL)
	private List<Critica> criticas;
	
	public Mesa(){
		
	}
	
	public Mesa(int idMesa, int numero, int capacidade, String situacao, Date horarioAbertura, Date horarioTermino){
		this.idMesa = idMesa;
		this.numero = numero;
		this.capacidade = capacidade;
		this.situacao = situacao;
		this.horarioAbertura = horarioAbertura;
		this.horarioTermino = horarioTermino;
	}
	
	public List<Critica> getCriticas() {
		return criticas;
	}

	public void setCriticas(List<Critica> criticas) {
		this.criticas = criticas;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public void setIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(Date horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public Date getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(Date horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

}
