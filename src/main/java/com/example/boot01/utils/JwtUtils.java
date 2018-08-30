package com.example.boot01.utils;

import com.example.boot01.domian.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.Date;


public class JwtUtils {

    //主题
    private static final String SUBJECT = "jwt";
    //过期时间 一周
    private static final long  EXPIRE = 1000 * 60 * 60 * 24 * 7;
    //密钥
    private static final String APPSERCRET = "pawd";


    /**
     * 生产jwt token
     * @param user
     * @return
     */
    public static String genJwtwebToken(User user){

        if ( user == null || user.getId() == null
                || user.getName() == null || user.getHeadImg() == null){
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("userId", user.getId())
                .claim("userName", user.getName())
                .claim("HeadImg", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSERCRET)
                .compact();

        return token;

    }

    /**
     * 检验
     * @param token
     * @return
     */
    public static Claims checkJwt(String token){

        try {

            Claims claim = (Jwts.parser().setSigningKey(APPSERCRET)).parseClaimsJws(token).getBody();
            return claim;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
