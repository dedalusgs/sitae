/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: FechasUtil.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

/**
 * <p>Title: FechasUtil</p>
 * <p>Description: Clase para el manejo de fechas</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: NovaSoft</p>
 *
 * @author Pedro Villatoro
 * @version 1.0
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// TODO: Auto-generated Javadoc
/**
 * Esta clase implementa la conversion de string a fecha y de fecha a string.
 */
public class FechasUtil {

	/** The Constant TYPESDFDate. */
	public static final int TYPESDFDATE = 0;

	/** The Constant TYPESDFDateHour. */
	public static final int TYPESDFDATEHOUR = 1;

	/** The Constant TYPESDFHour. */
	public static final int TYPESDFHOUR = 2;

	/** The Constant TYPESDFDateHourMinSeg. */
	public static final int TYPESDFDATEHOURMINSEG = 3;

	/** The Constant TYPESDFXml. */
	public static final int TYPESDFXML = 4;

	/** The Constant TYPESDFBackup. */
	public static final int TYPESDFBACKUP = 5;

	/** The Constant TYPESDFMonthYear. */
	public static final int TYPESDFMONTHYEAR = 6;
	
	/** The Constant TYPESDFTIMESTAMP. */
	public static final int TYPESDFTIMESTAMP = 7;

	/** The Constant SDFDATE. */
	private static final SimpleDateFormat SDFDATE = new SimpleDateFormat(
			"dd/MM/yyyy");

	/** The Constant SDFDATEHOUR. */
	private static final SimpleDateFormat SDFDATEHOUR = new SimpleDateFormat(
			"dd/MM/yyyy - HH:mm");

	/** The Constant SDFHOUR. */
	private static final SimpleDateFormat SDFHOUR = new SimpleDateFormat(
			"HH:mm");

	/** The Constant SDFDATEHOURMINSEG. */
	private static final SimpleDateFormat SDFDATEHOURMINSEG = new SimpleDateFormat(
			"dd/MM/yyyy - HH:mm:ss");

	/** The Constant SDFXML. */
	private static final SimpleDateFormat SDFXML = new SimpleDateFormat(
			"dd-MM-yyyy - HH:mm:ss");

	/** The Constant SDFBACKUP. */
	private static final SimpleDateFormat SDFBACKUP = new SimpleDateFormat(
			"ddMMyyyy - HH:mm");

	/** The Constant SDFMONTHYEAR. */
	private static final SimpleDateFormat SDFMONTHYEAR = new SimpleDateFormat(
			"MM/yyyy");

	/** The Constant SDFMONTHYEAR. */
	private static final SimpleDateFormat SDFTIMESTAMP = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");
	
	/** The Constant FROM_DATE. */
	private static final String FROM_DATE = " - 00:00:00";

	/** The Constant UNTIL_DATE. */
	private static final String UNTIL_DATE = " - 23:59:59";

	/**
	 * Obtenemos el SimpleDateFormat.
	 * 
	 * @param typeSimpleDateFormat
	 *            the type simple date format
	 * @return the simple date format
	 */
	public static SimpleDateFormat getSimpleDateFormat(int typeSimpleDateFormat) {
		switch (typeSimpleDateFormat) {
		case TYPESDFDATEHOUR:
			return SDFDATEHOUR;
		case TYPESDFHOUR:
			return SDFHOUR;
		case TYPESDFDATEHOURMINSEG:
			return SDFDATEHOURMINSEG;
		case TYPESDFXML:
			return SDFXML;
		case TYPESDFBACKUP:
			return SDFBACKUP;
		case TYPESDFMONTHYEAR:
			return SDFMONTHYEAR;
		case TYPESDFTIMESTAMP:
			return SDFTIMESTAMP;
		default:
			return SDFDATE;
		}

	}

	/**
	 * Paso de una fecha a un String.
	 * 
	 * @param date
	 *            the date
	 * @param typeSimpleDateFormat
	 *            the type simple date format
	 * @return the string
	 */
	public static String convertDateToString(Date date, int typeSimpleDateFormat) {
		SimpleDateFormat sdf;
		try {
			if (date == null) {
				return null;
			} else {
				sdf = getSimpleDateFormat(typeSimpleDateFormat);
				return sdf.format(date);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Paso de una String a una fecha.
	 * 
	 * @param strDate
	 *            the str date
	 * @param typeSimpleDateFormat
	 *            the type simple date format
	 * @return the date
	 */
	public static Date convertStringToDate(String strDate,
			int typeSimpleDateFormat) {
		SimpleDateFormat sdf;
		try {
			sdf = getSimpleDateFormat(typeSimpleDateFormat);
			return sdf.parse(strDate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Método que suma a una fecha dada un numero de dias y retorna la fecha
	 * actualizada.
	 * 
	 * @param dFecha
	 *            the d fecha
	 * @param days
	 *            the days
	 * @return Date fecha sumada los dias
	 */
	public static Date addDays(Date dFecha, int days) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dFecha);
		calendar.add(GregorianCalendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	/**
	 * Método que retorna dada una fecha el dia que se corresponde con la misma
	 * pasaremos un String.
	 * 
	 * @param strDate
	 *            the str date
	 * @return int Dia
	 */
	public static int getDayByDate(String strDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(convertStringToDate(strDate, TYPESDFDATE));
		return calendar.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * Método que retorna dada una fecha el dia que se corresponde con la misma
	 * pasaremos un Date.
	 * 
	 * @param date
	 *            the date
	 * @return int Dia
	 */
	public static int getDayByDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * Método que retorna dada una fecha el Mes que se corresponde con la misma
	 * pasaremos un String.
	 * 
	 * @param strDate
	 *            the str date
	 * @return int Mes
	 */
	public static int getMonthByDate(String strDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(convertStringToDate(strDate, TYPESDFDATE));
		return calendar.get(GregorianCalendar.MONTH) + 1;
	}

	/**
	 * Método que retorna dada una fecha el Mes que se corresponde con la misma
	 * pasaremos un Date.
	 * 
	 * @param date
	 *            the date
	 * @return int Mes
	 */
	public static int getMonthByDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.MONTH) + 1;
	}

	/**
	 * Método que retorna dada una fecha el Mes que se corresponde con la misma
	 * pasaremos un Date.
	 * 
	 * @param date
	 *            the date
	 * @return int Mes
	 */
	public static String getMonthStrByDate(Date date) {
		String mes = "";
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int month = calendar.get(GregorianCalendar.MONTH);
		if (month == Calendar.JANUARY) {
			mes = "Enero";
		} else if (month == Calendar.FEBRUARY) {
			mes = "Febrero";
		} else if (month == Calendar.MARCH) {
			mes = "Marzo";
		} else if (month == Calendar.APRIL) {
			mes = "Abril";
		} else if (month == Calendar.MAY) {
			mes = "Mayo";
		} else if (month == Calendar.JUNE) {
			mes = "Junio";
		} else if (month == Calendar.JULY) {
			mes = "Julio";
		} else if (month == Calendar.AUGUST) {
			mes = "Agosto";
		} else if (month == Calendar.SEPTEMBER) {
			mes = "Septiembre";
		} else if (month == Calendar.OCTOBER) {
			mes = "Octubre";
		} else if (month == Calendar.NOVEMBER) {
			mes = "Noviembre";
		} else if (month == Calendar.DECEMBER) {
			mes = "Diciembre";
		}
		return mes;
	}

	/**
	 * Método que retorna dada una fecha el Anio que se corresponde con la
	 * misma pasaremos un String.
	 * 
	 * @param strDate
	 *            the str date
	 * @return int Anio
	 */
	public static int getYearByDate(String strDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(convertStringToDate(strDate, TYPESDFDATE));
		return calendar.get(GregorianCalendar.YEAR);
	}

	/**
	 * Método que retorna dada una fecha el Anio que se corresponde con la
	 * misma pasaremos un Date.
	 * 
	 * @param date
	 *            the date
	 * @return int Anio
	 */
	public static int getYearByDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.YEAR);
	}

	/**
	 * Método que retorna la fecha actual.
	 * 
	 * @return Date fecha actual
	 */
	public static Date getCurrentDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.getTime();
	}

	/**
	 * Método que retorna la hora del parámetro pasado.
	 * 
	 * @param fecha
	 *            the fecha
	 * @return la hora actual del sistema 0..23
	 */
	public static int getHour(Date fecha) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		return calendar.get(GregorianCalendar.HOUR_OF_DAY);
	}

	/**
	 * Método que retorna los minutos del parámetro pasado.
	 * 
	 * @param fecha
	 *            the fecha
	 * @return los minutos transcurridos de la hora actual
	 */
	public static int getMinutes(Date fecha) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		return calendar.get(GregorianCalendar.MINUTE);
	}

	/**
	 * Devuelve la fecha actual si la fecha es menor si no retorna la que le
	 * viene por parámetro.
	 * 
	 * @param fechaInicial
	 *            the fecha inicial
	 * @return date adecuado
	 */
	public static Date trasnformInitDate(Date fechaInicial) {
		Date fechaAux = fechaInicial;
		if (fechaInicial != null) {
			if (fechaInicial.compareTo(getCurrentDate()) < 0) {
				return getCurrentDate();
			}
		}
		return fechaAux;
	}

	/**
	 * Método que junta una fecha y una hora en un solo Date.
	 * 
	 * @param fecha
	 *            Objeto Date que contiene la fecha.
	 * @param hora
	 *            Objeto Date que contiene la hora.
	 * @return Objeto Date con la fecha y la hora indicadas.
	 */
	public static Date combineDate(Date fecha, Date hora) {
		Calendar calFecha = Calendar.getInstance();
		calFecha.setTime(fecha);
		if (hora != null) {
			Calendar calHora = Calendar.getInstance();
			calHora.setTime(hora);
			calFecha.set(GregorianCalendar.HOUR_OF_DAY, calHora
					.get(GregorianCalendar.HOUR_OF_DAY));
			calFecha.set(GregorianCalendar.MINUTE, calHora
					.get(GregorianCalendar.MINUTE));
			calFecha.set(GregorianCalendar.SECOND, calHora
					.get(GregorianCalendar.SECOND));
		}
		return calFecha.getTime();
	}

	/**
	 * Este método compara dos fechas.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return tru si f1 < f2 false e.o.c
	 */
	public static boolean compareDates(Date date1, Date date2) {
		if ((date1 == null) && (date2 == null)) {
			return false;
		}
		if (date1.compareTo(date2) < 0) {
			return true;
		}
		return false;
	}

	/**
	 * Paso de una fecha a un String.
	 * 
	 * @param date
	 *            the date
	 * @return the date to filter from
	 */
	public static Date getDateToFilterFrom(Date date) {
		SimpleDateFormat sdf;
		String dateStr;
		try {
			if (date == null) {
				return null;
			} else {
				// Obtenemos el fecha en formato String y concatenemos las horas
				sdf = getSimpleDateFormat(TYPESDFDATE);
				dateStr = sdf.format(date);
				dateStr += FROM_DATE;
				// Formateamos con el formato de "dd/MM/yyyy - HH:mm:ss"
				sdf = getSimpleDateFormat(TYPESDFDATEHOURMINSEG);
				return sdf.parse(dateStr);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Paso de una fecha a un String.
	 * 
	 * @param date
	 *            the date
	 * @return the date to filter until
	 */
	public static Date getDateToFilterUntil(Date date) {
		SimpleDateFormat sdf;
		String dateStr;
		try {
			if (date == null) {
				return null;
			} else {
				// Obtenemos el fecha en formato String y concatenemos las horas
				sdf = getSimpleDateFormat(TYPESDFDATE);
				dateStr = sdf.format(date);
				dateStr += UNTIL_DATE;
				// Formateamos con el formato de "dd/MM/yyyy - HH:mm:ss"
				sdf = getSimpleDateFormat(TYPESDFDATEHOURMINSEG);
				return sdf.parse(dateStr);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Método que calcula la diferenia entre dos fechas en horas.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return int número de horas de diferencia entre ambas
	 */
	public static double getDifferenceHours(Date date1, Date date2) {
		// A hours in milliseconds
		long time = 1000 * 3600;
		long dateRange = 0;
		if (compareDates(date1, date2)) {
			dateRange = date2.getTime() - date1.getTime();
		}
		return (double) (dateRange / time);
	}

	/**
	 * Método que calcula la diferencia entre dos fechas en dias.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return double número de horas de diferencia entre ambas
	 */
	public static double getDifferenceByDays(Date date1, Date date2) {
		// A Day in milliseconds
		long time = 1000 * 3600 * 24;
		long dateRange = 0;
		SimpleDateFormat sdf;
		sdf = FechasUtil.getSimpleDateFormat(FechasUtil.TYPESDFDATE);
		Date dateAux = FechasUtil.convertStringToDate(sdf.format(date1),
				FechasUtil.TYPESDFDATE);
		Date dateAux2 = FechasUtil.convertStringToDate(sdf.format(date2),
				FechasUtil.TYPESDFDATE);

		if (compareDates(dateAux, dateAux2)) {
			dateRange = date2.getTime() - date1.getTime();
		}
		return (dateRange / time);
	}

	/**
	 * Método que calcula la diferencia entre dos fechas en semanas.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return double número de horas de diferencia entre ambas
	 */
	public static double getDifferenceByWeeks(Date date1, Date date2) {
		// A Week in milliseconds
		long time = 1000 * 3600 * 24 * 7;
		long dateRange = 0;
		if (compareDates(date1, date2)) {
			dateRange = date2.getTime() - date1.getTime();
		}
		return (dateRange / time);

	}

	/**
	 * Compare dates incidencia.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return the int
	 */
	public static int compareDatesIncidencia(Date date1, Date date2) {
		if (date1.compareTo(date2) > 0) {
			return -1;
		} else if (date1.compareTo(date2) == 0) {
			return 0;
		} else {
			return 1;
		}

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
	}
}
