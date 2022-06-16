package sv.edu.udb.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sv.edu.udb.rest.model.Usuarios;
import sv.edu.udb.rest.model.dao.UsuariosDao;
import sv.edu.udb.rest.model.dto.ResponseEntity;

@Path("usuarios")
public class UsuariosService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		List<Usuarios> usu = new ArrayList<Usuarios>();
		try {
			UsuariosDao userDAO = new UsuariosDao();
			usu = userDAO.findAll();
			
			if(usu.isEmpty()) {
				return Response.status(Status.NOT_FOUND.getStatusCode())
						.entity(new ResponseEntity(Status.NOT_FOUND.getStatusCode(),
								"Recurso no encontrado"))
						.build();
			}
			
			
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		
		return Response.status(Status.OK.getStatusCode()).entity(usu).build();
	}
	

	@GET
	@Path("/byId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response usuariosFindById(@PathParam("id") int id) {
		Usuarios usu = null;

		try {
			UsuariosDao userDAO = new UsuariosDao();
			usu = userDAO.findById(id);

			if (usu == null) {
				return Response.status(Status.NOT_FOUND.getStatusCode())
						.entity(new ResponseEntity(Status.NOT_FOUND.getStatusCode(), "Recurso no encontrado")).build();
			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return Response.status(Status.OK.getStatusCode()).entity(usu).build();
	}
	
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response usuariosLogin(@FormParam("userName") String userName, @FormParam("contra") String contra) {
		Usuarios usu = null;

		try {
			UsuariosDao userDAO = new UsuariosDao();
			usu = userDAO.findByUserContra(userName, contra);

			if (usu == null) {
				return Response.status(Status.NOT_FOUND.getStatusCode())
						.entity(new ResponseEntity(Status.NOT_FOUND.getStatusCode(), "Recurso no encontrado")).build();
			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return Response.status(Status.OK.getStatusCode()).entity(usu).build();
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response newUsuario(@FormParam("nombreUser") String nombreUser, @FormParam("contra") String contra, 
			@FormParam("nombre") String nombre, @FormParam("apellido") String apellido, 
			@FormParam("correo") String correo, @FormParam("cargo") String cargo) {
		Usuarios usu = new Usuarios();
		try {

			UsuariosDao userDAO = new UsuariosDao();

			if (nombreUser != null && contra != null) {

				usu.setNombre(nombreUser);
				usu.setContra(contra);
				usu.setNombre(nombre);
				usu.setApellido(apellido);
				usu.setCorreo(correo);
				usu.setCargo(cargo);
				
				userDAO.save(usu);
			}

		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}

		return Response.status(Status.CREATED.getStatusCode()).entity(usu).build();
	}
	
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuario(@FormParam("idUsuario") int idUsuario, @FormParam("nombreUser") String nombreUser, 
			@FormParam("contra") String contra, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, 
			@FormParam("correo") String correo, @FormParam("cargo") String cargo) {
		Usuarios usu = new Usuarios();
		try {

			UsuariosDao userDAO = new UsuariosDao();

			if (nombreUser != null && contra != null) {

				usu.setIdUsuario(idUsuario);
				usu.setNombre(nombreUser);
				usu.setContra(contra);
				usu.setNombre(nombre);
				usu.setApellido(apellido);
				usu.setCorreo(correo);
				usu.setCargo(cargo);
				
				userDAO.update(usu);
			}

		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}

		return Response.status(Status.CREATED.getStatusCode()).entity(usu).build();
	}
	
	@DELETE
	@Path("/delete/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCurso(@PathParam("idUsuario") int idUsuario) {
		Usuarios usu = null;
		try {
			UsuariosDao userDAO = new UsuariosDao();

			usu = userDAO.findById(idUsuario);

			if (usu == null)
				return Response.status(Status.NOT_FOUND.getStatusCode())
						.entity(new ResponseEntity(Status.NOT_FOUND.getStatusCode(),
								"No existen registros para el Curso con id {" + idUsuario + "}"))
						.build();

			// Si existe, eliminar el recurso
			userDAO.delete(usu);

		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}

		return Response.status(Status.OK.getStatusCode()).entity(usu).build();
	}
	
}
