package service;

import javax.ejb.Stateful;
import javax.inject.Inject;

import dao.EstabelecimentoDao;
import domain.Estabelecimento;

@Stateful
public class EstabelecimentoService {

	@Inject  
	private EstabelecimentoDao estabelecimentoDao;
	
	public EstabelecimentoService() {}
	
	public void addEstablishment(Estabelecimento estabelecimento){
		
		estabelecimento.setFormaDePagamento("nullx");
		
		estabelecimentoDao.inserir(estabelecimento);
		
	}
	
	public Estabelecimento findByCodIdentificacao(String codIdentificacao){
		
		return estabelecimentoDao.findByCodIdentificacao(codIdentificacao);
		
	}
	
//	@Transactional
//	public void removeEstablishment(Estabelecimento estabelecimento){
//		estabelecimentoDao.remover(estabelecimento);
//	}
//	
//	@Transactional
//	public void updateEstablishment(Estabelecimento estabelecimento){
//		estabelecimentoDao.atualizar(estabelecimento);
//	}
//	
//	@Transactional
//	public void findById(Estabelecimento estabelecimento){
//		estabelecimentoDao.findById(estabelecimento);
//	}
//	
//	@Transactional
//	public void removeAll(){
//		estabelecimentoDao.removeAll();
//	}
//	
//	@Transactional
//	public List<Estabelecimento> findAll(){
//		return estabelecimentoDao.findAll();
//	}
//
//	@Transactional
//	public EstabelecimentoDao getEstabelecimentoDao() {
//		return estabelecimentoDao;
//	}
//
//	@Transactional
//	public void setEstabelecimentoDao(EstabelecimentoDao estabelecimentoDao) {
//		this.estabelecimentoDao = estabelecimentoDao;
//	}
	
}
