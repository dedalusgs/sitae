/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: DAOBaseImpl.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class DAOBaseImpl.
 */
public class DAOBaseImpl extends HibernateDaoSupport {

	/** The UNIQU e_ violatio n_ code. */
	public static final String UNIQUE_VIOLATION_CODE = "23505";

	/** The DELET e_ violatio n_ code. */
	public static final String DELETE_VIOLATION_CODE = "23503";

	/**
	 * Instantiates a new dAO base impl.
	 */
	public DAOBaseImpl() {
		super();
	}

	/**
	 * Devuelve un objeto persistente a partir de su pk.
	 * 
	 * @param e
	 *            the e
	 * @return the cause
	 * @throws RuntimeException
	 *             the runtime exception
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

	/**
	 * Flush and clear.
	 * 
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void flushAndClear() throws DAOException {
		try {
			getSession().flush();
			getSession().clear();
		} catch (RuntimeException re) {
			throw new DAOException(re.getMessage(), this.getCause(re));
		}

	}

	/**
	 * Gets the count.
	 * 
	 * @param queryString
	 *            the query string
	 * @return the count
	 */
	public int getCount(String queryString) {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				queryString));
	}

	/**
	 * Gets the paginate list.
	 * 
	 * @param querySql
	 *            the query sql
	 * @param startIndex
	 *            the start index
	 * @param rowsPerPage
	 *            the rows per page
	 * @param orderBySql
	 *            the order by sql
	 * @return the paginate list
	 */
	public List getPaginateList(String querySql, final int startIndex,
			final int rowsPerPage, String orderBySql) {
		String queryAux = querySql;
		if (orderBySql != null) {
			queryAux += " " + orderBySql;
		}
		final String queryString = queryAux;
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws SQLException {
				Query query = session.createQuery(queryString);
				query.setMaxResults(rowsPerPage);
				query.setFirstResult((startIndex - 1) * rowsPerPage);
				return query.list();
			}
		});

	}

}