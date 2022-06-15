package sv.edu.udb.rest.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Usuarios implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idUsuario;
	private String nombreUser;
	private String contra;
	private String nombre;
	private String apellido;
	private String correo;
	private String cargo;

}
