package com.Oreki5.EventRegistration_Backend;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

@SpringBootTest
class EventRegistrationBackendApplicationTests {

	@Test
	void contextLoads() {
		SecretKey sKey = Jwts.SIG.HS512.key().build();
		String secret = DatatypeConverter.printHexBinary(sKey.getEncoded());
		System.out.println("secret: " + secret);

	}

}
