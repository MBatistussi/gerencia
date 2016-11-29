package restful;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Refeicao;
import service.RefeicaoService;

@Stateless
@Path("/cardapio")
public class RefeicaoRest {

	@Inject RefeicaoService refeicaoService;
	
	public RefeicaoRest() {}
	
	@GET
	@Path("/refeicoes/{idCategoria}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Refeicao> listar(@PathParam("idCategoria") int idCategoria){	
		
		return refeicaoService.findByCategoriaId(idCategoria);
	}
	
}
