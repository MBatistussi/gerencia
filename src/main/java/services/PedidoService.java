package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.PedidoDao;
import domain.Pedido;


@Stateless
public class PedidoService {

	@Inject
	PedidoDao pedidoDao;
	
	public void adicionarPedido(Pedido pedido) {
		pedidoDao.inserir(pedido);
	}
	
	public void removerPedido(Pedido pedido) {
		pedidoDao.remover(pedido);
	}
	
	public void atualizarPedido(Pedido pedido) {
		pedidoDao.atualizar(pedido);
	}
	
	public Pedido findById(int id) {	
		return pedidoDao.findById(id);		
	}
	
	public List<Pedido> findAll(){
		return pedidoDao.findAll();
	}
	
	public List<Pedido> findByMesaId(int idMesa) {	
		return pedidoDao.findByMesaId(idMesa);		
	}
	
	public List<Pedido> listarPedidos(){
		return pedidoDao.findAll();
	}
	
	/**
	 * verifica se o pedido existe no banco
	 * @param pedido
	 * @return
	 */
	
	public boolean existePedido(Pedido pedido){
		boolean existe = false;
		
		if(pedidoDao.findById(pedido.getIdPedido()) != null)
		{
			existe = true;
		}
		return existe;
		
	}
}
