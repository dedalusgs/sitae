package es.novasoft.sitae.ws.fandango;

public interface FandangoClient {

	public abstract java.lang.String getCertificadoPublicacion(
			java.lang.String urlDocumento, java.lang.String firmaB64,
			int tipoFirma, java.lang.String titulo)
			throws java.rmi.RemoteException;

	public abstract es.novasoft.sitae.ws.fandango.InformacionCertificadoPublicacion[] getInformacionCertificados(
			java.util.Calendar fechaDesde, java.util.Calendar fechaHasta,
			boolean soloActivos) throws java.rmi.RemoteException;

	public abstract java.lang.String getCertificadoPublicacionPdf(
			java.lang.String urlPdf, java.lang.String titulo)
			throws java.rmi.RemoteException;

	public abstract java.lang.String getCertificadoPublicacionTodasOpciones(
			java.lang.String urlDocumento, java.lang.String firmaB64,
			int tipoFirma, java.lang.String titulo, boolean subirCustodia,
			boolean isRevisable) throws java.rmi.RemoteException;

	public abstract void darDeBaja(java.lang.String urlCertificadoPublicacion)
			throws java.rmi.RemoteException;

	public abstract void darDeAlta(java.lang.String urlCertificadoPublicacion)
			throws java.rmi.RemoteException;

	public abstract java.lang.String getPDFCertificado(
			java.lang.String urlCertificadoPublicacion)
			throws java.rmi.RemoteException;

	public abstract java.lang.String getPDFInformeRevisiones(
			java.lang.String urlCertificadoPublicacion)
			throws java.rmi.RemoteException;

	public abstract es.novasoft.sitae.ws.fandango.InformacionCertificadoPublicacion getInformacionCertificado(
			java.lang.String urlCertificadoPublicacion)
			throws java.rmi.RemoteException;
}