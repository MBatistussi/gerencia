package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Refeicao;

@Stateless
public class RefeicaoDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void inserir(Refeicao refeicao) {
		entityManager.persist(refeicao);
	}
	
	public void remover(int id) {
		
		Refeicao refeicao = entityManager.find(Refeicao.class, id);
		entityManager.remove(refeicao);
	}
	
	public void atualizar(Refeicao refeicao) {
		
		Refeicao refeicaoManaged = entityManager.merge( (Refeicao) entityManager.find(Refeicao.class, refeicao.getIdRefeicao()) );
		refeicaoManaged.setNome( refeicao.getNome() );
		refeicaoManaged.setIngredientes(refeicao.getIngredientes());
		refeicaoManaged.setDescricao(refeicao.getDescricao());
		refeicaoManaged.setPreco(refeicao.getPreco());
		
	}
	
	public Refeicao findById(int id) {

           return (Refeicao) entityManager.find(Refeicao.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Refeicao> findAll() {
		
		String qs = "SELECT e FROM Refeicao e";
		Query qr = entityManager.createQuery(qs);
		return (List<Refeicao>) qr.getResultList();
				
	}	

	@SuppressWarnings("unchecked")
	public List<Refeicao> findByCategoriaId(int id){
		
		String qs = "SELECT e FROM Refeicao e where e.idCategoria = :id";
		Query qr = entityManager.createQuery(qs);
		qr.setParameter("id", id);
		return (List<Refeicao>) qr.getResultList();
		
	}
	
}
