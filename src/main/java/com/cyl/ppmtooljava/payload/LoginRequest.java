package com.cyl.ppmtooljava.payload;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: cyl
 * @Date: 24/5/2022 - 05 - 2022 - 11:14 AM
 * @Description: com.cyl.ppmtooljava.payload
 * @version: 1.0
 */
public class LoginRequest {

    @NotBlank(message = "username cannot be blank")
    private String username;
    @NotBlank(message = "password cannot be blank")
    private String password;

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
