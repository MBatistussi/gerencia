package restful;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.MesaDao;
import domain.Mesa;

@Stateless
@Path("/mesa")
public class MesaRest {

	@Inject MesaDao mesaDao;
	
	public MesaRest() {}
	
	@GET
	@Path("/info/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Mesa listar(@PathParam("id") int id){
		return mesaDao.findById(id);
	}
	
}
