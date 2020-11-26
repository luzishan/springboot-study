package com.lu.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt测试
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/19 11:15
 */
public class JwtTest {

    private static final String SIGN = "hahahahehehe";

    /**
     * jwt由三部分组成
     * 1)header:header典型的由两部分组成：token的类型（“JWT”）和算法名称（比如：HMAC SHA256或者RSA等
     * 然后，用Base64对这个JSON编码就得到JWT的第一部分
     * {
     * 'alg':"SHA256,
     * 'typ':"JWT"
     * }
     * 2)payload:payload JWT的第二部分是payload，它包含声明（要求）。声明是关于实体(通常是用户)和其他数据的声明。
     * 声明有三种类型: registered, public 和 private。
     * Registered claims : 这里有一组预定义的声明，它们不是强制的，但是推荐。
     * 比如：iss (issuer), exp (expiration time), sub (subject), aud (audience)等。
     * Public claims : 可以随意定义。Private claims : 用于在同意使用它们的各方之间共享信息，并且不是注册的或公开的声明。
     * 下面是一个例子：
     * <p>
     * {
     * "sub": '1234567890',
     * "name": 'john',
     * "admin":true
     * }
     * 对payload进行Base64编码就得到JWT的第二部分
     * 注意，不要在JWT的payload或header中放置敏感信息，除非它们是加密的
     * 3)signature: signature为了得到签名部分，你必须有编码过的header、编码过的payload、一个秘钥，
     * 签名算法是header中指定的那个，然对它们签名即可。例如：
     * HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)
     * 签名是用于验证消息在传递过程中有没有被更改，并且，对于使用私钥签名的token，它还可以验证JWT的发送方是否为它所称的发送方
     */
    @Test
    public void createJwt() {



        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 1200);

        //header
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        JWTCreator.Builder builder = JWT.create();
        String token = builder.withHeader(map)
                .withClaim("name", "张三")
                .withClaim("age", 26)
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SIGN));

        System.out.println(token);
    }

    @Test
    public void parseJwt(){
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGN)).build();
        DecodedJWT verify = build.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoi5byg5LiJIiwiZXhwIjoxNjA2MzgwODQ1LCJhZ2UiOjI2fQ.dbUG0fSVceVb0ixusd63Kqr7WuPtrSYGTM4v9F6dRZw");
        String str = verify.getHeader();
        System.out.println(str);
    }
}
