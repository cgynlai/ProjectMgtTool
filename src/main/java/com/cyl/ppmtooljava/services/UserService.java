package com.cyl.ppmtooljava.services;

import com.cyl.ppmtooljava.domain.User;
import com.cyl.ppmtooljava.exceptions.UserNameAlreadyExistsException;
import com.cyl.ppmtooljava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Auther: cyl
 * @Date: 19/5/2022 - 05 - 2022 - 12:58 PM
 * @Description: com.cyl.ppmtooljava.services
 * @version: 1.0
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){
        try {
            newUser.setUsername(newUser.getUsername());
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            newUser.setConfirmPassword("");
            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new UserNameAlreadyExistsException("Username '" + newUser.getUsername()+"' already exists");
                 }
    }

}
