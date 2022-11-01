package study.memberservice1.service;

import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class JwtService {

    private String secretKey = "myProjectSecret";

    // create Jwt
    public String makeJwt(HttpServletRequest req) throws Exception{
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + 1000 * 60 * 1);

        log.info("=================================================");
        log.info("expireTime: {}", expireTime);

        byte[] keySecretByte = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(keySecretByte, signatureAlgorithm.getJcaName());

        Map<String, Object> headerMap = new HashMap<String, Object>();

        headerMap.put("type", "JWT");
        headerMap.put("alg", "HS256");

        Map<String, Object> map = new HashMap<String, Object>();

        String memberName = req.getParameter("member_name");
        String email = req.getParameter("email");

        map.put("memberName", memberName);
        map.put("email", email);

        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expireTime)
                .signWith(signatureAlgorithm, signingKey);
        return builder.compact();
    }
    
    // check Jwt
    public boolean checkJwt(String jwt) throws Exception{
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                    .parseClaimsJws(jwt).getBody();
            log.info("토큰 정상~!");
            log.info("expireTime : " + claims.getExpiration());
            log.info("memberName : " + claims.get("memberName"));
            log.info("email : " + claims.get("email"));
            return true;

        } catch (ExpiredJwtException e) {
            e.getMessage();
            return false;

        } catch (JwtException e) {
            e.printStackTrace();
            return false;
        }
    }
}
