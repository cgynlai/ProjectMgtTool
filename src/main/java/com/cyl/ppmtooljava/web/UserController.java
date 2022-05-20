package com.cyl.ppmtooljava.web;

import com.cyl.ppmtooljava.domain.User;
import com.cyl.ppmtooljava.services.MapValidationErrorService;
import com.cyl.ppmtooljava.services.UserService;
import com.cyl.ppmtooljava.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: cyl
 * @Date: 5/5/2022 - 05 - 2022 - 4:03 PM
 * @Description: com.cyl.ppmtooljava.web
 * @version: 1.0
 */

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserService userService;


    @Autowired
    private UserValidator userValidator;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        //validate password match
        userValidator.validate(user,result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null){
            return errorMap;
        }

        User newUser = userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);


    }
}
