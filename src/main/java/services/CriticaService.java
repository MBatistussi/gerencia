package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CriticaDao;
import domain.Critica;

@Stateless
public class CriticaService {
	
	@Inject  
	private CriticaDao criticaDao;
	
	public CriticaService() {}
	
	public void addCardapio(Critica critica){
		
		criticaDao.inserir(critica);
		
	}
	
	public void removeCritica(Critica critica){
		criticaDao.remover(critica);
	}
	
	public void updateCritica(Critica critica){
		criticaDao.atualizar(critica);
	}
	
	public void findById(int id){
		criticaDao.findById(id);
	}
	
	public List<Critica> findAll(){
		return criticaDao.findAll();
	}
	
	public List<Critica> findByIdMesa(int id){
		return criticaDao.findByIdMesa(id);
	}

	public CriticaDao getCriticaDao() {
		return criticaDao;
	}

	public void setCardapioDao(CriticaDao criticaDao) {
		this.criticaDao = criticaDao;
	}

}
