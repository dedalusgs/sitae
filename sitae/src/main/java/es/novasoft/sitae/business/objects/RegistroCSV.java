package es.novasoft.sitae.business.objects;

public class RegistroCSV {
	private String documentoId;
	private Long status;
	private String documentCSV;
	private String signerId;
	private String internId;
	private String sourceDoc;
	private String params;
	private String destDoc;
	private String name;
	private String returl;
	private String application;

	public RegistroCSV() {
		// TODO Auto-generated constructor stub
	}

	public String getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getDocumentCSV() {
		return documentCSV;
	}

	public void setDocumentCSV(String documentCSV) {
		this.documentCSV = documentCSV;
	}

	public String getSignerId() {
		return signerId;
	}

	public void setSignerId(String signerId) {
		this.signerId = signerId;
	}

	public String getInternId() {
		return internId;
	}

	public void setInternId(String internId) {
		this.internId = internId;
	}

	public String getSourceDoc() {
		return sourceDoc;
	}

	public void setSourceDoc(String sourceDoc) {
		this.sourceDoc = sourceDoc;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getDestDoc() {
		return destDoc;
	}

	public void setDestDoc(String destDoc) {
		this.destDoc = destDoc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturl() {
		return returl;
	}

	public void setReturl(String returl) {
		this.returl = returl;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

}
