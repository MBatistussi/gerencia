package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Critica;

@Stateless
public class CriticaDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void inserir(Critica critica) {
	
		entityManager.persist(critica);
		
	}
	
	public void remover(Critica critica) {
		
		critica = entityManager.find(Critica.class, critica.getIdCritica());
		entityManager.remove(critica);
		
	}
	
	public void atualizar(Critica critica) {
		Critica critica2 = (Critica) entityManager.find(Critica.class, critica.getIdCritica());
		Critica criticaManaged = entityManager.merge(critica2);
		criticaManaged.setResposta(critica.getResposta());
	}
	
	public Critica findById(int id) {

            return (Critica) entityManager.find(Critica.class, id);
	}
	
//	public void removeAll() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Query qr = session.createQuery("DELETE FROM criticas");
//		qr.executeUpdate();
//		
//	}
	
	@SuppressWarnings("unchecked")
	public List<Critica> findAll() {
		
		String qs = "SELECT e FROM Critica e";
		Query qr = entityManager.createQuery(qs);
		
		return (List<Critica>) qr.getResultList();
				
	}	
	
	@SuppressWarnings("unchecked")
	public List<Critica> findByIdMesa(int id){
		
		String qs = "SELECT e FROM Critica e where e.idMesa = :id";
		Query qr = entityManager.createQuery(qs);
		qr.setParameter("id", id);
		return (List<Critica>) qr.getResultList();
		
	}

}
