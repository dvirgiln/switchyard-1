package org.switchyard.component.camel.jms.deploy;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.Subject;
import javax.servlet.ServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.switchyard.security.SecurityServices;
import org.switchyard.security.credential.ConfidentialityCredential;
import org.switchyard.security.credential.Credential;
import org.switchyard.security.credential.PrincipalCredential;
import org.switchyard.security.credential.SubjectCredential;
import org.switchyard.security.credential.extractor.SOAPMessageCredentialExtractor;
import org.switchyard.security.credential.extractor.WebServiceContextCredentialExtractor;

public class SecureMessage implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5552548108555558318L;
	
	private final Object originalMessage;
    private final Set<Credential> credentials;

    public SecureMessage(final Object message) {
        this.originalMessage = message;
        this.credentials = new HashSet<Credential>();
    }

    public Object getOriginalMessage() {
        return originalMessage;
    }

    public Set<Credential> getCredentials() {
        return this.credentials;
    }

    public void addCredentials(final Collection<Credential> credentials) {
        this.credentials.addAll(credentials);
    }

    public static SecureMessage fromRequest(final WebServiceContext webServiceContext , final Object message) {
        final SecureMessage secureMessage = new SecureMessage(message);
        secureMessage.addCredentials(SecurityServices.getServletRequestCredentialExtractor().extract(getServletRequest(webServiceContext)));

        return secureMessage;
    }
    

    private static ServletRequest getServletRequest(final WebServiceContext webServiceContext ) {
        if (webServiceContext != null) {
            return (ServletRequest)webServiceContext.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        }
        return null;
    }

}