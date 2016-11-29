package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Categoria;

@Stateless
public class CategoriaDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void inserir(Categoria categoria) {
		entityManager.persist(categoria);
	}

	public void remover(Categoria categoria) {
		
		categoria = entityManager.find(Categoria.class, categoria.getIdCategoria());
		
		entityManager.remove(categoria);
		
	}
	
	public void atualizar(Categoria categoria) {
		
		Categoria categoriaManaged = entityManager.merge( (Categoria) entityManager.find(Categoria.class, categoria.getIdCategoria() ) );
		categoriaManaged.setNome(categoria.getNome());
		categoriaManaged.setDescricao(categoria.getDescricao());
		
	}
	
	public Categoria findById(int id) {

        return (Categoria) entityManager.find(Categoria.class, id);
	}
	
//	public void removeAll() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Query qr = session.createQuery("DELETE FROM categorias");
//		qr.executeUpdate();
//		
//	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findAll() {
		 
		String qs = "SELECT e FROM Categoria e";
		Query qr = entityManager.createQuery(qs);
		
		return (List<Categoria>) qr.getResultList();
	}	
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findAllByEstabelecimentoId(int id) {
		 
		String qs = "SELECT e FROM Categoria e where e.idEstabelecimento = :id";	
		Query qr = entityManager.createQuery(qs);
		qr.setParameter("id", id);
		
		return (List<Categoria>) qr.getResultList();
	}	
	
}
