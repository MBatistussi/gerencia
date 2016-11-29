package service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import dao.MesaDao;
import domain.Mesa;

@Stateful
public class MesaService {
	
	@Inject  
	private MesaDao mesaDao;
	
	public MesaService() {}
	
	public void addMesa(Mesa mesa){
		
		mesaDao.inserir(mesa);
		
	}
	
	public void removeMesa(Mesa mesa){
		mesaDao.remover(mesa);
	}
	
	public void updateMesa(Mesa mesa){
		mesaDao.atualizar(mesa);
	}
	
	public Mesa findById(int id){
		return mesaDao.findById(id);
	}
	
	public List<Mesa> findAll(){
		return mesaDao.findAll();
	}

	public MesaDao getMesaDao() {
		return mesaDao;
	}

	public void setMesaDao(MesaDao mesaDao) {
		this.mesaDao = mesaDao;
	}
	

}
