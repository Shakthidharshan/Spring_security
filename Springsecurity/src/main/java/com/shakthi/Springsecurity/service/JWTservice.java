package com.shakthi.Springsecurity.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;


@Service
public class JWTservice {

        private String secretkey = "";

        public JWTservice() {
            try {
            KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secKey = keygen.generateKey();
            secretkey = Base64.getEncoder().encodeToString(secKey.getEncoded());
            }
            catch (NoSuchAlgorithmException e){
                throw new RuntimeException(e);
            }
        }

        public String GenerateToken(String username){

            HashMap<String , Object> claims = new HashMap<>();
            return Jwts.builder()
                    .claims()
                    .add(claims)
                    .subject(username)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                    .and()
                    .signWith(getKey())
                    .compact();
        }


        public SecretKey getKey(){
            byte [] keybytes = Decoders.BASE64.decode(secretkey);
            return Keys.hmacShaKeyFor(keybytes);
        }


//    public String extractUserName(String token) {
//    }
}

