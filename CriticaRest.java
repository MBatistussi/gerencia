package restful;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Critica;
import domain.Mesa;
import service.CriticaService;
import service.MesaService;

@Stateless
@Path("/critica")
public class CriticaRest {

	@Inject 
	CriticaService criticaService;
	
	@Inject 
	MesaService mesaService;
	
	public CriticaRest() {}
	
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCritica(Critica critica){
		
		Mesa mesa = mesaService.findById(critica.getIdMesa());
		
		critica.setMesa(mesa);
		
		criticaService.addCardapio(critica);
		
		return Response.ok("ok").build();
	}
	
	@GET
	@Path("/info/{idMesa}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Critica> listar(@PathParam("idMesa") int idMesa){
		return criticaService.findByIdMesa(idMesa);
	}
	
}
