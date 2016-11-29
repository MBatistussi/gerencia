package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import domain.Mesa;
import domain.Pedido;
import service.MesaService;
import service.PedidoService;

@ManagedBean
@ViewScoped
public class PedidoMB {

	@Inject 
	PedidoService pedidoService;
	
	@Inject
	MesaService mesaService;
	
	public PedidoMB() {
	}
	
	public List<Pedido> list(){
		
		return pedidoService.findAll();
	}
	
	public void remove(){
		
	}
	
	private boolean status = false;
	
	public String aceitarPedido(int id){
		
		Pedido pedido = pedidoService.findById(id);
		pedido.setSituacao("Pedido aceito");
		
		pedidoService.atualizarPedido(pedido);
		
		status = true;
		
		return "interna/pedido/list";
	}
	
	public String getStatus(){
		if(status){
			return "background-color:#123321;";
		} else {
			return "";
		}
	}
	
	public String fecharPedido(int id){
		
		Pedido pedido = pedidoService.findById(id);
		
		pedidoService.removerPedido( pedido );
		
		List<Pedido> pedidos = pedidoService.findByMesaId( pedido.getIdMesa() );
		
		if(pedidos.isEmpty()){
			Mesa mesa = mesaService.findById(pedido.getIdMesa());
			mesa.setSituacao("normal");
			mesaService.updateMesa(mesa);
			System.out.println("PASSOU!!!!!!!");
		}
		
		return "interna/pedido/list";
	}

	public String cancelarPedido(int id){
		
		Pedido pedido = pedidoService.findById(id);
		pedido.setSituacao("Pedido cancelado");
		
		pedidoService.atualizarPedido(pedido);
		
		return "interna/pedido/list";
	}
}
