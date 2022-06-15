package sv.edu.udb.rest.model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.rest.connection.DbConnection;
import sv.edu.udb.rest.constants.DbQuery;
import sv.edu.udb.rest.model.Alumno;
import sv.edu.udb.rest.model.Articulos;
import sv.edu.udb.rest.model.Curso;
import sv.edu.udb.rest.model.RegistroCompras;
import sv.edu.udb.rest.model.Usuarios;
import sv.edu.udb.rest.model.dao.interfaces.Dao;

public class RegistroComprasDao extends DbConnection implements Dao<RegistroCompras>{

	@Override
	public RegistroCompras findById(int id) {
		RegistroCompras regCompras = null;
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.FIND_REGCOMPRAS_BY_ID);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			ArticulosDao artDao = new ArticulosDao();
			UsuariosDao usuDao = new UsuariosDao();
			
			while(rs.next()) {
				regCompras = new RegistroCompras();
				regCompras.setIdregistro(rs.getInt("idregistro"));
				regCompras.setFecha(rs.getDate("fecha").toString());
				regCompras.setConcepto(rs.getString("concepto"));
				regCompras.setPrecioUnit(rs.getDouble("precioUnit"));
				regCompras.setCantidad(rs.getInt("cantidad"));
				
				Articulos art = new Articulos(); // Obtener Articulo
				if(regCompras.getIdArticulo() > 0) {
					art = artDao.findById(regCompras.getIdArticulo());
				}
				regCompras.setArt(art);
				
				Usuarios usu = new Usuarios(); // Obtener Usuario
				if(regCompras.getIdUsuario() > 0) {
					usu = usuDao.findById(regCompras.getIdUsuario());
				}
				regCompras.setUsu(usu);
			}
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return regCompras;
	}

	@Override
	public List<RegistroCompras> findAll() {
		ArrayList<RegistroCompras> regComprasList = new ArrayList<RegistroCompras>();
		ArticulosDao artDao = new ArticulosDao();
		UsuariosDao usuDao = new UsuariosDao();
		try {
			connect();
			st = conn.createStatement();
			rs = st.executeQuery(DbQuery.SELECT_FINDALL_REGCOMPRAS);
			while (rs.next()) {
				RegistroCompras regCompras = new RegistroCompras();
				regCompras.setIdregistro(rs.getInt("idregistro"));
				regCompras.setFecha(rs.getDate("fecha").toString());
				regCompras.setConcepto(rs.getString("concepto"));
				regCompras.setPrecioUnit(rs.getDouble("precioUnit"));
				regCompras.setCantidad(rs.getInt("cantidad"));
				
				Articulos art = new Articulos(); // Obtener Articulo
				if(regCompras.getIdArticulo() > 0) {
					art = artDao.findById(regCompras.getIdArticulo());
				}
				regCompras.setArt(art);
				
				Usuarios usu = new Usuarios(); // Obtener Usuario
				if(regCompras.getIdUsuario() > 0) {
					usu = usuDao.findById(regCompras.getIdUsuario());
				}
				regCompras.setUsu(usu);
				
				regComprasList.add(regCompras);
			}
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return regComprasList;
	}

	@Override
	public void save(RegistroCompras t) {
		try {
			connect();
			pst = this.conn.prepareStatement(DbQuery.INSERT_INTO_REGCOMPRAS, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, t.getIdArticulo());
			pst.setDate(2, Date.valueOf(t.getFecha()));
			pst.setString(3, t.getConcepto());
			pst.setDouble(4, t.getPrecioUnit());
			pst.setInt(5, t.getCantidad());
			pst.setInt(6, t.getIdUsuario());
			
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void update(RegistroCompras t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(RegistroCompras t) {
		// TODO Auto-generated method stub
		
	}

}
