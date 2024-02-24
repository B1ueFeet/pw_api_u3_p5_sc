package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;
	final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			String jwt = this.parseJwt(request);
			if (jwt != null && this.jwtUtils.validateJwtToken(jwt)) {
				String userName = this.jwtUtils.getUserNameStringFromJwtToken(jwt);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName,
						null, new ArrayList<>());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("ERRRRROOOOOOOORRRRRRRR", e);
		}
		
		filterChain.doFilter(request, response);

		// TODO Auto-generated method stub

	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Autorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}

}