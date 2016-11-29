package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CategoriaDao;
import domain.Categoria;

@Stateless
public class CategoriaService {
	
	@Inject  
	private CategoriaDao categoriaDao;
	
	public CategoriaService() {}
	
	public void addCategoria(Categoria categoria){
		categoriaDao.inserir(categoria);		
	}
	
	public void removeCategoria(Categoria categoria){
		categoriaDao.remover(categoria);
	}
	
	public void updateCategoria(Categoria categoria){
		categoriaDao.atualizar(categoria);
	}
	
	public Categoria findById(int id){
		return categoriaDao.findById(id);
	}
	
	public List<Categoria> findAllByEstabelecimentoId(int id) {
		return categoriaDao.findAllByEstabelecimentoId(id);
	}
	
	public List<Categoria> findAll(){
		return categoriaDao.findAll();
	}

	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

}
