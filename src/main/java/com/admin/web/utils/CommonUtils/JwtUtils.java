package com.admin.web.utils.CommonUtils;

import com.admin.web.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Jwt工具类
 */
public class JwtUtils {
    // 过期时间 60分钟
    private static final long EXPIRE = 1000 * 60 * 60;

    // 密钥
    private static final String SECRET = "com.admin.web";

    // 前缀 区分是否是本项目生成
    private static final String TOKEN_PREFIX = "admin";

    // 颁布者
    private static final String SUBJECT = "admin";

    /**
     * 根据用户信息生成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){
        // 生成token
        String token =   Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("userName",user.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE ))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
        token = TOKEN_PREFIX + token;
        return  token;
    }


    public static Claims checkJwt(String token){
        // 校验token
        try{
            final Claims claims  =   Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            return claims;

        }catch (Exception e){
            return null;
        }
    }
}
