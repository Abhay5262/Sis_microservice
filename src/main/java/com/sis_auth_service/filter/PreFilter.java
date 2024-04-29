package com.sis_auth_service.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sis_auth_service.userdetail.ProjectUserDetail;
import com.sis_auth_service.utils.Jwtutil;
@Component
public class PreFilter extends OncePerRequestFilter {
	@Autowired
	private Jwtutil jwtUtils;
	
	@Autowired
	private ProjectUserDetail projectUserDetails;
 
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String headerToken = request.getHeader("Authorization");
		String jwtToken = null;
		
		if(headerToken != null && headerToken.startsWith("Bearer "))
		{
			jwtToken = headerToken.substring(7);
			String username = jwtUtils.extractUsername(jwtToken);
			UserDetails userDetails = projectUserDetails.loadUserByUsername(username);
			
			if(jwtUtils.validateToken(jwtToken, userDetails))
			{
				UsernamePasswordAuthenticationToken uAAToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				uAAToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(uAAToken);
			}
		}
		filterChain.doFilter(request, response);
		
	}
}
