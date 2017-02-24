package es.novasoft.comun.constantes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.PropertyConverter;
import org.apache.commons.logging.LogFactory;

/**
 * Configuration stored in a database. The properties are retrieved from a table
 * containing at least one column for the keys, and one column for the values.
 * It's possible to store several configurations in the same table by adding a
 * column containing the name of the configuration. The name of the table and
 * the columns is specified in the constructor.
 *
 * <h4>Example 1 - One configuration per table</h4>
 *
 * <pre>
 * CREATE TABLE myconfig (
 *     `key`   VARCHAR NOT NULL PRIMARY KEY,
 *     `value` VARCHAR
 * );
 * 
 * INSERT INTO myconfig (key, value) VALUES ('foo', 'bar');
 * 
 * 
 * Configuration config = new DatabaseConfiguration(datasource, "myconfig", "key", "value");
 * String value = config.getString("foo");
 * </pre>
 *
 * <h4>Example 2 - Multiple configurations per table</h4>
 *
 * <pre>
 * CREATE TABLE myconfigs (
 *     `name`  VARCHAR NOT NULL,
 *     `key`   VARCHAR NOT NULL,
 *     `value` VARCHAR,
 *     CONSTRAINT sys_pk_myconfigs PRIMARY KEY (`name`, `key`)
 * );
 * 
 * INSERT INTO myconfigs (name, key, value) VALUES ('config1', 'key1', 'value1');
 * INSERT INTO myconfigs (name, key, value) VALUES ('config2', 'key2', 'value2');
 * 
 * 
 * Configuration config1 = new DatabaseConfiguration(datasource, "myconfigs", "name", "key", "value", "config1");
 * String value1 = conf.getString("key1");
 * 
 * Configuration config2 = new DatabaseConfiguration(datasource, "myconfigs", "name", "key", "value", "config2");
 * String value2 = conf.getString("key2");
 * </pre>
 * 
 * The configuration can be instructed to perform commits after database
 * updates. This is achieved by setting the {@code commits} parameter of the
 * constructors to <b>true</b>. If commits should not be performed (which is the
 * default behavior), it should be ensured that the connections returned by the
 * {@code DataSource} are in auto-commit mode.
 *
 * <h1>Note: Like JDBC itself, protection against SQL injection is left to the
 * user.</h1>
 * 
 * @since 1.0
 *
 * @author <a href="mailto:ebourg@apache.org">Emmanuel Bourg</a>
 * @version $Id: DatabaseConfiguration.java 1344442 2012-05-30 20:17:35Z oheger
 *          $
 */
public class DatabaseConfigurationCustom extends AbstractConfiguration {
	/** The datasource to connect to the database. */
	protected DataSource	datasource;
	
	/** The name of the table containing the configurations. */
	protected String	  table;
	
	/** The column containing the name of the configuration. */
	protected String	  nameColumn;
	
	/** The column containing the keys. */
	protected String	  keyColumn;
	
	/** The column containing the values. */
	protected String	  valueColumn;
	
	/** The column type encripting */
	protected String	  encriptColumn;
	
	/** The name of the configuration. */
	protected String	  name;
	
	/** A flag whether commits should be performed by this configuration. */
	protected boolean	  doCommits;
	
	private static String	ENCRIPTADA	= "SI";
	
	/**
	 * Creates a new instance of {@code DatabaseConfiguration} that operates on
	 * a database table containing multiple configurations.
	 *
	 * @param datasource
	 *            the {@code DataSource} to connect to the database
	 * @param table
	 *            the name of the table containing the configurations
	 * @param nameColumn
	 *            the column containing the name of the configuration
	 * @param keyColumn
	 *            the column containing the keys of the configuration
	 * @param valueColumn
	 *            the column containing the values of the configuration
	 * @param name
	 *            the name of the configuration
	 * @param commits
	 *            a flag whether the configuration should perform a commit after
	 *            a database update
	 */
	public DatabaseConfigurationCustom(DataSource datasource, String table, String nameColumn, String keyColumn, String valueColumn, String name, boolean commits,
	        String encriptColumn) {
		this.datasource = datasource;
		this.table = table;
		this.nameColumn = nameColumn;
		this.keyColumn = keyColumn;
		this.valueColumn = valueColumn;
		this.name = name;
		doCommits = commits;
		this.encriptColumn = encriptColumn;
		setLogger(LogFactory.getLog(getClass()));
		addErrorLogListener();  // log errors per default
	}
	
	/**
	 * Build a configuration from a table.
	 *
	 * @param datasource
	 *            the datasource to connect to the database
	 * @param table
	 *            the name of the table containing the configurations
	 * @param keyColumn
	 *            the column containing the keys of the configuration
	 * @param valueColumn
	 *            the column containing the values of the configuration
	 */
	public DatabaseConfigurationCustom(DataSource datasource, String table, String keyColumn, String valueColumn, String encriptColumn) {
		this.datasource = datasource;
		this.table = table;
		this.nameColumn = null;
		this.keyColumn = keyColumn;
		this.valueColumn = valueColumn;
		this.name = name;
		doCommits = false;
		this.encriptColumn = encriptColumn;
		setLogger(LogFactory.getLog(getClass()));
		addErrorLogListener();  // log errors per default
	}
	
	/**
	 * Creates a new instance of {@code DatabaseConfiguration} that operates on
	 * a database table containing a single configuration only.
	 *
	 * @param datasource
	 *            the {@code DataSource} to connect to the database
	 * @param table
	 *            the name of the table containing the configurations
	 * @param keyColumn
	 *            the column containing the keys of the configuration
	 * @param valueColumn
	 *            the column containing the values of the configuration
	 * @param commits
	 *            a flag whether the configuration should perform a commit after
	 *            a database update
	 */
	
	/**
	 * Returns a flag whether this configuration performs commits after database
	 * updates.
	 *
	 * @return a flag whether commits are performed
	 */
	public boolean isDoCommits() {
		return doCommits;
	}
	
	/**
	 * Returns the value of the specified property. If this causes a database
	 * error, an error event will be generated of type
	 * {@code EVENT_READ_PROPERTY} with the causing exception. The event's
	 * {@code propertyName} is set to the passed in property key, the
	 * {@code propertyValue} is undefined.
	 *
	 * @param key
	 *            the key of the desired property
	 * @return the value of this property
	 */
	public Object getProperty(String key) {
		Object result = null;
		
		// build the query
		StringBuilder query = new StringBuilder("SELECT * FROM ");
		query.append(table).append(" WHERE ");
		query.append(keyColumn).append("=?");
		if (nameColumn != null) {
			query.append(" AND " + nameColumn + "=?");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, key);
			if (nameColumn != null) {
				pstmt.setString(2, name);
			}
			
			rs = pstmt.executeQuery();
			
			List<Object> results = new ArrayList<Object>();
			while (rs.next()) {
				Object value = rs.getObject(valueColumn);
				String encriptada = (rs.getObject(encriptColumn)).toString();
				if (encriptada.equalsIgnoreCase(ENCRIPTADA)) {
					conn = getConnection();
					CallableStatement stmt;
					stmt = conn.prepareCall("{? = call cifrado.desencripta(?)}");
					
					stmt.registerOutParameter(1, Types.VARCHAR);
					stmt.setString(2, value.toString());
					
					stmt.execute();
					String output = stmt.getString(1);
					results.add(output);
				} else {
					if (isDelimiterParsingDisabled()) {
						results.add(value);
					} else {
						// Split value if it contains the list delimiter
						Iterator<?> it = PropertyConverter.toIterator(value, getListDelimiter());
						while (it.hasNext()) {
							results.add(it.next());
						}
					}
				}
			}
			
			if (!results.isEmpty()) {
				result = (results.size() > 1) ? results : results.get(0);
			}
		} catch (SQLException e) {
			fireError(EVENT_READ_PROPERTY, key, null, e);
		} finally {
			close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	/**
	 * Adds a property to this configuration. If this causes a database error,
	 * an error event will be generated of type {@code EVENT_ADD_PROPERTY} with
	 * the causing exception. The event's {@code propertyName} is set to the
	 * passed in property key, the {@code propertyValue} points to the passed in
	 * value.
	 *
	 * @param key
	 *            the property key
	 * @param obj
	 *            the value of the property to add
	 */
	@Override
	protected void addPropertyDirect(String key, Object obj) {
		// build the query
		StringBuilder query = new StringBuilder("INSERT INTO " + table);
		if (nameColumn != null) {
			query.append(" (" + nameColumn + ", " + keyColumn + ", " + valueColumn + ") VALUES (?, ?, ?)");
		} else {
			query.append(" (" + keyColumn + ", " + valueColumn + ") VALUES (?, ?)");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			int index = 1;
			if (nameColumn != null) {
				pstmt.setString(index++, name);
			}
			pstmt.setString(index++, key);
			pstmt.setString(index++, String.valueOf(obj));
			
			pstmt.executeUpdate();
			commitIfRequired(conn);
		} catch (SQLException e) {
			fireError(EVENT_ADD_PROPERTY, key, obj, e);
		} finally {
			// clean up
			close(conn, pstmt, null);
		}
	}
	
	/**
	 * Adds a property to this configuration. This implementation will
	 * temporarily disable list delimiter parsing, so that even if the value
	 * contains the list delimiter, only a single record will be written into
	 * the managed table. The implementation of {@code getProperty()} will take
	 * care about delimiters. So list delimiters are fully supported by
	 * {@code DatabaseConfiguration}, but internally treated a bit differently.
	 *
	 * @param key
	 *            the key of the new property
	 * @param value
	 *            the value to be added
	 */
	@Override
	public void addProperty(String key, Object value) {
		boolean parsingFlag = isDelimiterParsingDisabled();
		try {
			if (value instanceof String) {
				// temporarily disable delimiter parsing
				setDelimiterParsingDisabled(true);
			}
			super.addProperty(key, value);
		} finally {
			setDelimiterParsingDisabled(parsingFlag);
		}
	}
	
	/**
	 * Checks if this configuration is empty. If this causes a database error,
	 * an error event will be generated of type {@code EVENT_READ_PROPERTY} with
	 * the causing exception. Both the event's {@code propertyName} and
	 * {@code propertyValue} will be undefined.
	 *
	 * @return a flag whether this configuration is empty.
	 */
	public boolean isEmpty() {
		boolean empty = true;
		
		// build the query
		StringBuilder query = new StringBuilder("SELECT count(*) FROM " + table);
		if (nameColumn != null) {
			query.append(" WHERE " + nameColumn + "=?");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			if (nameColumn != null) {
				pstmt.setString(1, name);
			}
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				empty = rs.getInt(1) == 0;
			}
		} catch (SQLException e) {
			fireError(EVENT_READ_PROPERTY, null, null, e);
		} finally {
			// clean up
			close(conn, pstmt, rs);
		}
		
		return empty;
	}
	
	/**
	 * Checks whether this configuration contains the specified key. If this
	 * causes a database error, an error event will be generated of type
	 * {@code EVENT_READ_PROPERTY} with the causing exception. The event's
	 * {@code propertyName} will be set to the passed in key, the
	 * {@code propertyValue} will be undefined.
	 *
	 * @param key
	 *            the key to be checked
	 * @return a flag whether this key is defined
	 */
	public boolean containsKey(String key) {
		boolean found = false;
		
		// build the query
		StringBuilder query = new StringBuilder("SELECT * FROM " + table + " WHERE " + keyColumn + "=?");
		if (nameColumn != null) {
			query.append(" AND " + nameColumn + "=?");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, key);
			if (nameColumn != null) {
				pstmt.setString(2, name);
			}
			
			rs = pstmt.executeQuery();
			
			found = rs.next();
		} catch (SQLException e) {
			fireError(EVENT_READ_PROPERTY, key, null, e);
		} finally {
			// clean up
			close(conn, pstmt, rs);
		}
		
		return found;
	}
	
	/**
	 * Removes the specified value from this configuration. If this causes a
	 * database error, an error event will be generated of type
	 * {@code EVENT_CLEAR_PROPERTY} with the causing exception. The event's
	 * {@code propertyName} will be set to the passed in key, the
	 * {@code propertyValue} will be undefined.
	 *
	 * @param key
	 *            the key of the property to be removed
	 */
	@Override
	protected void clearPropertyDirect(String key) {
		// build the query
		StringBuilder query = new StringBuilder("DELETE FROM " + table + " WHERE " + keyColumn + "=?");
		if (nameColumn != null) {
			query.append(" AND " + nameColumn + "=?");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, key);
			if (nameColumn != null) {
				pstmt.setString(2, name);
			}
			
			pstmt.executeUpdate();
			commitIfRequired(conn);
		} catch (SQLException e) {
			fireError(EVENT_CLEAR_PROPERTY, key, null, e);
		} finally {
			// clean up
			close(conn, pstmt, null);
		}
	}
	
	/**
	 * Removes all entries from this configuration. If this causes a database
	 * error, an error event will be generated of type {@code EVENT_CLEAR} with
	 * the causing exception. Both the event's {@code propertyName} and the
	 * {@code propertyValue} will be undefined.
	 */
	@Override
	public void clear() {
		fireEvent(EVENT_CLEAR, null, null, true);
		// build the query
		StringBuilder query = new StringBuilder("DELETE FROM " + table);
		if (nameColumn != null) {
			query.append(" WHERE " + nameColumn + "=?");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			if (nameColumn != null) {
				pstmt.setString(1, name);
			}
			
			pstmt.executeUpdate();
			commitIfRequired(conn);
		} catch (SQLException e) {
			fireError(EVENT_CLEAR, null, null, e);
		} finally {
			// clean up
			close(conn, pstmt, null);
		}
		fireEvent(EVENT_CLEAR, null, null, false);
	}
	
	/**
	 * Returns an iterator with the names of all properties contained in this
	 * configuration. If this causes a database error, an error event will be
	 * generated of type {@code EVENT_READ_PROPERTY} with the causing exception.
	 * Both the event's {@code propertyName} and the {@code propertyValue} will
	 * be undefined.
	 * 
	 * @return an iterator with the contained keys (an empty iterator in case of
	 *         an error)
	 */
	public Iterator<String> getKeys() {
		Collection<String> keys = new ArrayList<String>();
		
		// build the query
		StringBuilder query = new StringBuilder("SELECT DISTINCT " + keyColumn + " FROM " + table);
		if (nameColumn != null) {
			query.append(" WHERE " + nameColumn + "=?");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			if (nameColumn != null) {
				pstmt.setString(1, name);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				keys.add(rs.getString(1));
			}
		} catch (SQLException e) {
			fireError(EVENT_READ_PROPERTY, null, null, e);
		} finally {
			// clean up
			close(conn, pstmt, rs);
		}
		
		return keys.iterator();
	}
	
	/**
	 * Returns the used {@code DataSource} object.
	 *
	 * @return the data source
	 * @since 1.4
	 */
	public DataSource getDatasource() {
		return datasource;
	}
	
	/**
	 * Returns a {@code Connection} object. This method is called when ever the
	 * database is to be accessed. This implementation returns a connection from
	 * the current {@code DataSource}.
	 *
	 * @return the {@code Connection} object to be used
	 * @throws SQLException
	 *             if an error occurs
	 * @since 1.4
	 * @deprecated Use a custom data source to change the connection used by the
	 *             class. To be removed in Commons Configuration 2.0
	 */
	@Deprecated
	protected Connection getConnection() throws SQLException {
		return getDatasource().getConnection();
	}
	
	/**
	 * Close the specified database objects. Avoid closing if null and hide any
	 * SQLExceptions that occur.
	 *
	 * @param conn
	 *            The database connection to close
	 * @param stmt
	 *            The statement to close
	 * @param rs
	 *            the result set to close
	 */
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			getLogger().error("An error occurred on closing the result set", e);
		}
		
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			getLogger().error("An error occured on closing the statement", e);
		}
		
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			getLogger().error("An error occured on closing the connection", e);
		}
	}
	
	/**
	 * Performs a commit if needed. This method is called after updates of the
	 * managed database table. If the configuration should perform commits, it
	 * does so now.
	 *
	 * @param conn
	 *            the active connection
	 * @throws SQLException
	 *             if an error occurs
	 */
	private void commitIfRequired(Connection conn) throws SQLException {
		if (isDoCommits()) {
			conn.commit();
		}
	}
}
