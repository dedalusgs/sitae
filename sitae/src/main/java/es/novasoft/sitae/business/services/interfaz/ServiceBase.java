package es.novasoft.sitae.business.services.interfaz;

/**
 * <p>
 * Title: ServiceBase
 * </p>
 * <p>
 * Description: Clase que implementa los metodos para el control de excepciones
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: NovaSoft
 * </p>
 * Versión 1.1 :: Adis Ferusic, adaptación para proyecto del Parque de Bomberos
 * de Motril <br>
 * 
 * @author Juan Diego Trujillo.
 * @version 1.1
 */

// import es.novasoft.comun.exceptions.DAOException;
import java.sql.SQLException;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;

public class ServiceBase {

	// public static String UNIQUE_VIOLATION_CODE = "23503"; //ORACLE

	// public static String DELETE_VIOLATION_CODE = "23000";

	public static String INTEGRIDAD_VIOLATION_CODE = "23000";// POSTGREsql

	public static String UQ_VIOLATION_CODE = "23505";

	public static String NN_VIOLATION_CODE = "23502";

	public static String FK_VIOLATION_CODE = "23503";

	public static String CK_VIOLATION_CODE = "23514";

	public static String TR_VIOLATION_CODE = "27000";

	public static String TR_ACTION_EXC = "09000";

	public static String TR_VIOLATION_1 = "38000";

	public static String TR_VIOLATION_2 = "39000";

	public static String TR_ERR = "P0000";

	public static String TR_RAISE = "P0001";

	public ServiceBase() {
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
	protected String getCause(Exception e) throws ServiceException {
		String className = "";
		Object theClass = null;

		String msg = "error.general.sistema";
		String causaClase = "";
		String errorCode;

		if (e.getCause() != null) {
			causaClase = e.getCause().getClass().toString();
		}

		// Establecemos la Excepcion que se ha producido
		if (e.getCause() != null
				&& causaClase
						.equals("class org.hibernate.exception.ConstraintViolationException")
				|| causaClase
						.equals("class org.hibernate.PropertyValueException")) {
			className = e.getCause().getClass().getName();
			theClass = e.getCause();

		} else if (e.getCause() != null
				&& causaClase.equals("class java.sql.BatchUpdateException")) {
			className = e.getClass().getName();
			theClass = e.getCause();
		}

		if (className.equals("java.rmi.RemoteException")) {
			if (e.getCause().getCause() != null) {
				className = e.getCause().getCause().getClass().getName();
				theClass = e.getCause().getCause();
			}
		}

		// Obtenemos el codigo de error

		if (className
				.equals("org.springframework.jdbc.UncategorizedSQLException")) {// triggers
																				// plgsql
			errorCode = ((SQLException) theClass).getNextException()
					.getSQLState();
			msg = ((SQLException) theClass).getNextException().getMessage();
		} else if (((org.hibernate.JDBCException) theClass).getSQLException()
				.getNextException() != null) {
			errorCode = ((org.hibernate.JDBCException) theClass)
					.getSQLException().getNextException().getSQLState();
		} else {
			errorCode = ((org.hibernate.JDBCException) theClass)
					.getSQLException().getSQLState();
		}

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
					.equals("org.hibernate.exception.ConstraintViolationException")
					|| className
							.equals("org.springframework.jdbc.UncategorizedSQLException")) {
				if (errorCode.equalsIgnoreCase(UQ_VIOLATION_CODE)) {
					msg = "error.message.constraintViolationUnique";
				} else if (errorCode
						.equalsIgnoreCase(INTEGRIDAD_VIOLATION_CODE)) {
					msg = "error.message.constraintViolationDelete";
				} else if (errorCode.equalsIgnoreCase(NN_VIOLATION_CODE)) {
					msg = "error.message.constraintViolationNotNull";
				} else if (errorCode.equalsIgnoreCase(FK_VIOLATION_CODE)) {
					msg = "error.message.constraintViolationForeignKey";
				} else if (errorCode.equalsIgnoreCase(CK_VIOLATION_CODE)) {
					msg = "error.message.constraintViolationCheck";
				} else if (errorCode.equalsIgnoreCase(TR_RAISE)
						|| errorCode.equalsIgnoreCase(TR_VIOLATION_CODE)
						|| errorCode.equalsIgnoreCase(TR_ACTION_EXC)
						|| errorCode.equalsIgnoreCase(TR_VIOLATION_1)
						|| errorCode.equalsIgnoreCase(TR_VIOLATION_2)) {
					if (msg == null) {
						msg = "error.message.triggerError";
					} else {
						msg = "#" + msg;
					}
				} else if (errorCode.equalsIgnoreCase(TR_ERR)) {
					msg = "error.message.triggerError";
				} else {
					msg = "error.message.constraintViolationGeneric";
				}
			} else if (className
					.equals("org.hibernate.exception.JDBCConnectionException")) {
				msg = "error.message.JDBCConection";
			} else if (className
					.equals("org.hibernate.exception.SQLGrammarException")) {
				msg = "error.message.SQLGrammar";
			} else {
				msg = "error.general.sistema";
			}
		} else {
			msg = "error.general.sistema";
		}
		return msg;
	}

}
