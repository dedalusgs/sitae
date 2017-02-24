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

/**
 * Esta clase implementa la conversion de string a fecha y de fecha a string
 */
public class FechasUtil {

	public static final int typeSdfDate = 0;

	public static final int typeSdfDateHour = 1;

	public static final int typeSdfHour = 2;

	public static final int typeSdfDateHourMinSeg = 3;

	public static final int typeSdfXml = 4;

	public static final int typeSdfBackup = 5;

	public static final int typeSdfMonthYear = 6;

	private static final SimpleDateFormat sdfDate = new SimpleDateFormat(
			"dd/MM/yyyy");

	private static final SimpleDateFormat sdfDateHour = new SimpleDateFormat(
			"dd/MM/yyyy - HH:mm");

	private static final SimpleDateFormat sdfHour = new SimpleDateFormat(
			"HH:mm");

	private static final SimpleDateFormat sdfDateHourMinSeg = new SimpleDateFormat(
			"dd/MM/yyyy - HH:mm:ss");

	private static final SimpleDateFormat sdfXml = new SimpleDateFormat(
			"dd-MM-yyyy - HH:mm:ss");

	private static final SimpleDateFormat sdfBackup = new SimpleDateFormat(
			"ddMMyyyy - HH:mm");

	private static final SimpleDateFormat sdfMonthYear = new SimpleDateFormat(
			"MM/yyyy");

	private static final String FROM_DATE = " - 00:00:00";

	private static final String UNTIL_DATE = " - 23:59:59";

	/**
	 * Obtenemos el SimpleDateFormat
	 */
	public static SimpleDateFormat getSimpleDateFormat(int typeSimpleDateFormat) {
		switch (typeSimpleDateFormat) {
		case typeSdfDateHour:
			return sdfDateHour;
		case typeSdfHour:
			return sdfHour;
		case typeSdfDateHourMinSeg:
			return sdfDateHourMinSeg;
		case typeSdfXml:
			return sdfXml;
		case typeSdfBackup:
			return sdfBackup;
		case typeSdfMonthYear:
			return sdfMonthYear;
		default:
			return sdfDate;
		}

	}

	/**
	 * Paso de una fecha a un String
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
	 * Paso de una String a una fecha
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
	 * actualizada
	 * 
	 * @param Date
	 *            fecha a la cual queremos sumar la fecha
	 * @param dias
	 *            (dias que queremos sumar a la fecha anterior)
	 * @return Date fecha sumada los dias
	 */
	public static Date addDays(Date dFecha, int days) {
		Calendar calendar = GregorianCalendar.getInstance();

		calendar.setTime(dFecha);
		calendar.add(GregorianCalendar.DAY_OF_MONTH, days);
		
		return calendar.getTime();
	}
	
	public static Date addDaysZeroHour(Date dFecha, int days) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dFecha);
		calendar.add(GregorianCalendar.DAY_OF_MONTH, days);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}
	
	public static Date addYearZeroHour(Date dFecha, int year) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dFecha);
		calendar.add(GregorianCalendar.YEAR, year);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}
	
	/**
	 * Método que retorna dada una fecha el dia que se corresponde con la misma
	 * pasaremos un String
	 * 
	 * @param String
	 *            fecha a la cual queremos obtener el dia
	 * @return int Dia
	 */
	public static int getDayByDate(String strDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(convertStringToDate(strDate, typeSdfDate));
		return calendar.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * Método que retorna dada una fecha el dia que se corresponde con la misma
	 * pasaremos un Date
	 * 
	 * @param String
	 *            fecha a la cual queremos obtener el dia
	 * @return int Dia
	 */
	public static int getDayByDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * Método que retorna dada una fecha el Mes que se corresponde con la misma
	 * pasaremos un String
	 * 
	 * @param String
	 *            fecha a la cual queremos obtener el mes
	 * @return int Mes
	 */
	public static int getMonthByDate(String strDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(convertStringToDate(strDate, typeSdfDate));
		return calendar.get(GregorianCalendar.MONTH) + 1;
	}

	/**
	 * Método que retorna dada una fecha el Mes que se corresponde con la misma
	 * pasaremos un Date
	 * 
	 * @param String
	 *            fecha a la cual queremos obtener el mes
	 * @return int Mes
	 */
	public static int getMonthByDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.MONTH) + 1;
	}

	/**
	 * Método que retorna dada una fecha el Mes que se corresponde con la misma
	 * pasaremos un Date
	 * 
	 * @param String
	 *            fecha a la cual queremos obtener el mes
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
	 * Método que retorna dada una fecha el Anio que se corresponde con la misma
	 * pasaremos un String
	 * 
	 * @param String
	 *            fecha a la cual queremos obtener el Anio
	 * @return int Anio
	 */
	public static int getYearByDate(String strDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(convertStringToDate(strDate, typeSdfDate));
		return calendar.get(GregorianCalendar.YEAR);
	}

	/**
	 * Método que retorna dada una fecha el Anio que se corresponde con la misma
	 * pasaremos un Date
	 * 
	 * @param String
	 *            fecha a la cual queremos obtener el Anio
	 * @return int Anio
	 */
	public static int getYearByDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.YEAR);
	}

	/**
	 * Método que retorna la fecha actual
	 * 
	 * @return Date fecha actual
	 */
	public static Date getCurrentDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.getTime();
	}

	/**
	 * Método que retorna la hora del parámetro pasado
	 * 
	 * @param Date
	 *            con la hora
	 * @return la hora actual del sistema 0..23
	 */
	public static int getHour(Date fecha) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		return calendar.get(GregorianCalendar.HOUR_OF_DAY);
	}

	/**
	 * Método que retorna los minutos del parámetro pasado
	 * 
	 * @param Date
	 *            con el formato adecuado
	 * @return los minutos transcurridos de la hora actual
	 */
	public static int getMinutes(Date fecha) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		return calendar.get(GregorianCalendar.MINUTE);
	}

	/**
	 * Devuelve la fecha actual si la fecha es menor si no retorna la que le
	 * viene por parámetro
	 * 
	 * @param fecha
	 *            inicial Objeto Date.
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
	 * Este método compara dos fechas
	 * 
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
	 * Paso de una fecha a un String
	 */
	public static Date getDateToFilterFrom(Date date) {
		SimpleDateFormat sdf;
		String dateStr;
		try {
			if (date == null) {
				return null;
			} else {
				// Obtenemos el fecha en formato String y concatenemos las horas
				sdf = getSimpleDateFormat(typeSdfDate);
				dateStr = sdf.format(date);
				dateStr += FROM_DATE;
				// Formateamos con el formato de "dd/MM/yyyy - HH:mm:ss"
				sdf = getSimpleDateFormat(typeSdfDateHourMinSeg);
				return sdf.parse(dateStr);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Paso de una fecha a un String
	 */
	public static Date getDateToFilterUntil(Date date) {
		SimpleDateFormat sdf;
		String dateStr;
		try {
			if (date == null) {
				return null;
			} else {
				// Obtenemos el fecha en formato String y concatenemos las horas
				sdf = getSimpleDateFormat(typeSdfDate);
				dateStr = sdf.format(date);
				dateStr += UNTIL_DATE;
				// Formateamos con el formato de "dd/MM/yyyy - HH:mm:ss"
				sdf = getSimpleDateFormat(typeSdfDateHourMinSeg);
				return sdf.parse(dateStr);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Método que calcula la diferenia entre dos fechas en horas
	 * 
	 * @param f1
	 *            fecha inicial
	 * @param f1
	 *            fecha final
	 * @return int número de horas de diferencia entre ambas
	 */
	public static double getDifferenceHours(Date date1, Date date2) {
		// A hours in milliseconds
		long time = 1000 * 3600;
		long dateRange = 0;
		if (compareDates(date1, date2)) {
			dateRange = date2.getTime() - date1.getTime();
		}
		return (dateRange / time);
	}

	/**
	 * Método que calcula la diferencia entre dos fechas en dias
	 * 
	 * @param f1
	 *            fecha inicial
	 * @param f1
	 *            fecha final
	 * @return double número de horas de diferencia entre ambas
	 */
	public static double getDifferenceByDays(Date date1, Date date2) {
		// A Day in milliseconds
		long time = 1000 * 3600 * 24;
		long dateRange = 0;
		SimpleDateFormat sdf;
		sdf = FechasUtil.getSimpleDateFormat(FechasUtil.typeSdfDate);
		date1 = FechasUtil.convertStringToDate(sdf
				.format(date1), FechasUtil.typeSdfDate);
		date2 = FechasUtil.convertStringToDate(sdf
				.format(date2), FechasUtil.typeSdfDate);
		
		if (compareDates(date1, date2)) {
			dateRange = date2.getTime() - date1.getTime();
		}
		return (dateRange / time);
	}

	/**
	 * Método que calcula la diferencia entre dos fechas en semanas
	 * 
	 * @param f1
	 *            fecha inicial
	 * @param f1
	 *            fecha final
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

	public static int compareDatesIncidencia(Date date1, Date date2) {
		if (date1.compareTo(date2) > 0) {
			return -1;
		} else if (date1.compareTo(date2) == 0) {
			return 0;
		} else {
			return 1;
		}

	}

	public static void main(String[] args) {
	}

	public static String getMonthStrByDateVa(Date date) {
		String mes = "";
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int month = calendar.get(GregorianCalendar.MONTH);
		if (month == Calendar.JANUARY) {
			mes = "de Gener";
		} else if (month == Calendar.FEBRUARY) {
			mes = "de Febrer";
		} else if (month == Calendar.MARCH) {
			mes = "de Març";
		} else if (month == Calendar.APRIL) {
			mes = "d'Abril";
		} else if (month == Calendar.MAY) {
			mes = "de Maig";
		} else if (month == Calendar.JUNE) {
			mes = "de Juny";
		} else if (month == Calendar.JULY) {
			mes = "de Julio";
		} else if (month == Calendar.AUGUST) {
			mes = "d'Agost";
		} else if (month == Calendar.SEPTEMBER) {
			mes = "de Setembre";
		} else if (month == Calendar.OCTOBER) {
			mes = "d'Octubre";
		} else if (month == Calendar.NOVEMBER) {
			mes = "de Novembre";
		} else if (month == Calendar.DECEMBER) {
			mes = "de Desembre";
		}
		return mes;
	}
}
