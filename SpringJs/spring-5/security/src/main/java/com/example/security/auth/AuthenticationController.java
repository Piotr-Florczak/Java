package com.example.security.auth;

import com.example.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor


public class AuthenticationController {

    private final  UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<?> register( @RequestBody RegisterRequest request)
    {

        if ( ! userRepository.findByEmail(request.getEmail()).isEmpty())
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User already exists");
        }
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate( @RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(service.authenticate(request));
    }


    
    @GetMapping("/test")
    public String test()
    {
        logger.info("logger works");
        return "works:)";
    }


}
