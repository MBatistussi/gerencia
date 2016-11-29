package domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPedido;
	
	private Date horarioPedido;
	
	private String situacao;
	
	private String descricao;
	
	private String alteracao;
	
	private int idMesa;
	
	@JsonIgnore
	@ManyToOne
	private Mesa mesa;
	
	public Pedido(){}
	
	public Pedido(int idPedido, Date horarioPedido, String situacao, String descricao, String alteracao) {
		super();
		this.idPedido = idPedido;
		this.horarioPedido = horarioPedido;
		this.situacao = situacao;
		this.descricao = descricao;
		this.alteracao = alteracao;
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

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getHorarioPedido() {
		return horarioPedido;
	}

	public void setHorarioPedido(Date horarioPedido) {
		this.horarioPedido = horarioPedido;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(String alteracao) {
		this.alteracao = alteracao;
	}
	
	
	
	
	
}
