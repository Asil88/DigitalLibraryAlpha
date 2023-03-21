package com.digital_library.security;

import com.digital_library.domain.User;
import com.digital_library.domain.request.RegistrationUser;
import com.digital_library.repository.RoleRepository;
import com.digital_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecurityService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private  final RoleRepository roleRepository;


    @Autowired
    public SecurityService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean registration(RegistrationUser registrationUser) {
        try {

            User user = new User();
            user.setLogin(registrationUser.getLogin());
            user.setPassword(passwordEncoder.encode(registrationUser.getPassword()));
            user.setName(registrationUser.getName());
            user.setEmail(registrationUser.getEmail());
            user.setPhoneNumber(registrationUser.getPhoneNumber());

            User savedUser = userRepository.save(user);
            userRepository.addUserRole(savedUser.getId());
            //roleRepository.addAdminRole(savedUser.getId());

            if (savedUser != null) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean setAdminRole(User user) {
        try {
            userRepository.addAdminRole(user.getId());
            if (user != null) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
