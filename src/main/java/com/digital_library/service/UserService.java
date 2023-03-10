package com.digital_library.service;

import com.digital_library.domain.Author;
import com.digital_library.domain.User;
import com.digital_library.repository.AuthorRepository;
import com.digital_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
    public ArrayList<User> getAllUsers() {return userRepository.getAllUsers();}
    public User getUserById(int id) {return userRepository.getUserById(id);}
    public void createUser(User user) {userRepository.createUser(user);}
    public void updateUserById(User user) {
        userRepository.updateUser(user);
    }
    public void deleteUser(User user) {userRepository.deleteUser(user);}
}
