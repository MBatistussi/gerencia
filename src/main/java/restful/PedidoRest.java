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

import domain.Mesa;
import domain.Pedido;
import service.MesaService;
import service.PedidoService;

@Stateless
@Path("/pedido")
public class PedidoRest {

	@Inject
	private PedidoService pedidoService;
	
	@Inject
	private MesaService mesaService;

	public PedidoRest(){}

	@GET
	@Path("info/{idMesa}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> listar(@PathParam("idMesa") int idMesa){
		return pedidoService.findByMesaId(idMesa);
	}

	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPedido(Pedido pedido){
		
		Mesa mesa = mesaService.findById(pedido.getIdMesa());

		if(mesa == null){
			return Response.ok("Id da mesa inválido").build();
		} else {
			mesa.setSituacao("Pedido feito");
			
			mesaService.updateMesa(mesa);
			
			pedido.setMesa( mesa );
			
			pedidoService.adicionarPedido(pedido);
			
			return Response.ok("ok").build();
		}
		
		
	}


}