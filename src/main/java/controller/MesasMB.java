package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import domain.Mesa;
import service.EstabelecimentoService;
import service.MesaService;

@ManagedBean
@RequestScoped
public class MesasMB {

	private static List<Mesa> listMesas = new ArrayList<>();
	private Mesa mesa;
	
	@Inject
	private MesaService mesaService;
	
	@Inject 
	private EstabelecimentoService estabelecimentoService;

	public MesasMB() {
		mesa = new Mesa();
	}

	public String create() {
		
		return "/interna/mesa/create.jsf";
	}
	
	public List<Mesa> list(){
		
		return mesaService.findAll();
		
	}
	
	boolean exist = false;
	
	public String save(){
		
		List<Mesa> mesas = mesaService.findAll();
		
		mesas.forEach(key -> { if(key.getNumero() == mesa.getNumero()) exist = true; });
		
		if(exist){
			error("Já existem uma mesa com esse número");
		} else if (mesa.getCapacidade() <= 0) {
			error("Capacidade inválida, coloque um valor maior que 0");
		} else {
			mesa.setSituacao("normal");
			mesa.setHorarioAbertura(new Date(1));
			mesa.setHorarioTermino(new Date(1));
			mesa.setEstabelecimento( estabelecimentoService.findByCodIdentificacao("teste") );
			mesaService.addMesa(mesa);
		}
		
		return "/interna/mesa/list.jsf";
	}
	
	public void error(String message){
		FacesMessage msg = new FacesMessage(message);
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage("", msg);
	}

	public String edit() {
		return "/interna/mesa/list.jsf";
	}
	
 
	public String remove(int idMesa) {
		
		mesaService.removeMesa( mesaService.findById(idMesa) );
		
		return "/interna/mesa/list.jsf";
	}

	public List<Mesa> getListMesas() {
		return listMesas;
	}

	public void setListMesas(List<Mesa> listMesas) {
		this.listMesas = listMesas;
	}
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
