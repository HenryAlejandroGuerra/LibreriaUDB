package sv.edu.udb.rest.model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.rest.connection.DbConnection;
import sv.edu.udb.rest.constants.DbQuery;
import sv.edu.udb.rest.model.Configuracion;
import sv.edu.udb.rest.model.dao.interfaces.Dao;

public class ConfiguracionDao extends DbConnection implements Dao<Configuracion> {

	@Override
	public Configuracion findById(int id) {
		Configuracion conf = null;
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.FIND_CONFIG_BY_ID);
			pst.setInt(1, id);
			
			while(rs.next()) {
				conf = new Configuracion();
				conf.setIdConfig(rs.getInt("idConfig"));
				conf.setConfiguracion(rs.getString("configuracion"));
				conf.setValor(rs.getString("valor"));
				conf.setCargo(rs.getString("cargo"));
			}
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return conf;
	}

	@Override
	public List<Configuracion> findAll() {
		ArrayList<Configuracion> configuraciones = new ArrayList<Configuracion>();
		try {
			connect();
			st = conn.createStatement();
			rs = st.executeQuery(DbQuery.SELECT_FINDALL_CONFIG);
			
			while (rs.next()) {
				Configuracion config = new Configuracion();
				config.setIdConfig(rs.getInt("idConfig"));
				config.setConfiguracion(rs.getString("configuracion"));
				config.setValor(rs.getString("valor"));
				config.setCargo(rs.getString("cargo"));
				
				configuraciones.add(config);
			}
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
		return configuraciones;
	}

	@Override
	public void save(Configuracion t) {
		try {
			connect();
			pst = this.conn.prepareStatement(DbQuery.INSERT_INTO_CONFIG, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, t.getConfiguracion());
			pst.setString(2, t.getValor());
			pst.setString(3, t.getCargo());
			
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void update(Configuracion t) {
		try {
			connect();
			pst = this.conn.prepareStatement(DbQuery.UPDATE_CONFIG);
			pst.setString(1, t.getConfiguracion());
			pst.setString(2, t.getValor());
			pst.setString(3, t.getCargo());
			pst.setInt(4, t.getIdConfig());
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void delete(Configuracion t) {
		try {
			connect();
			pst = conn.prepareStatement(DbQuery.DELETE_CONFIG);
			pst.setInt(1, t.getIdConfig());
			pst.executeUpdate();
			close();
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

}
