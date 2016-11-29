package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Mesa;

@Stateless
public class MesaDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void inserir(Mesa mesa) {
		
		if(entityManager == null){
			System.out.println("EntityManager null");
		} else {
			entityManager.persist(mesa);
			System.out.println("Salvo");
		}
		
	}
	
	public void remover(Mesa mesa) {
		
		mesa = entityManager.find(Mesa.class, mesa.getIdMesa());
		entityManager.remove(mesa);
		
	}
	
	public void atualizar(Mesa mesa) {
		Mesa mesaManaged = entityManager.merge( (Mesa) entityManager.find(Mesa.class, mesa.getIdMesa()) );
		mesaManaged.setSituacao( mesa.getSituacao() );
	}
	
	public Mesa findById(int id) {

        return (Mesa) entityManager.find(Mesa.class, id);
		
	}
	
//	public void removeAll() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Query qr = session.createQuery("DELETE FROM mesas");
//		qr.executeUpdate();
//		
//	}
	
	
	@SuppressWarnings("unchecked")
	public List<Mesa> findAll() {
		
		String qs = "SELECT e FROM Mesa e";
		Query qr = entityManager.createQuery(qs);
		
		try {
			return (List<Mesa>) qr.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		
	}	
	
}
