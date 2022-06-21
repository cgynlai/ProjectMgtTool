package com.cyl.ppmtooljava.payload;

/**
 * @Author: cyl
 * @Date: 24/5/2022 - 05 - 2022 - 11:19 AM
 * @Description: com.cyl.ppmtooljava.payload
 * @version: 1.0
 */
public class JWTLoginSucessResponse {

    private boolean success;
    private String token;

    public JWTLoginSucessResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JWTLoginSucessResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}

