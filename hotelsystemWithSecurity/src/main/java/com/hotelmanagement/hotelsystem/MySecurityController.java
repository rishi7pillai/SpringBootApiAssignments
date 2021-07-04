package com.hotelmanagement.hotelsystem;

import com.hotelmanagement.hotelsystem.models.AuthenticationRequest;
import com.hotelmanagement.hotelsystem.models.AuthenticationResponse;
import com.hotelmanagement.hotelsystem.util.JwtUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Controller
public class MySecurityController {
    @Autowired
    UserOneRepo userOneRepo;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

         final UserDetails userDetails =  userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
         final String jwt = jwtTokenUtil.generateToken(userDetails);

         return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/")
    public String home(){
       return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/user/get")
    public List<UserOne> getAllUser(){
        return userOneRepo.findAll();
    }

    @PostMapping("user/post")
    public UserOne postUser(@Valid @RequestBody UserOne userOne){

        UserOne user =new UserOne(userOne.getUserName(),passwordEncoder.encode(userOne.getPassword()),userOne.isActive(),userOne.getRoles());

        return userOneRepo.save(user);
    }

}
