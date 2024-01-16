package com.qf.common.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : sin
 * @date : 2024/1/14 17:03
 * @Description : jwt 工具类 生成和解析token
 */
@Component("JWTToken")
@Slf4j
public class JwtUtil {

    @Value("${token.secret}")
    private String SECRET;

    @Value("${token.expireTime}")
    private int EXPRIETIME;


    public String token(Authentication authentication) {
        System.out.println(EXPRIETIME);
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() * 10000L + 100000L * 60 * EXPRIETIME))  //设置过期时间:单位毫秒
                .withAudience(JSON.toJSONString(authentication)) //设置接受方信息，一般时登录用户
                .sign(Algorithm.HMAC256(SECRET));
    }

    public void tokenVerify(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        verifier.verify(token); // 没报错就说明验证成功
        JWT.decode(token).getExpiresAt();
        String json = JWT.decode(token).getAudience().get(0);
        JwtAuthentication jwtAuthentication = JSON.parseObject(json, JwtAuthentication.class);
        // TODO 从token中拿出来用户信息，设置到SecurityContextHolder中 后面需要修改，可以从redis中获取
        //  token 中存放username
        SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
    }
}