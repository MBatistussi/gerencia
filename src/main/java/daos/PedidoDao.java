package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Pedido;

@Stateless
public class PedidoDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void inserir(Pedido pedido) {
		entityManager.persist(pedido);
	}
	
	public void remover(Pedido pedido) {
		
		pedido = entityManager.find(Pedido.class, pedido.getIdPedido());
		entityManager.remove(pedido);		
	}
	
	public void atualizar(Pedido pedido) {
	
		Pedido pedido2 = (Pedido) entityManager.find(Pedido.class, pedido.getIdPedido());
		Pedido pedidoManaged = entityManager.merge(pedido2);
		pedidoManaged.setSituacao(pedido.getSituacao());
		
	}
	
	public Pedido findById(int id) {
		
		return (Pedido) entityManager.find(Pedido.class, id);
		
	}
	
//	public void removeAll() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Query qr = session.createQuery("DELETE FROM pedidos");
//		qr.executeUpdate();
//		
//	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> findAll() {
		String qs = "SELECT e FROM Pedido e";
		Query qr = entityManager.createQuery(qs);
		return (List<Pedido>) qr.getResultList();		
	}	
	
	@SuppressWarnings("unchecked")
	public List<Pedido> findByMesaId(int idMesa) {
		String qs = "SELECT e FROM Pedido e where e.idMesa = :idMesa";
		Query qr = entityManager.createQuery(qs);
		qr.setParameter("idMesa", idMesa);
		return (List<Pedido>) qr.getResultList();		
	}	

}
