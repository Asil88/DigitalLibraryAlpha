package com.digital_library.service;

import com.digital_library.domain.Author;
import com.digital_library.domain.User;
import com.digital_library.repository.AuthorRepository;
import com.digital_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {

    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
    public ArrayList<User> getAllUsers() {return (ArrayList<User>) userRepository.findAll();}
    public User getUserById(int id) {return userRepository.findById(id).get();}
    public User getUserByFirstStartingWith(String letter) {return userRepository.findUserByNameStartingWith(letter);}
    public void createUser(User user) {userRepository.save(user);}
    public void updateUserById(User user) {userRepository.saveAndFlush(user); }
    public void deleteUser(User user) {userRepository.delete(user);}
    @Transactional(rollbackFor = ArithmeticException.class)
    public void saveUserTransactional(User user){
        userRepository.save(user);
    }
}

