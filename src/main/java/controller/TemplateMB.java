package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class TemplateMB {

	public String toHome(){
		return "/interna/home.jsf";
	}
	
	public String toMesas(){
		return "/interna/home.jsf";
	}
	
}
