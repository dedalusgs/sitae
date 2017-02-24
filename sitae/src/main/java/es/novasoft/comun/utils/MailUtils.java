package es.novasoft.comun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;

public class MailUtils {

	private static String SMTP_AUTH = ResourceBundle.getBundle("mailconfig").getString("auth");

	private static String SMTP_AUTH_USER = ResourceBundle.getBundle("mailconfig").getString("usuario");

	private static String SMTP_AUTH_PWD = ResourceBundle.getBundle("mailconfig").getString("password");

	private final Log log = LogFactory.getLog(MailUtils.class);

	public int notificar(File ficheroAdjunto, String nombreAdjunto, String mail, String asunto, String mensaje) {
		ResourceBundle configuracionCorreo = ResourceBundle.getBundle("mailconfig");
		String host = configuracionCorreo.getString("host");
		String from = configuracionCorreo.getString("from");
		try {
			log.debug(Constantes.COMIENZA_METODO + " notificar");
			log.info("Host correo: " + host + " from: " + from + " to" + mail + " asunto: " + asunto + " mensaje: " + mensaje);
			log.debug(Constantes.FIN_METODO + " notificar");
			return enviarCorreo(host, from, mail, asunto, mensaje, ficheroAdjunto, nombreAdjunto);
		} catch (Exception e) {
			log.error("Error al realizar la notificación");
			return 0;
		}
	}

	public int notificarListaCorreosCOculta(File ficheroAdjunto, String nombreAdjunto, ArrayList<String> mails, String asunto, String mensaje) {
		ResourceBundle configuracionCorreo = ResourceBundle.getBundle("mailconfig");
		String host = configuracionCorreo.getString("host");
		String from = configuracionCorreo.getString("from");
		try {
			log.debug(Constantes.COMIENZA_METODO + " notificar");
			log.info("Host correo: " + host + " from: " + from + " to" + mails + " asunto: " + asunto + " mensaje: " + mensaje);
			log.debug(Constantes.FIN_METODO + " notificar");
			return enviarCorreoCopiaOculta(host, from, mails, asunto, mensaje, ficheroAdjunto, nombreAdjunto);
		} catch (Exception e) {
			log.error("Error al realizar la notificación");
			return 0;
		}
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            fichero adjunto que se envia (puede ser null para no enviar
	 *            nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo(java.lang.String host, java.lang.String from, java.lang.String to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setContent(text, "text/html");

			BodyPart adjuntar = null;
			if (adjunto != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
			}
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			if (adjuntar != null) {
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcci�n del destinatario del correo", e);
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo", e);
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            ficheros adjuntos que se envian (pueden ser null para no
	 *            enviar nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo(java.lang.String host, java.lang.String from, java.lang.String to, java.lang.String subject, java.lang.String text, File[] adjunto, String[] nombreAdjunto) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setText(text);

			if (adjunto.length != nombreAdjunto.length) {
				return 0;
			}

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			if (adjunto != null) {
				for (int i = 0; i <= adjunto.length - 1; i++) {
					if (adjunto[i] != null) {
						BodyPart adjuntar = new MimeBodyPart();
						adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto[i])));
						adjuntar.setFileName(nombreAdjunto[i]);
						multiParte.addBodyPart(adjuntar);
					}
				}
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	static class Autenticador extends javax.mail.Authenticator {
		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;

			return new PasswordAuthentication(username, password);
		}
	}

	/**
	 * Método que envía un correo en formato HTML con acuse de recibo.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            fichero adjunto que se envia (puede ser null para no enviar
	 *            nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreoAcuse(java.lang.String host, java.lang.String from, java.lang.String to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setText(text);

			BodyPart adjuntar = null;
			if (adjunto != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
			}
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			if (adjuntar != null) {
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addHeader("Disposition-Notification-To", from);

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML con acuse de recibo.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            fichero adjunto que se envia (puede ser null para no enviar
	 *            nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreoAcuse2(java.lang.String host, java.lang.String from, java.lang.String to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto,
			File adjunto2, String nombreAdjunto2) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setText(text);

			BodyPart adjuntar = null;
			if (adjunto != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
			}
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			if (adjuntar != null) {
				multiParte.addBodyPart(adjuntar);
			}

			if (adjunto2 != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto2)));
				adjuntar.setFileName(nombreAdjunto2);
			}

			if (adjuntar != null) {
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addHeader("Disposition-Notification-To", from);

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            ficheros adjuntos que se envian (pueden ser null para no
	 *            enviar nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo2(java.lang.String host, java.lang.String from, String to, java.lang.String subject, java.lang.String text, File[] adjunto, String[] nombreAdjunto, File[] adjunto2,
			String[] nombreAdjunto2) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setText(text);

			if (adjunto.length != nombreAdjunto.length) {
				return 0;
			}

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			if (adjunto != null) {
				for (int i = 0; i <= adjunto.length - 1; i++) {
					if (adjunto[i] != null) {
						BodyPart adjuntar = new MimeBodyPart();
						adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto[i])));
						adjuntar.setFileName(nombreAdjunto[i]);
						multiParte.addBodyPart(adjuntar);
					}
				}
			}

			if (adjunto2 != null) {
				for (int i = 0; i <= adjunto2.length - 1; i++) {
					if (adjunto2[i] != null) {
						BodyPart adjuntar = new MimeBodyPart();
						adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto2[i])));
						adjuntar.setFileName(nombreAdjunto2[i]);
						multiParte.addBodyPart(adjuntar);
					}
				}
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * 
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreoSinDocumentos(java.lang.String host, java.lang.String from, java.lang.String to, java.lang.String subject, java.lang.String text) {
		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setText(text);

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            fichero adjunto que se envia (puede ser null para no enviar
	 *            nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo(java.lang.String host, java.lang.String from, ArrayList to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			MimeMultipart multiParte = new MimeMultipart();

			MimeBodyPart texto = new MimeBodyPart();
			texto.setContent(text, "text/html");

			multiParte.addBodyPart(texto);

			// Documento adjunto

			if (adjunto != null) {
				MimeBodyPart adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			// InternetAddress receptor = new InternetAddress(to);
			// message.addRecipient(Message.RecipientType.TO, receptor);

			Iterator it = to.iterator();
			while (it.hasNext()) {
				InternetAddress direccion = new InternetAddress((String) it.next());
				message.addRecipient(Message.RecipientType.TO, direccion);
			}
			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la dirección del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.TERMINA_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML con acuse de recibo.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            fichero adjunto que se envia (puede ser null para no enviar
	 *            nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreoAcuse2(java.lang.String host, java.lang.String from, ArrayList to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto, File adjunto2,
			String nombreAdjunto2) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setText(text);

			BodyPart adjuntar = null;
			if (adjunto != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
			}
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			if (adjuntar != null) {
				multiParte.addBodyPart(adjuntar);
			}

			if (adjunto2 != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto2)));
				adjuntar.setFileName(nombreAdjunto2);
			}

			if (adjuntar != null) {
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addHeader("Disposition-Notification-To", from);

			Iterator it = to.iterator();
			while (it.hasNext()) {
				InternetAddress direccion = new InternetAddress((String) it.next());
				message.addRecipient(Message.RecipientType.TO, direccion);
			}

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            ficheros adjuntos que se envian (pueden ser null para no
	 *            enviar nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo2(java.lang.String host, java.lang.String from, ArrayList to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto, File adjunto2,
			String nombreAdjunto2) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			MimeBodyPart texto = new MimeBodyPart();
			texto.setContent(text, "text/html");

			MimeBodyPart adjuntar = null;
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			if (adjunto != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
				multiParte.addBodyPart(adjuntar);

			}

			adjuntar = null;
			if (adjunto2 != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto2)));
				adjuntar.setFileName(nombreAdjunto2);
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			Iterator it = to.iterator();
			while (it.hasNext()) {
				InternetAddress direccion = new InternetAddress((String) it.next());
				message.addRecipient(Message.RecipientType.TO, direccion);
			}

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            fichero adjunto que se envia (puede ser null para no enviar
	 *            nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo(java.lang.String host, java.lang.String from, ArrayList to, java.lang.String subject, java.lang.String text, File adjunto) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			MimeMultipart multiParte = new MimeMultipart();

			MimeBodyPart texto = new MimeBodyPart();
			texto.setContent(text, "text/html");

			multiParte.addBodyPart(texto);

			// Documento adjunto

			if (adjunto != null) {
				MimeBodyPart adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				// adjuntar.setFileName(nombreAdjunto);
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			// InternetAddress receptor = new InternetAddress(to);
			// message.addRecipient(Message.RecipientType.TO, receptor);

			Iterator it = to.iterator();
			while (it.hasNext()) {
				InternetAddress direccion = new InternetAddress((String) it.next());
				message.addRecipient(Message.RecipientType.TO, direccion);
			}
			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la dirección del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.TERMINA_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            ficheros adjuntos que se envian (pueden ser null para no
	 *            enviar nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo2(java.lang.String host, java.lang.String from, String to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto, File adjunto2,
			String nombreAdjunto2) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			MimeBodyPart texto = new MimeBodyPart();
			texto.setContent(text, "text/html");

			MimeBodyPart adjuntar = null;
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			if (adjunto != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
				multiParte.addBodyPart(adjuntar);

			}

			adjuntar = null;
			if (adjunto2 != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto2)));
				adjuntar.setFileName(nombreAdjunto2);
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	/**
	 * Método que envía un correo en formato HTML.
	 * 
	 * @param host
	 *            dirección IP del servidor de correo a utilizar.
	 * @param from
	 *            direccion de correo del remitente.
	 * @param to
	 *            direcciones de correo de los destinatarios.
	 * @param subject
	 *            asunto del correo a enviar.
	 * @param text
	 *            texto que aparecerá en el cuerpo del correo.
	 * @param adjunto
	 *            ficheros adjuntos que se envian (pueden ser null para no
	 *            enviar nada)
	 * 
	 * @return un entero 1 si es correcta la ejecución y 0 en caso contrario.
	 * 
	 */
	public int enviarCorreo3(java.lang.String host, java.lang.String from, String to, java.lang.String subject, java.lang.String text, File[] adjunto, String[] nombreAdjunto, File[] adjunto2,
			String[] nombreAdjunto2, File[] adjunto3, String[] nombreAdjunto3) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setText(text);

			if (adjunto.length != nombreAdjunto.length) {
				return 0;
			}

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			if (adjunto != null) {
				for (int i = 0; i <= adjunto.length - 1; i++) {
					if (adjunto[i] != null) {
						BodyPart adjuntar = new MimeBodyPart();
						adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto[i])));
						adjuntar.setFileName(nombreAdjunto[i]);
						multiParte.addBodyPart(adjuntar);
					}
				}
			}

			if (adjunto2 != null) {
				for (int i = 0; i <= adjunto2.length - 1; i++) {
					if (adjunto2[i] != null) {
						BodyPart adjuntar = new MimeBodyPart();
						adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto2[i])));
						adjuntar.setFileName(nombreAdjunto2[i]);
						multiParte.addBodyPart(adjuntar);
					}
				}
			}

			if (adjunto3 != null) {
				for (int i = 0; i <= adjunto3.length - 1; i++) {
					if (adjunto3[i] != null) {
						BodyPart adjuntar = new MimeBodyPart();
						adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto3[i])));
						adjuntar.setFileName(nombreAdjunto3[i]);
						multiParte.addBodyPart(adjuntar);
					}
				}
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress receptor = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, receptor);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcció del destinatario del correo");
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo");
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}

	public int enviarCorreoCopiaOculta(java.lang.String host, String from, ArrayList<String> to, java.lang.String subject, java.lang.String text, File adjunto, String nombreAdjunto) {

		log.debug(Constantes.COMIENZA_METODO + " enviarCorreo");
		int res = 1;
		try {
			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", SMTP_AUTH);
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.password", SMTP_AUTH_PWD);

			Autenticador auth = new Autenticador();
			Session session = Session.getInstance(props, auth);

			BodyPart texto = new MimeBodyPart();
			texto.setContent(text, "text/html");

			BodyPart adjuntar = null;
			if (adjunto != null) {
				adjuntar = new MimeBodyPart();
				adjuntar.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
				adjuntar.setFileName(nombreAdjunto);
			}
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			if (adjuntar != null) {
				multiParte.addBodyPart(adjuntar);
			}

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			InternetAddress[] direcciones = new InternetAddress[to.size()];
			for (int i = 0; i < to.size(); i++) {

				direcciones[i] = new InternetAddress(to.get(i));

			}
			// InternetAddress receptor = new InternetAddress(to);
			message.addRecipients(Message.RecipientType.BCC, direcciones);

			// for (int i = 0; i < to.length; i++) {
			// InternetAddress direccion = new InternetAddress(to[i]);
			// message.addRecipient(Message.RecipientType.TO, direccion);
			// }

			message.setSubject(subject);
			message.setContent(multiParte);

			// Send message
			Transport.send(message);
		} catch (AddressException e) {
			log.error("Error con la direcci�n del destinatario del correo", e);
			res = 0;
		} catch (MessagingException e) {
			log.error("No se pudo enviar el correo", e);
			res = 0;
		}
		log.debug(Constantes.FIN_METODO + " enviarCorreo");
		return res;
	}
}
