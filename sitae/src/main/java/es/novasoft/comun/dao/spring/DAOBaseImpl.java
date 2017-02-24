package es.novasoft.comun.dao.spring;

/**
 * <p>Title: DAOBaseImpl</p>
 * <p>Description: Clase que implementa los metodos para el control de excepciones</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: NovaSoft</p>
 * @author Luis J.
 * @version 1.0
 */

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import es.novasoft.comun.exceptions.DAOException;

public class DAOBaseImpl extends HibernateDaoSupport {

	public static String UNIQUE_VIOLATION_CODE = "23505";

	public static String DELETE_VIOLATION_CODE = "23503";

	public DAOBaseImpl() {
		super();
	}

	/**
	 * Devuelve un objeto persistente a partir de su pk.
	 * 
	 * @param ses,
	 *            session
	 * @param clazz,
	 *            clase del objeto
	 * @param id,
	 *            pk
	 * @return
	 * @throws DAOException
	 */
	protected String getCause(Exception e) throws RuntimeException {
		String className = "";
		Object theClass = null;
		String errorCode;
		String msg = "error.general.sistema";

		// Establecemos la Excepcion que se ha producido
		if (e.getCause() != null) {
			className = e.getCause().getClass().getName();
			theClass = e.getCause();
			if (className.equals("java.rmi.RemoteException")) {
				if (e.getCause().getCause() != null) {
					className = e.getCause().getCause().getClass().getName();
					theClass = e.getCause().getCause();
				}
			}
		}

		if (theClass instanceof JDBCException) {
			if (((org.hibernate.JDBCException) theClass).getSQLException()
					.getNextException() != null) {
				errorCode = ((org.hibernate.JDBCException) theClass)
						.getSQLException().getNextException().getSQLState();
			} else {
				errorCode = ((org.hibernate.JDBCException) theClass)
						.getSQLException().getSQLState();
			}
		} else {
			errorCode = "";
		}

		// Obtenemos el codigo de error

		// Establecemos el mensaje de error en funcion la Excepcion que hemos
		// propagado
		if (!className.equals("")) {
			if (className.equals("org.hibernate.StaleObjectStateException")) {
				msg = "error.message.modify";
			} else if (className.equals("org.hibernate.ObjectDeletedException")) {
				msg = "error.message.delete";
			} else if (className
					.equals("org.hibernate.ObjectNotFoundException")) {
				msg = "error.message.notFound";
			} else if (className.equals("org.hibernate.QueryException")) {
				msg = "error.message.query";
			} else if (className
					.equals("org.hibernate.NonUniqueObjectException")) {
				msg = "error.message.nonUniqueObject";
			} else if (className
					.equals("org.hibernate.NonUniqueResultException")) {
				msg = "error.message.nonUniqueResult";
			} else if (className
					.equals("org.hibernate.PropertyNotFoundException")) {
				msg = "error.message.propertyNotFound";
			} else if (className.equals("org.hibernate.PropertyValueException")) {
				msg = "error.message.propertyValue";
			} else if (className
					.equals("org.hibernate.QueryParameterException")) {
				msg = "error.message.queryParameter";
			} else if (className.equals("org.hibernate.WrongClassException")) {
				msg = "error.message.wrongClass";
			} else if (className
					.equals("org.hibernate.LazyInitializationException")) {
				msg = "error.message.lazyInitialization";
			} else if (className
					.equals("org.hibernate.exception.ConstraintViolationException")) {
				if (errorCode.equalsIgnoreCase(UNIQUE_VIOLATION_CODE)) {
					msg = "error.message.constraintViolationUnique";
				} else if (errorCode.equalsIgnoreCase(DELETE_VIOLATION_CODE)) {
					msg = "error.message.constraintViolationDelete";
				}
			} else if (className
					.equals("org.hibernate.exception.JDBCConnectionException")) {
				msg = "error.message.JDBCConection";
			} else if (className
					.equals("org.hibernate.exception.SQLGrammarException")) {
				msg = "error.message.SQLGrammar";
			} else if (className
					.equals("org.hibernate.hql.ast.QuerySyntaxException")) {
				msg = "error.message.malformedQuery";
			} else if (className.equals("java.sql.BatchUpdateException")) {
				msg = "error.message.metodoTransaccional";
			} else {
				msg = "error.general.sistema";
			}
		} else {
			msg = "error.general.sistema";
		}
		return msg;
	}

	/**
	 * Realiza un flush de la session. Esto sincroniza los datos de la cache con
	 * los de la BBDD. Es necesario ponerlo antes de terminar los metodos
	 * transaccionales dentro del bloque try-catch de forma que en caso se
	 * produzca cualquier tipo de error con la BBDD se pueda controlar esa
	 * excepcion en el servicio y lanzar el rollback y controlar el mensaje.
	 */
	public void flush() {
		getSession().flush();
	}

	public void flushAndClear() throws DAOException {
		try {
			getSession().flush();
			getSession().clear();
		} catch (RuntimeException re) {
			throw new DAOException(re.getMessage(), this.getCause(re));
		}

	}

	public int getCount(String queryString) {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				queryString));
	}

	public List getPaginateList(String querySql, final int startIndex,
			final int rowsPerPage, String orderBySql) {
		if (orderBySql != null) {
			querySql += " " + orderBySql;
		}
		final String queryString = querySql;
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				query.setMaxResults(rowsPerPage);
				query.setFirstResult((startIndex - 1) * rowsPerPage);
				return query.list();
			}
		});

	}

}