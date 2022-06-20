package com.cyl.ppmtooljava.exceptions;

/**
 * @Auther: cyl
 * @Date: 20/5/2022 - 05 - 2022 - 9:43 AM
 * @Description: com.cyl.ppmtooljava.exceptions
 * @version: 1.0
 */
public class UserNameAlreadyExistsResponse {

    private String username;

    public UserNameAlreadyExistsResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
