package com.digital_library.controller;

import com.digital_library.domain.User;
import com.digital_library.domain.request.RegistrationUser;
import com.digital_library.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.security.Principal;

@RestController
@RequestMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityController {

    SecurityService securityService;


    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping()
    public ResponseEntity<HttpResponse> registrationUser(@RequestBody RegistrationUser registrationUser) {
        return new ResponseEntity<>(securityService.registration(registrationUser) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<HttpResponse> setAdminRole(@RequestBody User user) {
        return new ResponseEntity<>(securityService.setAdminRole(user) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }*/

}
/*

@Controller
public class SecurityController {

    @GetMapping("/home")
    public String getHomePage(){

        return "home";
    }

    @GetMapping("/user")
    public String getUserPage(Principal principal){
        System.out.println(principal);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return "users";
    }

    @GetMapping("/admin")
    public String getAdminPage(){

        return "admins";
    }

    @GetMapping
    public String getAllPage(){
        return "home";
    }
}
*/
