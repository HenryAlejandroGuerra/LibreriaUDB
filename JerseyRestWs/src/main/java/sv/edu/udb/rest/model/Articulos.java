package sv.edu.udb.rest.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Articulos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idArticulo;
	private String codigoArticulo;
	private String nombreArticulo;
	private String proveedor;

}
