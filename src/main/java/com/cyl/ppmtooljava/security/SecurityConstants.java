package com.cyl.ppmtooljava.security;

/**
 * @Auther: cyl
 * @Date: 24/5/2022 - 05 - 2022 - 8:33 AM
 * @Description: com.cyl.ppmtooljava.security
 * @version: 1.0
 */
public class SecurityConstants {

    public static final String SIG_UP_URLS = "/api/users/**";
    public static final String H2_URL = "h2-console/**";
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 120_000;

}
