package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import dao.EstabelecimentoDao;
import domain.Estabelecimento;

@ManagedBean
@ViewScoped
public class EstabelecimentoMB {

	@Inject EstabelecimentoDao estabelecimentoDao;
	Estabelecimento estabelecimento;
	
	public EstabelecimentoMB() {
		estabelecimento = new Estabelecimento();
	}
	
	@PostConstruct
	private void init(){
		estabelecimento = estabelecimentoDao.findByCodIdentificacao("teste");
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	
	
}
