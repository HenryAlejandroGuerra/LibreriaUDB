package sv.edu.udb.rest.model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.rest.connection.DbConnection;
import sv.edu.udb.rest.constants.DbQuery;
import sv.edu.udb.rest.model.Articulos;
import sv.edu.udb.rest.model.dao.interfaces.Dao;

public class ArticulosDao extends DbConnection implements Dao<Articulos> {

	@Override
	public Articulos findById(int id) {
		Articulos art = null;
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.FIND_ARTICULO_BY_ID);
			pst.setInt(1, id);
			
			while(rs.next()) {
				art = new Articulos();
				art.setIdArticulo(rs.getInt("idArticulo"));
				art.setCodigoArticulo(rs.getString("codigoArticulo"));
				art.setNombreArticulo(rs.getString("nombreArticulo"));
				art.setProveedor(rs.getString("proveedor"));
			}
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return art;
	}

	@Override
	public List<Articulos> findAll() {
		ArrayList<Articulos> articulos = new ArrayList<Articulos>();
		try {
			connect();
			st = conn.createStatement();
			rs = st.executeQuery(DbQuery.SELECT_FINDALL_ARTICULO);
			
			while (rs.next()) {
				Articulos art = new Articulos();
				art.setIdArticulo(rs.getInt("idArticulo"));
				art.setCodigoArticulo(rs.getString("codigoArticulo"));
				art.setNombreArticulo(rs.getString("nombreArticulo"));
				art.setProveedor(rs.getString("proveedor"));
				
				articulos.add(art);
			}
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return articulos;
	}

	@Override
	public void save(Articulos t) {
		try {
			connect();
			pst = this.conn.prepareStatement(DbQuery.INSERT_INTO_ARTICULO, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, t.getCodigoArticulo());
			pst.setString(2, t.getNombreArticulo());
			pst.setString(3, t.getProveedor());
			
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void update(Articulos t) {
		try {
			connect();
			pst = this.conn.prepareStatement(DbQuery.UPDATE_ARTICULO);
			pst.setString(1, t.getCodigoArticulo());
			pst.setString(2, t.getNombreArticulo());
			pst.setString(3, t.getProveedor());
			pst.setInt(4, t.getIdArticulo());
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void delete(Articulos t) {
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.DELETE_ARTICULO);
			pst.setInt(1, t.getIdArticulo());
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

}
