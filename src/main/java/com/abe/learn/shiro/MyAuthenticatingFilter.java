package com.abe.learn.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyAuthenticatingFilter extends AuthenticatingFilter {


	

	@Override
	protected boolean onAccessDenied(ServletRequest arg0, ServletResponse response) throws Exception {
		 WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
		return false;
	}
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		javax.servlet.http.HttpServletRequest httpRequest = (javax.servlet.http.HttpServletRequest)request;
		String userName =  httpRequest.getHeader("username");
         String password =  httpRequest.getHeader("password");
         if(("Scott".equals(userName) && "tiger".equals(password))||
        	("Matt".equals(userName) && "lion".equals(password))	 ) {
        	 return true;
         }
		return false;
	}



	@Override
	protected AuthenticationToken createToken(ServletRequest arg0, ServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
