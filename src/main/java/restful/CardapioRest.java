package restful;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Categoria;
import service.CategoriaService;

@Stateless
@Path("/cardapio")
public class CardapioRest {

	@Inject
	private CategoriaService categoriaService;

	public CardapioRest(){}

	@GET
	@Path("/categorias/{idEstabelecimento}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> listar(@PathParam("idEstabelecimento") int idEstabelecimento){	
		
		List<Categoria> categorias = categoriaService.findAllByEstabelecimentoId(idEstabelecimento);
		
		return categorias;
	}

}
