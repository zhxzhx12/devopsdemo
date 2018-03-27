package com.vt.demo.service;

import org.springframework.security.core.GrantedAuthority;

public class MethodAwareGrantedAuthority implements GrantedAuthority{

	 private String permissionUrl;
	    private String method;


	    public String getMethod() {
	        return method;
	    }

	    public void setMethod(String method) {
	        this.method = method;
	    }

	    public MethodAwareGrantedAuthority(String url, String method) {
	        this.permissionUrl = url;
	        this.method = method;
	    }

	    @Override
	    public String getAuthority() {
	        return this.permissionUrl + ";" + this.method;
	    }

		public String getPermissionUrl() {
			return permissionUrl;
		}

		public void setPermissionUrl(String permissionUrl) {
			this.permissionUrl = permissionUrl;
		}
	    
}
