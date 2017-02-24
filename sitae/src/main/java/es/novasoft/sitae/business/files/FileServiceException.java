/**
 * 
 */
package es.novasoft.sitae.business.files;

/**
 * @author dabel
 * 
 */
public class FileServiceException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     */
    public FileServiceException() {
	super();
	
    }
    
    /**
     * @param message
     * @param cause
     */
    public FileServiceException(String message, Throwable cause) {
	super(message, cause);
	
    }
    
    /**
     * @param message
     */
    public FileServiceException(String message) {
	super(message);
	
    }
    
    /**
     * @param cause
     */
    public FileServiceException(Throwable cause) {
	super(cause);
	
    }
    
}
