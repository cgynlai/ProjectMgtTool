package com.cyl.ppmtooljava.validator;

import com.cyl.ppmtooljava.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @Auther: cyl
 * @Date: 20/5/2022 - 05 - 2022 - 3:32 PM
 * @Description: com.cyl.ppmtooljava.validator
 * @version: 1.0
 */


@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
         User user = (User) object;

         if(user.getPassword().length()<3){
             errors.rejectValue("password", "Length", "password length must be at least 6 characters ");
         }

         if(!user.getPassword().equals(user.getConfirmPassword())){
             errors.rejectValue("confirmPassword", "Match", "password must match ");
         }
    }
}
