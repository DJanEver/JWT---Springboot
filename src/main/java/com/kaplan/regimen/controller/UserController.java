package com.kaplan.regimen.controller;
import com.kaplan.regimen.entities.User;
import com.kaplan.regimen.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    MyUserDetailsService userDetailsService;

    @GetMapping("/api/hello-world")
    public ResponseEntity<String>helloWorld(){
        return new ResponseEntity<>("Backend -- Working", HttpStatus.OK);
    }

    @PostMapping("/api/register")
    public ResponseEntity<User>userRegistration(@RequestBody User user){
       return new ResponseEntity<>(userDetailsService.createUser(user),
               HttpStatus.CREATED);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Boolean>userLogin(@RequestBody User user){

       return new ResponseEntity<>(this.userDetailsService.checkUserPassword(this.userDetailsService
                       .loadUserByUsername(user.getUsername()),user.getPassword()), HttpStatus.OK);
    }
}
