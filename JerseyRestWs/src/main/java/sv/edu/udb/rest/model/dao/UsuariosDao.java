package sv.edu.udb.rest.model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.rest.connection.DbConnection;
import sv.edu.udb.rest.constants.DbQuery;
import sv.edu.udb.rest.model.Usuarios;
import sv.edu.udb.rest.model.dao.interfaces.Dao;

public class UsuariosDao extends DbConnection implements Dao<Usuarios> {

	@Override
	public Usuarios findById(int id) {
		Usuarios usuario = null;
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.FIND_USER_BY_ID);
			pst.setInt(1, id);
			
			while(rs.next()) {
				usuario = new Usuarios();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNombreUser(rs.getString("nombreUser"));
				usuario.setContra(rs.getString("contra"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setCargo(rs.getString("cargo"));
			}
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return usuario;
	}

	@Override
	public List<Usuarios> findAll() {
		ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
		try {
			connect();
			st = conn.createStatement();
			rs = st.executeQuery(DbQuery.SELECT_FINDALL_USER);
			
			while (rs.next()) {
				Usuarios usuario = new Usuarios();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNombreUser(rs.getString("nombreUser"));
				usuario.setContra(rs.getString("contra"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setCargo(rs.getString("cargo"));
				
				usuarios.add(usuario);
			}
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return usuarios;
	}

	@Override
	public void save(Usuarios t) {
		try {
			connect();
			pst = this.conn.prepareStatement(DbQuery.INSERT_INTO_USER, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, t.getNombreUser());
			pst.setString(2, t.getContra());
			pst.setString(3, t.getNombre());
			pst.setString(4, t.getApellido());
			pst.setString(5, t.getCorreo());
			pst.setString(6, t.getCargo());
			
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void update(Usuarios t) {
		try {
			connect();
			pst = this.conn.prepareStatement(DbQuery.UPDATE_USER);
			pst.setString(1, t.getNombreUser());
			pst.setString(2, t.getContra());
			pst.setString(3, t.getNombre());
			pst.setString(4, t.getApellido());
			pst.setString(5, t.getCorreo());
			pst.setString(6, t.getCargo());
			pst.setInt(7, t.getIdUsuario());
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void delete(Usuarios t) {
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.DELETE_USER);
			pst.setInt(1, t.getIdUsuario());
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public Usuarios findByUserContra(String userName, String contra) {
		Usuarios usuario = null;
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.FIND_USER_BY_ID);
			pst.setString(1, userName);
			pst.setString(2, contra);
			
			while(rs.next()) {
				usuario = new Usuarios();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNombreUser(rs.getString("nombreUser"));
				usuario.setContra(rs.getString("contra"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setCargo(rs.getString("cargo"));
			}
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return usuario;
	}

}
