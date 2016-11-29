package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.RefeicaoDao;
import domain.Refeicao;

@Stateless
public class RefeicaoService {

	@Inject  
	private RefeicaoDao refeicaoDao;
	
	public RefeicaoService() {}
	
	public void addRefeicao(Refeicao refeicao){
		refeicaoDao.inserir(refeicao);
	}
	
	public void removeRefeicao(int id){
		refeicaoDao.remover(id);
	}
	
	public void updateRefeicao(Refeicao refeicao){
		refeicaoDao.atualizar(refeicao);
	}
	
	public Refeicao findById(int id){
		return refeicaoDao.findById(id);
	}

	public List<Refeicao> findAll(){
		return refeicaoDao.findAll();
	}

	public RefeicaoDao getRefeicaoDao() {
		return refeicaoDao;
	}

	public void setRefeicaoDao(RefeicaoDao cardapioDao) {
		this.refeicaoDao = cardapioDao;
	}
	
	public List<Refeicao> findByCategoriaId(int id){
		
		return refeicaoDao.findByCategoriaId(id);
		
	}
	
}
