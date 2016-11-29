package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import domain.Categoria;
import domain.Estabelecimento;
import service.CategoriaService;
import service.EstabelecimentoService;

@ManagedBean
@ViewScoped
public class MenuMB {

	@Inject 
	private CategoriaService categoriaService;
	
	@Inject 
	private EstabelecimentoService estabelecimentoService;
	
	private Categoria categoria;
	
	public MenuMB() {
		categoria = new Categoria();
	}
	
	public String create(){
		return "/interna/menu/create";
	}
	
	public void setIdParam(int id){
		categoria.setIdCategoria(id);
	}
	
	public String edit(){
		categoriaService.updateCategoria(categoria);
		
		return "/interna/menu/list";
	}
	
	public String save(){
		
		if(categoria.getNome().isEmpty()){
			error("Nome da categoria vazia");
		} else {
			
			Estabelecimento estabelecimento = estabelecimentoService.findByCodIdentificacao("teste");
			categoria.setEstabelecimento( estabelecimento );
			categoria.setIdEstabelecimento( estabelecimento.getIdEstabelecimento() );
			
			categoriaService.addCategoria(categoria);
			
		}
		
		return "/interna/menu/list";
	}
	
	public List<Categoria> list(){
		return categoriaService.findAll();
	}
	
	public String remove(int id){
		
		categoriaService.removeCategoria( categoriaService.findById(id) );
		
		return "/interna/menu/list";
		
	}
	
	public String goSubmenu(){
		return "/interna/submenu/list";
	}
	
	public String goEdit(){
		return "/interna/menu/edit";
	}

	public void error(String message){
		FacesMessage msg = new FacesMessage(message);
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage("", msg);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
