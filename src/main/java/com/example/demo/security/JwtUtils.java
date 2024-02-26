package com.example.demo.security;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {

	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	public boolean validateJwtToken(String auth) {

		try {
			Jwts.parser().setSigningKey("gfdiofjoaisdjfioadjfioasdjfoiajdfioasjf1221221212aosidjf8af98adf8asdhusdhusdhauihdfudshfuiadhfaishfdaisuhfuiashfiuhdsffasdf").parseClaimsJws(auth);
			return true;
		} catch (Exception e) {
			LOG.error("ERROOOOOOORRRRR", e);
		}
		return false;
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(
				"gfdiofjoaisdjfioadjfioasdjfoiajdfioasjf1221221212aosidjf8af98adf8asdhusdhusdhauihdfudshfuiadhfaishfdaisuhfuiashfiuhdsffasdf")
				.parseClaimsJws(token).getBody().getSubject();
	}

}
