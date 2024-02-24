package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	public boolean validateJwtToken(String token) {

		final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);
		try {
			Jwts.parser().setSigningKey(
					"gfdiofjoaisdjfioadjfioasdjfoiajdfioasjf1221221212aosidjf8af98adf8asdhusdhusdhauihdfudshfuiadhfaishfdaisuhfuiashfiuhdsffasdf")
					.parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("ERRRRRRROOOOOOOORRRRR", e);
		}
		return false;
	}

	public String getUserNameStringFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(
				"gfdiofjoaisdjfioadjfioasdjfoiajdfioasjf1221221212aosidjf8af98adf8asdhusdhusdhauihdfudshfuiadhfaishfdaisuhfuiashfiuhdsffasdf")
				.parseClaimsJws(token).getBody().getSubject();
	}

}
