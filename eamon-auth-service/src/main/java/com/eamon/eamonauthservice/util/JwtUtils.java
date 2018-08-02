package com.eamon.eamonauthservice.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * API调用认证工具类，采用RSA加密
 */
public class JwtUtils {
    /**
     * 公钥
     */
    private static RSAPublicKey publicKey;
    /**
     * 私钥
     */
    private static RSAPrivateKey privateKey;

    /**
     * 单例模式
     */
    private static class SingletonHolder {
        private static final JwtUtils INSTANCE = new JwtUtils();
    }


    /**
     * 使用模和指数生成jwt
     *
     * @param modulus
     * @param privateExponent
     * @param publicExponent
     * @return
     */
    public static JwtUtils getInstance(String modulus, String privateExponent, String publicExponent) {
        if (privateKey == null && publicKey == null) {
            // 使用模和指数生成RSA公钥和私钥
            publicKey = RSAUtils.getPublicKey(modulus, publicExponent);
            privateKey = RSAUtils.getPrivateKey(modulus, publicExponent);
        }
        return SingletonHolder.INSTANCE;
    }

    /**
     * 重新生成
     *
     * @param modulus
     * @param privateExponent
     * @param publicExponent
     */
    public static void reload(String modulus, String privateExponent, String publicExponent) {
        privateKey = RSAUtils.getPrivateKey(modulus, privateExponent);
        publicKey = RSAUtils.getPublicKey(modulus, publicExponent);
    }

    public static JwtUtils getInstance() throws NoSuchProviderException, NoSuchAlgorithmException {
        if (privateKey == null && publicKey == null) {
//            publicKey = (RSAPublicKey) new KeyBuilder().build().getPublic();
//            privateKey = (RSAPrivateKey) new KeyBuilder().build().getPrivate();
            privateKey = RSAUtils.getPrivateKey(RSAUtils.modulus, RSAUtils.private_exponent);
            publicKey = RSAUtils.getPublicKey(RSAUtils.modulus, RSAUtils.public_exponent);
        }
        System.out.println(publicKey);
        System.out.println(privateKey);
        return SingletonHolder.INSTANCE;
    }

    Key key = null;

    /**
     * 获取token
     *
     * @param uid
     * @param exp 失效时间，单位分钟
     * @return
     * @throws NoSuchProviderException
     * @throws NoSuchAlgorithmException
     */
    public String getToken(String uid, int exp) {
        System.out.println("getToken: "+privateKey);
        long endTime = System.currentTimeMillis() + 1000 * 60 * exp;
        /**
         * 用私钥签名
         */
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        return Jwts.builder()
                .signWith(key)
                .setSubject(uid)
                .setExpiration(new Date(endTime))
                .compact();
    }

    /**
     * 获取token
     *
     * @param uid
     * @return
     */
    public String getToken(String uid) {
        long endTime = System.currentTimeMillis() + 1000 * 60 * 1440;
        return Jwts.builder()
                .setSubject(uid)
                .signWith(privateKey)
                .setExpiration(new Date(endTime))
                .compact();
    }

    public JWTResult checkToken(String token) {
        System.out.println("checkToken: "+publicKey);
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
            String sub = body.get("sub", String.class);
            return new JWTResult(true, sub, "合法请求", 200);
        } catch (ExpiredJwtException e) {
            // 在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
            return new JWTResult(false, null, "token已过期", 500);

        } catch (SignatureException e) {
            // 在解析JWT字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该JWT字符串是伪造的
            return new JWTResult(false, null, "非法请求", 500);
        } catch (Exception e) {
            return new JWTResult(false, null, "非法请求", 500);
        }
    }

    public static class JWTResult {
        private boolean status;
        private String uid;
        private String msg;
        private int code;

        public JWTResult() {
            super();
        }

        public JWTResult(boolean status, String uid, String msg, int code) {
            super();
            this.status = status;
            this.uid = uid;
            this.msg = msg;
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }

}
