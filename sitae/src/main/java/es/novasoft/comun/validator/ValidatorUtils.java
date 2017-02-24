package es.novasoft.comun.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {

	/**
	 * Variables y métodos get y set necesarios para realizar el control de los
	 * campos del formularios
	 */
	/* Caracteres válidos */
	private static String caracteresValidos = "[A-Z|a-z|º|ª|ñ|Ñ|á|é|í|ó|ä|ë|ö|ü|ç|à|è|ì|ò|ù]";

	/* Caracteres parentesis y + */
	private static String signosValidos = "[(|)|+]";

	/* Caracteres válidos para control de usuarios */
	private static String caracteresValidosUsuario = "[A-Z|a-z|0-9|ñ|Ñ|á|é|í|ó|ä|ë|ö|ü|ç|à|è|ì|ò|ù]";

	/* Caracteres inválidos */
	private static String caracteresInvalidos = "[\\\\¨$´¤¾¼½|]";

	// /* Caracteres numericos */
	// private String caracteresNumericos = "[0-9]";
	/* Atributos para las validaciones */
	private static Pattern patron = null;

	private static Matcher matcher = null;

	/* Atributos para los mensajes de error */
	private static String mensajeError = null;

	private static String defineError = null;

	/*
	 * ERRORES La aplicacion que utiliza esta clase esta desarrollada con
	 * Struts, por eso utilizamos este sistema de mensajes de error. Si hubiera
	 * un error en algún validación el método devolvería , por ejemplo:
	 * "nombreCliente.vacio". "NombreCliente" sería la cadena que le pasamos al
	 * método y que nos indica que estamos validando el nombre del cliente y
	 * ".vacio" sería la parte del mensaje de error que nos permite identificar
	 * el tipo de error detectado al validar. En nuestro ejemplo indicaría que
	 * el campo NombreCliente está vacio.
	 */
	public static void setMensajeError(String mensajeError) {
		mensajeError = mensajeError;
	}

	public static String getMensajeError() {
		return mensajeError;
	}

	public static void setDefineError(String defineError) {
		defineError = defineError;
	}

	public static String getDefineError() {
		return defineError;
	}

	/**
	 * Chequea que el valor que se le pasa sea un número sin signo y entero.
	 * 
	 * @param nombre
	 *            cadena que va a ser controlada
	 * @return boolean En función del resultado, retorna true si se cumple o
	 *         false si la comprobación es incorrecta
	 */

	public static boolean isCaracteres(String nombre) {
		patron = Pattern.compile(signosValidos);
		matcher = patron.matcher(nombre);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Chequea que el valor que se le pasa sea un número sin signo y entero.
	 * 
	 * @param nombre
	 *            cadena que va a ser controlada
	 * @return boolean En función del resultado, retorna true si se cumple o
	 *         false si la comprobación es incorrecta
	 */

	public static boolean isNotNumero(String nombre) {
		patron = Pattern.compile(caracteresValidos);
		matcher = patron.matcher(nombre);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isTelefono(String telefono, boolean obligatorio,
			boolean contacto, String cadena) {

		String campo = telefono.trim();

		if (obligatorio) {
			if (campo.length() <= 0) {
				setMensajeError(cadena + ".vacio");
				return false;
			}
		}

		if (campo.length() > 0) {

			if (!isCaracteres(campo) && !isNotNumero(campo)) {

				if (campo.length() != 9) {
					setMensajeError(cadena + ".fijo");
					return false;
				}
				char ch = campo.charAt(0);
				if (contacto) {
					if ((ch != '6') && (ch != '9')&& (ch != '7')) {
						setMensajeError(cadena + ".formato");
						return false;
					}
				} else {
					if (ch != '9') {
						setMensajeError(cadena + ".formato");
						return false;
					}
				}
			} else {
				if (!campo.startsWith("+(34)"))
					return false;
				else if (campo.length() != 14)
					return false;
				else {
					// Verifica que todos los caracteres sean numeros o bien un
					// +, (, ) o -
					boolean abrioParentesis = false;
					int indiceParentesisAbre = 0;
					boolean cerroParentesis = false;

					for (int i = 0; i < campo.length(); i++) {
						String letra = campo.substring(i, i + 1);
						try {
							Integer.valueOf(letra);
						} catch (NumberFormatException e) {
							// Si entra aquí está mal porque se supone que no
							// puede
							// parsear una letra a número.
							if (!letra.equals("(") && !letra.equals(")")
									&& !letra.equals("+")
							// && !letra.equals("-")
							) {
								return false;
							} else {
								if (letra.equals("+") && i > 0) {
									// Sale porque hay un signo mas en u lugar
									// que no es
									// el principio de la cadena.
									return false;
								}
								// Verifica que solo se abra un parentesis en el
								// texto.
								if (letra.equals("(")) {
									if (abrioParentesis) {
										return false;
									} else if (i != 1) {
										return false;
									} else {
										abrioParentesis = true;
										indiceParentesisAbre = i;
									}
								}
								// Verifica que solo se cierre un parentesis en
								// el texto.
								if (letra.equals(")")) {
									if (cerroParentesis || !abrioParentesis) {
										return false;
									} else {
										cerroParentesis = true;
										if ((indiceParentesisAbre + 1) == i) {
											// Debe haber al menos un numero
											// entre el
											// parentesis que abre y el que
											// cierra.
											return false;
										} else if (indiceParentesisAbre != i - 3)
											return false;
									}
								}
							}
						}
					}
					if (abrioParentesis && !cerroParentesis) {
						// Abrió parentesis pero no lo cerró
						return false;
					}

					String tel = campo.substring(campo.indexOf(")") + 1).trim();

					if (!isNotNumero(tel)) {
						if (tel.length() != 9) {
							setMensajeError(cadena + ".fijo");
							return false;
						}
						char ch = tel.charAt(0);
						if (contacto) {
							if ((ch != '6') && (ch != '9')&& (ch != '7')) {
								setMensajeError(cadena + ".formato");
								return false;
							}
						} else {
							if (ch != '9') {
								setMensajeError(cadena + ".formato");
								return false;
							}
						}
					} else
						return false;

				}

			}

		}
		return true;
	}

	/**
	 * 
	 * @param Nétodo
	 *            que valida una dirección de correo electrónica
	 * @returnDevuelve Booleano TRUE o FALSE
	 */

	public static boolean isEmail(String correo) {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		// Match the given string with the pattern
		Matcher m = p.matcher(correo);

		// check whether match is found
		boolean matchFound = m.matches();

		if (matchFound)
			return true;
		else
			return false;
	}

	public static boolean isDominio(String dominio) {
		Pattern p = Pattern.compile("^(?:[^/]+://)?([^/:]+)");

		// Match the given string with the pattern
		Matcher m = p.matcher(dominio);

		// check whether match is found
		boolean matchFound = m.matches();

		if (matchFound)
			return true;
		else
			return false;
	}

	public static boolean esCIF(String txt) {
		int suma = 0;

		String cif = txt.toUpperCase();

		// Si empieza por una X, es especial para extranjeros y lo tratamos como
		// un nif,
		// sustituyendo la X por un cero.
		int tam = txt.length();

		if (tam != 9) {
			return false;
		}

		// Comprobamos que los 7 caracteres del medio sean numeros
		for (int j = 1; j < tam - 1; j++) {
			char c = txt.charAt(j);
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		// Si empieza por una X, es especial para extranjeros y lo tratamos como
		// un nif,
		// sustituyendo la X por un cero.
		if (cif.charAt(0) == 'X') {
			return esNIF('0' + cif.substring(1));
		}

		// Si no es especial para extranjeros,
		// la letra inicial debe ser una de las posibles
		String posibles = "ABCDEFGHKLMNPQSX";
		char letra = cif.charAt(0);
		if (posibles.indexOf(letra) == -1) {
			return false;
		}

		// El cif debe ser de 9 cifras
		// (ya sean 1 car�cter al inicio y el resto num�rico o 1 car�cter al
		// ppio, otro al final y el resto num�rico)

		// suma de los d�gitos pares
		suma = Character.getNumericValue(cif.charAt(2))
				+ Character.getNumericValue(cif.charAt(4))
				+ Character.getNumericValue(cif.charAt(6));
		for (int n = 1; n < 8; n = n + 2) {
			Double d = new Double((Math.floor((2 * Character
					.getNumericValue(cif.charAt(n))) / 10)));
			suma = suma + ((2 * Character.getNumericValue(cif.charAt(n))) % 10)
					+ d.intValue();
		}

		// Estan reservados para entidades estatales los CIF que empiecen por S
		// o P.
		String posibles2 = "SP";
		if ((posibles2.indexOf(letra) == -1)) {
			// Control tipo n�mero
			if (!Character.isDigit(cif.charAt(8)))// Si no es num�rico
			{
				return (((int) cif.charAt(8)) == (64 + (10 - (suma % 10))));
			}
			if ((suma % 10) == 0) {
				if (Character.getNumericValue(cif.charAt(8)) != (suma % 10)) {
					return false;
				}
			} else {
				if (Character.getNumericValue(cif.charAt(8)) != (10 - (suma % 10))) {
					return false;
				}
			}
		} else {
			// Control tipo letra en los casos especiales (comienzo en S o P)
			if (((int) cif.charAt(8)) != (64 + (10 - (suma % 10)))) {
				return false;
			}
		}

		return true;
	}

	public static boolean esNIF(String txt) {
		String dni = "";
		String letra = "";
		char c;
		int tam = txt.length();

		if (tam != 9) {
			return false;
		}

		for (int j = 0; j < tam - 1; j++) {
			c = txt.charAt(j);
			dni = dni + c;
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		int cod = (Integer.parseInt(dni) % 23) + 1;

		switch (cod) {
		case 1:
			letra = "T";
			break;
		case 2:
			letra = "R";
			break;
		case 3:
			letra = "W";
			break;
		case 4:
			letra = "A";
			break;
		case 5:
			letra = "G";
			break;
		case 6:
			letra = "M";
			break;
		case 7:
			letra = "Y";
			break;
		case 8:
			letra = "F";
			break;
		case 9:
			letra = "P";
			break;
		case 10:
			letra = "D";
			break;
		case 11:
			letra = "X";
			break;
		case 12:
			letra = "B";
			break;
		case 13:
			letra = "N";
			break;
		case 14:
			letra = "J";
			break;
		case 15:
			letra = "Z";
			break;
		case 16:
			letra = "S";
			break;
		case 17:
			letra = "Q";
			break;
		case 18:
			letra = "V";
			break;
		case 19:
			letra = "H";
			break;
		case 20:
			letra = "L";
			break;
		case 21:
			letra = "C";
			break;
		case 22:
			letra = "K";
			break;
		case 23:
			letra = "E";
			break;
		default:
			break;
		}

		c = txt.charAt(tam - 1);
		String strC = String.valueOf(c).toUpperCase();
		if (!Character.isLetter(c)) {
			return false;
		}

		if (!strC.equals(letra)) {
			return false;
		}

		return true;
	}

	/**
	 * Método que valida el formato de las fechas
	 * 
	 * @param fecha
	 *            valor de fecha introducido
	 * @param cadena
	 *            error que envia si no es correcto
	 * @param obligatorio
	 *            indica si el campo es o no obligatorio
	 * @return boolean En función del resultado, retorna true si se cumple o
	 *         false si la comprobación es incorrecta
	 */

	public static boolean validaFecha(String fecha, String cadena,
			boolean obligatorio) {
		String campo = fecha.trim();
		if (obligatorio) {
			if (campo.length() <= 0) {
				setMensajeError(cadena + ".vacio");
				return false;
			}
		}
		if (campo.length() > 0) {
			if (campo.length() != 10) {
				setMensajeError(cadena + ".longitud");
				return false;
			}
			// saca de la fecha dia, mes y año
			String[] fech1 = campo.split("[/]");
			// comprueba que haya introducido el formato dd/mm/yyyy
			if (fech1.length < 3) {
				setMensajeError(cadena + ".formato");
				return false;
			}
			int dia = new Integer(fech1[0]).intValue();
			int mes = new Integer(fech1[1]).intValue();
			int anio = new Integer(fech1[2]).intValue();
			// el mes debe estar entre 1 y 12
			if (mes < 1 || mes > 12) {
				setMensajeError(cadena + ".incorrecta");
				return false;
			}
			// comprueba que el año este entre 1900 y 2099
			if (anio < 1900 || anio > 2099) {
				setMensajeError(cadena + ".incorrecta");
				return false;
			}
			// comprueba el numero de dias dependiendo del mes
			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
					|| mes == 10 || mes == 12) {
				if (dia <= 0 || dia > 31) {
					setMensajeError(cadena + ".incorrecta");
					return false;
				}
			}
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				if (dia <= 0 || dia > 30) {
					setMensajeError(cadena + ".incorrecta");
					return false;
				}
			}
			if (mes == 2) {
				if (anio % 4 > 0) {
					if (dia > 28) {
						setMensajeError(cadena + ".incorrecta");
						return false;
					}
				} else if (anio % 100 == 0 && anio % 400 > 0) {
					if (dia > 28) {
						setMensajeError(cadena + ".incorrecta");
						return false;
					}
				} else {
					if (dia > 29) {
						setMensajeError(cadena + ".incorrecta");
						return false;
					}
				}
			}
		}
		return true;
	}// Fin del método validaFecha()

}
