package com.cyl.ppmtooljava.exceptions;

/**
 * @Auther: cyl
 * @Date: 19/5/2022 - 05 - 2022 - 11:12 AM
 * @Description: com.cyl.ppmtooljava.exceptions
 * @version: 1.0
 */
public class InvalidLoginResponse {
    private String username;
    private String password;

    public InvalidLoginResponse() {
        this.username = "Invalid username";
        this.password = "Invalid password";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
