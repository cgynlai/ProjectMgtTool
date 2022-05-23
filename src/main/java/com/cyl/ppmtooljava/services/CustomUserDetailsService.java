package com.cyl.ppmtooljava.services;

import com.cyl.ppmtooljava.domain.User;
import com.cyl.ppmtooljava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Auther: cyl
 * @Date: 23/5/2022 - 05 - 2022 - 11:07 PM
 * @Description: com.cyl.ppmtooljava.services
 * @version: 1.0
 */


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null) new UsernameNotFoundException("User not found");
        return user;
    }
}
