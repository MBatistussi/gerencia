package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import domain.Refeicao;
import service.CategoriaService;
import service.RefeicaoService;

@ManagedBean
@ViewScoped
public class SubMenuMB {

	@Inject 
	RefeicaoService refeicaoService;
	
	@Inject 
	CategoriaService categoriaService;
	
	Refeicao refeicao;
	
	public SubMenuMB() {
		refeicao = new Refeicao();
	}
	
	public void setIdParamCategoria(int id){ 
		System.out.println(id+"");
		refeicao.setIdCategoria(id); 
	}
	
	public void setIdParamRefeicao(int id){ 
		
		refeicao.setIdRefeicao(id);
		Refeicao refeicaoTemp = refeicaoService.findById(id);
		refeicao.setIdCategoria( refeicaoTemp.getIdCategoria() );
		
	}
	
	public List<Refeicao> list(){
		return refeicaoService.findByCategoriaId( refeicao.getIdCategoria() );
	}
	
	public String create(){
		return "/interna/submenu/create";
	}
	
	public String goEdit(){
		return "/interna/submenu/edit";
	}
	
	public String edit(int id){
		System.out.println(">>>"+id);
		refeicaoService.updateRefeicao(refeicao);
		
		return "/interna/submenu/list";
	}
	
	public String save(){
		
		refeicao.setCategoria( categoriaService.findById( refeicao.getIdCategoria() ) );
		
		refeicaoService.addRefeicao(refeicao);
		
		return "/interna/submenu/list";
	}
	
	public String remove(int id){

		System.out.println("teste"+id);
		
		refeicaoService.removeRefeicao(id);
		
		return "/interna/submenu/list";
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	
}
