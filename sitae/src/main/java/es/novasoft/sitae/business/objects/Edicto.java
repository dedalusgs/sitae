package es.novasoft.sitae.business.objects;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Edicto implements java.io.Serializable {
	
	public static String	         TIPO_PUBLICACION_LABORABLES	= "LAB";
	
	public static String	         TIPO_PUBLICACION_NATURALES	 = "NAT";
	
	private static final long	     serialVersionUID	         = 1L;
	
	private Integer	                 idEdicto;
	
	private String	                 titulo;
	
	private String	                 numExp;
	
	private byte[]	                 pdfAdjunto;
	
	private Date	                 fechaPublicacionPropuesta;
	
	private Date	                 fechaRetiradaPropuesta;
	
	private Date	                 fechaPublicacion;
	
	private Date	                 fechaRetirada;
	
	private Date	                 fechaUltimaModificacion;
	
	private Date	                 fechaRedaccion;
	
	private String	                 url;
	
	private String	                 urlCertificada;
	
	private String	                 descripcion;
	
	private CentroProcedencia	     centro;
	
	private TipoEdicto	             tipoEdicto;
	
	private Usuario	                 redactor;
	
	private Usuario	                 publicador;
	
	private Usuario	                 despublicador;
	
	private String	                 motivoBaja;
	
	private String	                 motivoBajaVa;
	
	private Estado	                 estado;
	
	private String	                 codigo;
	
	private String	                 nombrePdfAdjunto;
	
	private OrganismoExterno	     organismoExterno;
	
	private String	                 tituloVa;
	
	private String	                 descripcionVa;
	
	private byte[]	                 diligencia;
	
	private TipoFirma	             tipoFirma;
	
	private UsuarioFirmante	         firmante;
	
	private Edicto	                 sustituyeA;
	
	private Edicto	                 sustituidoPor;
	
	private Integer	                 diasExposicion;
	
	private String	                 tipoExposicion;
	
	private Integer	                 IdOrganismoExterno;
	
	private String	                 redesSociales;
	
	private String	                 listaCorreo;
	
	private String	                 otrosCorreos;
	
	private String	                 hashtags;
	
	private String	                 urlAcortada;
	private String	                 tipoFirmaDiligencia;
	private byte[]	                 firmaDiligencia;
	private Organismo	             organismo;
	private Date	                 caducidadFirma;
	
	private PublicacionRedesSociales	publicacionRedesSociales;
	
	public Integer getIdOrganismoExterno() {
		return IdOrganismoExterno;
	}
	
	public void setIdOrganismoExterno(Integer idOrganismoExterno) {
		IdOrganismoExterno = idOrganismoExterno;
	}
	
	public Edicto getSustituyeA() {
		return sustituyeA;
	}
	
	public void setSustituyeA(Edicto sustituyeA) {
		this.sustituyeA = sustituyeA;
	}
	
	public Edicto getSustituidoPor() {
		return sustituidoPor;
	}
	
	public void setSustituidoPor(Edicto sustituidoPor) {
		this.sustituidoPor = sustituidoPor;
	}
	
	/** default constructor */
	public Edicto() {
	}
	
	public Edicto(String titulo, String numExp, byte[] pdfAdjunto, Date fechaPublicacionPropuesta, Date fechaRetiradaPropuesta, Date fechaPublicacion, Date fechaRetirada,
	        Date fechaUltimaModificacion, Date fechaRedaccion, String url, String urlCertificada, String descripcion, CentroProcedencia centro, TipoEdicto tipoEdicto,
	        Usuario redactor, Usuario publicador, Estado estado, String codigo, String nombrePdfAdjunto, OrganismoExterno organismoExterno, String tituloVa, String descripcionVa,
	        byte[] diligencia, TipoFirma tipoFirma, UsuarioFirmante firmante) {
		super();
		this.titulo = titulo;
		this.numExp = numExp;
		this.pdfAdjunto = pdfAdjunto;
		this.fechaPublicacionPropuesta = fechaPublicacionPropuesta;
		this.fechaRetiradaPropuesta = fechaRetiradaPropuesta;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaRetirada = fechaRetirada;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.fechaRedaccion = fechaRedaccion;
		this.url = url;
		this.urlCertificada = urlCertificada;
		this.descripcion = descripcion;
		this.centro = centro;
		this.tipoEdicto = tipoEdicto;
		this.redactor = redactor;
		this.publicador = publicador;
		this.estado = estado;
		this.codigo = codigo;
		this.nombrePdfAdjunto = nombrePdfAdjunto;
		this.organismoExterno = organismoExterno;
		this.tituloVa = tituloVa;
		this.descripcionVa = descripcionVa;
		this.diligencia = diligencia;
		this.tipoFirma = tipoFirma;
		this.firmante = firmante;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getIdEdicto() {
		return idEdicto;
	}
	
	public void setIdEdicto(Integer idEdicto) {
		this.idEdicto = idEdicto;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getNumExp() {
		return numExp;
	}
	
	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}
	
	public byte[] getPdfAdjunto() {
		return pdfAdjunto;
	}
	
	public void setPdfAdjunto(byte[] pdfAdjunto) {
		this.pdfAdjunto = pdfAdjunto;
	}
	
	public void setPdfAdjunto(String pdfAdjunto) {
		try {
			this.pdfAdjunto = pdfAdjunto.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public String getPdfAdjuntoString() {
		try {
			return new String(pdfAdjunto, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public Date getFechaPublicacionPropuesta() {
		return fechaPublicacionPropuesta;
	}
	
	public void setFechaPublicacionPropuesta(Date fechaPublicacionPropuesta) {
		this.fechaPublicacionPropuesta = fechaPublicacionPropuesta;
	}
	
	public Date getFechaRetiradaPropuesta() {
		return fechaRetiradaPropuesta;
	}
	
	public void setFechaRetiradaPropuesta(Date fechaRetiradaPropuesta) {
		this.fechaRetiradaPropuesta = fechaRetiradaPropuesta;
	}
	
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public Date getFechaRedaccion() {
		return fechaRedaccion;
	}
	
	public void setFechaRedaccion(Date fechaRedaccion) {
		this.fechaRedaccion = fechaRedaccion;
	}
	
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	
	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}
	
	public Date getFechaRetirada() {
		return fechaRetirada;
	}
	
	public void setFechaRetirada(Date fechaRetirada) {
		this.fechaRetirada = fechaRetirada;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrlCertificada() {
		return urlCertificada;
	}
	
	public void setUrlCertificada(String urlCertificada) {
		this.urlCertificada = urlCertificada;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public CentroProcedencia getCentro() {
		return centro;
	}
	
	public void setCentro(CentroProcedencia centro) {
		this.centro = centro;
	}
	
	public TipoEdicto getTipoEdicto() {
		return tipoEdicto;
	}
	
	public void setTipoEdicto(TipoEdicto tipoEdicto) {
		this.tipoEdicto = tipoEdicto;
	}
	
	public Usuario getRedactor() {
		return redactor;
	}
	
	public void setRedactor(Usuario redactor) {
		this.redactor = redactor;
	}
	
	public Usuario getPublicador() {
		return publicador;
	}
	
	public void setPublicador(Usuario publicador) {
		this.publicador = publicador;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String getNombrePdfAdjunto() {
		return nombrePdfAdjunto;
	}
	
	public void setNombrePdfAdjunto(String nombrePdfAdjunto) {
		this.nombrePdfAdjunto = nombrePdfAdjunto;
	}
	
	public OrganismoExterno getOrganismoExterno() {
		return organismoExterno;
	}
	
	public void setOrganismoExterno(OrganismoExterno organismoExterno) {
		this.organismoExterno = organismoExterno;
	}
	
	public String getTituloVa() {
		return tituloVa;
	}
	
	public void setTituloVa(String tituloVa) {
		this.tituloVa = tituloVa;
	}
	
	public String getDescripcionVa() {
		return descripcionVa;
	}
	
	public void setDescripcionVa(String descripcionVa) {
		this.descripcionVa = descripcionVa;
	}
	
	public byte[] getDiligencia() {
		return diligencia;
	}
	
	public void setDiligencia(byte[] diligencia) {
		this.diligencia = diligencia;
	}
	
	public void setDiligencia(String diligencia) {
		try {
			this.diligencia = diligencia.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public UsuarioFirmante getFirmante() {
		return firmante;
	}
	
	public void setFirmante(UsuarioFirmante firmante) {
		this.firmante = firmante;
	}
	
	public TipoFirma getTipoFirma() {
		return tipoFirma;
	}
	
	public void setTipoFirma(TipoFirma tipoFirma) {
		this.tipoFirma = tipoFirma;
	}
	
	public Usuario getDespublicador() {
		return despublicador;
	}
	
	public void setDespublicador(Usuario despublicador) {
		this.despublicador = despublicador;
	}
	
	public String getMotivoBaja() {
		return motivoBaja;
	}
	
	public void setMotivoBaja(String motivoBaja) {
		this.motivoBaja = motivoBaja;
	}
	
	public String getMotivoBajaVa() {
		return motivoBajaVa;
	}
	
	public void setMotivoBajaVa(String motivoBajaVa) {
		this.motivoBajaVa = motivoBajaVa;
	}
	
	public Integer getDiasExposicion() {
		return diasExposicion;
	}
	
	public void setDiasExposicion(Integer diasExposicion) {
		this.diasExposicion = diasExposicion;
	}
	
	public String getTipoExposicion() {
		return tipoExposicion;
	}
	
	public void setTipoExposicion(String tipoExposicion) {
		if (TIPO_PUBLICACION_NATURALES.equals(tipoExposicion)) {
			this.tipoExposicion = tipoExposicion;
		} else {
			this.tipoExposicion = TIPO_PUBLICACION_LABORABLES;
		}
		
	}
	
	public String getRedesSociales() {
		return redesSociales;
	}
	
	public void setRedesSociales(String redesSociales) {
		this.redesSociales = redesSociales;
	}
	
	public String getListaCorreo() {
		return listaCorreo;
	}
	
	public void setListaCorreo(String listaCorreo) {
		this.listaCorreo = listaCorreo;
	}
	
	public String getHashtags() {
		return hashtags;
	}
	
	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}
	
	public String getUrlAcortada() {
		return urlAcortada;
	}
	
	public String getOtrosCorreos() {
		return otrosCorreos;
	}
	
	public void setOtrosCorreos(String otrosCorreos) {
		this.otrosCorreos = otrosCorreos;
	}
	
	public void setUrlAcortada(String urlAcortada) {
		this.urlAcortada = urlAcortada;
	}
	
	public PublicacionRedesSociales getPublicacionRedesSociales() {
		return publicacionRedesSociales;
	}
	
	public void setPublicacionRedesSociales(PublicacionRedesSociales publicacionRedesSociales) {
		this.publicacionRedesSociales = publicacionRedesSociales;
	}
	
	public byte[] getFirmaDiligencia() {
		return firmaDiligencia;
	}
	
	public void setFirmaDiligencia(byte[] firmaDiligencia) {
		this.firmaDiligencia = firmaDiligencia;
	}
	
	public void setFirmaDiligencia(String firmaDiligencia) {
		try {
			if (firmaDiligencia != null)
				this.firmaDiligencia = firmaDiligencia.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public String getFirmaDiligenciaString() {
		try {
			return new String(firmaDiligencia, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public String getDiligenciaString() {
		try {
			return new String(diligencia, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public String getTipoFirmaDiligencia() {
		return tipoFirmaDiligencia;
	}
	
	public void setTipoFirmaDiligencia(String tipoFirmaDiligencia) {
		this.tipoFirmaDiligencia = tipoFirmaDiligencia;
	}
	
	public Organismo getOrganismo() {
		return organismo;
	}
	
	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}
	
	public Date getCaducidadFirma() {
		return caducidadFirma;
	}
	
	public void setCaducidadFirma(Date caducidadFirma) {
		this.caducidadFirma = caducidadFirma;
	}
	
}
