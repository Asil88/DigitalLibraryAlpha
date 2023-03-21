package com.digital_library.domain.request;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
public class RegistrationUser {
    private String login;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
}
