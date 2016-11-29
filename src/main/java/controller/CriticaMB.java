package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import dao.CriticaDao;
import dao.MesaDao;
import domain.Critica;

@ManagedBean
@ViewScoped
public class CriticaMB {

	String resposta[];
	
	@Inject 
	CriticaDao criticaDao;
	
	@Inject 
	MesaDao mesaDao;
	
	public CriticaMB() {
		
		resposta = new String[1000];
		
	}
	
	public List<Critica> list(){
		
		return criticaDao.findAll();
		
	}
	
	public String sendAnswer( int id, int loop ){
		
		Critica critica = criticaDao.findById(id);
		
		critica.setResposta(resposta[loop]);
		
		criticaDao.atualizar(critica);
		
		return "/interna/feedback/list";
		
	}

	public String[] getResposta() {
		return resposta;
	}

	public void setResposta(String[] resposta) {
		this.resposta = resposta;
	}

}
