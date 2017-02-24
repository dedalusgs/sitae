package es.novasoft.sitae.business.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.dao.interfaz.ConfiguracionDAO;
import es.novasoft.sitae.business.dao.support.GenericDaoImpl;
import es.novasoft.sitae.business.objects.Configuracion;

public class ConfiguracionDAOImpl extends GenericDaoImpl<Configuracion, String> implements ConfiguracionDAO {

	private static final Log log = LogFactory.getLog(ConfiguracionDAOImpl.class);

	@Override
	public Log log() {

		return log;
	}

	@Override
	public Class<Configuracion> tipoClase() {

		return Configuracion.class;
	}

	public String desencriptar(final Configuracion conf) {

		if (conf.getEncriptada().equalsIgnoreCase("SI")) {

			DataSource dataSource = (DataSource) Factory.getBean("dataSource");
			// dataSource = (DataSource)
			// jndi.lookup("java:comp/env/jdbc/yourname");
			// jndi.
			try {
				Connection con = dataSource.getConnection();
				CallableStatement stmt;
				stmt = con.prepareCall("{? = call cifrado.desencripta(?)}");

				stmt.registerOutParameter(1, Types.VARCHAR);
				stmt.setString(2, conf.getValor());

				stmt.execute();
				String output = stmt.getString(1);
				return output;
			} catch (SQLException sql) {
				log.error("Error desencriptando", sql);
				return null;
			}
			// List ResultList = (List) getHibernateTemplate().execute(new
			// HibernateCallback() {
			//
			// public Object doInHibernate(Session session) throws
			// HibernateException, SQLException {
			// String stringQuery =
			// "select cifrado.desencripta(valor) from configuracion where parametro='"
			// + conf.getParametro() + "';";
			// Query query = session.getNamedQuery("desencriptarParametro");
			// query.setString("s", conf.getParametro());
			// List list = query.list();
			// return list;
			// }
			// });
			// if (ResultList.isEmpty()) {
			// return conf.getValor();
			// } else {
			// String valor = (String) ResultList.get(0);
			// return valor;
			// }
		} else {

			return conf.getValor();
		}
	}

}
