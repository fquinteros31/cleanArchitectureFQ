package com.cleanArchitecture.fq.infraestructure.services.impl;

import com.cleanArchitecture.fq.domain.port.output.IJwtService;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class JwtServiceImpl implements IJwtService {
	
	@Override
	public String getJWTToken(String username) {
		
		if(username == null || username.isEmpty()) {
			return null;
		}
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 3500000))
				.signWith(SignatureAlgorithm.HS512,
						GlobalConstants.SECRET_KEY.getBytes()).compact();

		return GlobalConstants.PREFIX_JWT + token;
	}

}
