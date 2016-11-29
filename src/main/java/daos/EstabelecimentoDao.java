package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Estabelecimento;

@Stateless
public class EstabelecimentoDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void inserir(Estabelecimento estabelecimento){
		
		estabelecimento.setFormaDePagamento("teste");
		
		if(entityManager == null){
			System.out.println("EntityManager null");
		} else {
			entityManager.persist(estabelecimento);
			System.out.println("Salvo");
		}
		
	}
	
//	public void remover(Estabelecimento estabelecimento) {
//		
//		session.beginTransaction();
//		session.remove(estabelecimento);
//		session.getTransaction().commit();
//		session.close();
//		
//	}
//	
//	public void atualizar(Estabelecimento estabelecimento) {
//		session.beginTransaction();
//		session.update(estabelecimento);
//		session.getTransaction().commit();
//		session.close();
//		
//	}
//	
	
	public void update(Estabelecimento estabelecimento){
		entityManager.merge(estabelecimento);
	}
	
	public Estabelecimento findByCodIdentificacao(String codIdentificacao) {

		String qs = "select c from Estabelecimento c where c.codIdentificacao = :codIdentificacao";
		
		Query q = entityManager.createQuery(qs);
		
		q.setParameter("codIdentificacao", codIdentificacao);
		
		try {
			return (Estabelecimento) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
//	
//	public void removeAll() {
//		String hql = "DELETE FROM estabelecimentos";
//		Query qr = session.createQuery(hql);
//		qr.executeUpdate();
//		
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Estabelecimento> findAll() {
//		
//		String hql="FROM estabelecimento";
//        Query qr = session.createQuery(hql);
//		List<Estabelecimento> estabelecimentos = qr.list();
//      
//        return estabelecimentos;
//				
//	}	
}