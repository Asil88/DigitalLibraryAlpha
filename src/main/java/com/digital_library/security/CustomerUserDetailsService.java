package com.digital_library.security;

import com.digital_library.domain.User;
import com.digital_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    UserRepository userRepository;

    @Autowired
    public CustomerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(s);
        if (user==null){
            throw  new UsernameNotFoundException(s);
        }
       return org.springframework.security.core.userdetails.User
                .withUsername(user.getLogin())
                .password(user.getPassword())
                .roles(userRepository.getRole(user.getId())).build();
    }
}
