package com.medlista.sso;


import jenkins.model.Jenkins;
import hudson.security.SecurityRealm;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

// import jenkins.model.Jenkins;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationManager;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.providers.anonymous.AnonymousAuthenticationToken;


import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 * 
 * @author emilianoberenbaum
 *
 */
public class MedlistaSecurityRealm extends SecurityRealm {

	public static final String DEFAULT_LOGIN_URL = "securityRealm/saml";
			

	
	// public final String Protocl protocol;
	
	
	
	
	public MedlistaSecurityRealm() {
		
		
	}
	
	public String getJenkinsUrl() {
		return Jenkins.getInstance().getRootUrl();
	}

	
	// Security Realm implementation
	
	/**
	 * Login begins with method.
	 */
	@Override
	public String getLoginUrl() {
		return DEFAULT_LOGIN_URL;
	}
	

	/**
	 * Logout redirects to Protocol  target URL 
	 */
	@Override
	protected String getPostLogOutUrl(StaplerRequest req, Authentication auth) {
	
		StringBuilder logoutUrlBuidler = new StringBuilder(""); 

		//-- TODO:
		return logoutUrlBuidler.toString();
	}

	
	@Override
	public SecurityComponents createSecurityComponents() {
	
		
		return new SecurityComponents(
				new AuthenticationManager() {
					public Authentication authenticate(Authentication authentication) throws AuthenticationException  {
						
						if (authentication instanceof AnonymousAuthenticationToken) {
							return authentication;
						}
						throw new BadCredentialsException("Unexpected authentication type: " + authentication);
					}
				}
			);
	}
	

	/**
	 * 
	 */
	@Override
	public Filter createFilter(FilterConfig filterConfig) {

		Filter defaultFilter = super.createFilter(filterConfig);
		
		//-- TODO
		return defaultFilter;
	}
	
	/**
	 * Handler the logout processing.
	 */
	@Override
	public void doLogout(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
	
		//-- TODO:
		super.doLogout(req, rsp);
	}
	
	
	
	
	
}
