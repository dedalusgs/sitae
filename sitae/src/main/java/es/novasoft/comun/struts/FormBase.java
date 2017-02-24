package es.novasoft.comun.struts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorActionForm;

/**
 * @author Pedro Villatoro
 * @date 17-10-2007
 * @version 1.0
 */
public class FormBase extends ValidatorActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String LINE_SEP = System.getProperty("line.separator");

	protected List<Object> list;

	private static ArrayList menuActual = null;

	private static String urlActual = null;

	private static String parametros = null;

	public FormBase() {
		list = new ArrayList<Object>();
	}

	/**
	 * @return
	 */
	public List getList() {
		return list;
	}

	public int getListSize() {
		return this.list.size();
	}

	public ArrayList getMenuActual() {
		return menuActual;
	}

	public void setMenuActual(ArrayList menuActual) {
		FormBase.menuActual = menuActual;
	}

	public String getUrlActual() {
		return urlActual;
	}

	public void setUrlActual(String urlActual) {
		FormBase.urlActual = urlActual;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	public void add(Object o) {
		list.add(o);
	}

	public Object get(int index) {
		return list.get(index);
	}

	public void remove(int index) {
		list.remove(index);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Form: ");
		sb.append(this.getClass().getName());
		sb.append(LINE_SEP);
		return sb.toString();
	}

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		super.reset(arg0, arg1);
	}

}
