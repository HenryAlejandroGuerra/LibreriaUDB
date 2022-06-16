package sv.edu.udb.rest.constants;

public final class DbQuery {
	
	// Query Configuracion
	public static final String FIND_CONFIG_BY_ID = "SELECT * "
			+ "FROM control_libreria.configuracion "
			+ "WHERE idConfig = ?";
	public static final String SELECT_FINDALL_CONFIG = "SELECT * FROM control_libreria.configuracion";
	public static final String INSERT_INTO_CONFIG = "INSERT INTO control_libreria.configuracion(configuracion, valor, cargo) VALUES(?,?,?)";
	public static final String UPDATE_CONFIG = "UPDATE control_libreria.configuracion c"
			+ "SET c.configuracion = ?, c.valor = ?, c.cargo = ?"
			+ "WHERE c.idConfig = ?";
	public static final String DELETE_CONFIG = "DELETE FROM control_libreria.configuracion WHERE idConfig = ?";
	
	// Query Usuarios
	public static final String FIND_USER_BY_ID = "SELECT * "
			+ "FROM control_libreria.usuarios "
			+ "WHERE idUsuario = ?";
	public static final String SELECT_FINDALL_USER = "SELECT * FROM control_libreria.usuarios";
	public static final String INSERT_INTO_USER = "INSERT INTO control_libreria.usuarios(nombreUser, contra, nombre, apellido, correo, cargo) VALUES(?,?,?,?,?,?)";
	public static final String UPDATE_USER = "UPDATE control_libreria.usuarios u"
			+ "SET u.nombreUser = ?, u.contra = ?, u.nombre = ?, u.apellido = ?, u.correo = ?, u.cargo = ?"
			+ "WHERE u.idUsuario = ?";
	public static final String DELETE_USER = "DELETE FROM control_libreria.usuarios WHERE idUsuario = ?";
	public static final String FIND_USER_BY_USER_CONTRA = "SELECT * "
			+ "FROM control_libreria.usuarios "
			+ "WHERE nombreUser = ? AND contra = ?";
	
	// Query Articulos
	public static final String FIND_ARTICULO_BY_ID = "SELECT * "
			+ "FROM control_libreria.articulos "
			+ "WHERE idArticulo = ?";
	public static final String SELECT_FINDALL_ARTICULO = "SELECT * FROM control_libreria.articulos";
	public static final String INSERT_INTO_ARTICULO = "INSERT INTO control_libreria.articulos(codigoArticulo, nombreArticulo, proveedor) VALUES(?,?,?)";
	public static final String UPDATE_ARTICULO = "UPDATE control_libreria.articulos a"
			+ "SET a.codigoArticulo = ?, a.nombreArticulo = ?, a.proveedor = ?"
			+ "WHERE a.idArticulo = ?";
	public static final String DELETE_ARTICULO = "DELETE FROM control_libreria.articulos WHERE idArticulo = ?";
	
	// Query Registro de Compras
	public static final String FIND_REGCOMPRAS_BY_ID = "SELECT * "
			+ "FROM control_libreria.registroCompras "
			+ "WHERE idregistro = ?";
	public static final String SELECT_FINDALL_REGCOMPRAS = "SELECT * FROM control_libreria.registroCompras";
	public static final String INSERT_INTO_REGCOMPRAS = "INSERT INTO control_libreria.registroCompras(idArticulo, fecha, concepto, precioUnit, cantidad, idUsuario) VALUES(?,?,?,?,?,?)";
	public static final String UPDATE_REGCOMPRAS = "UPDATE control_libreria.registroCompras r"
			+ "SET r.idArticulo = ?, r.fecha = ?, r.concepto = ?, r.precioUnit = ?, r.cantidad = ?, r.idUsuario = ?"
			+ "WHERE r.idregistro = ?";
	public static final String DELETE_REGCOMPRAS = "DELETE FROM control_libreria.registroCompras WHERE idArticulo = ?";
	public static final String FIND_REGCOMPRAS_BY_ART = "SELECT * "
			+ "FROM control_libreria.registroCompras r, control_libreria.articulos a"
			+ "WHERE a.idArticulo = ?";
	public static final String FIND_REGCOMPRAS_BY_USUARIO = "SELECT * "
			+ "FROM control_libreria.registroCompras r, control_libreria.usuarios u"
			+ "WHERE u.idUsuario = ?";

}
