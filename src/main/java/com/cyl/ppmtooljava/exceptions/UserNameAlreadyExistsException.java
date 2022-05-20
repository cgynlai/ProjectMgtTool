package com.cyl.ppmtooljava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Auther: cyl
 * @Date: 20/5/2022 - 05 - 2022 - 9:46 AM
 * @Description: com.cyl.ppmtooljava.exceptions
 * @version: 1.0
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNameAlreadyExistsException extends RuntimeException {

    public UserNameAlreadyExistsException(String message) {
        super(message);
    }
}
