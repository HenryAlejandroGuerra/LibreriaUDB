package sv.edu.udb.rest.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistroCompras implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idregistro;
	private int idArticulo;
	private String fecha;
	private String concepto;
	private double precioUnit;
	private int cantidad;
	private int idUsuario;
	private Usuarios usu;
	private Articulos art;
	private List<Usuarios> usuarios;
	private List<Articulos> articulos;

}
