package com.cyl.ppmtooljava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Auther: cyl
 * @Date: 31/3/2022 - 03 - 2022 - 12:25 PM
 * @Description: com.cyl.ppmtooljava.exceptions
 * @version: 1.0
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String message) {
        super(message);
    }
}
