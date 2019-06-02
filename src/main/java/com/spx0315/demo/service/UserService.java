package com.spx0315.demo.service;

import com.spx0315.demo.domain.User;
import com.spx0315.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
    static Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("username:   " + userName);
        User user = userRepository.findByUsername(userName);
        if(user == null){
            log.info("user:   " + user);
            throw new UsernameNotFoundException("Can't find this user");
        }
        log.info(user.getUsername());
        log.info(user.getPassword());
        return user;
    }
}
