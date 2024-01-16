package com.example.security.logout;

import com.example.security.jwtBlackList.JwtBlackList;
import com.example.security.jwtBlackList.JwtBlackListRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LogoutController {
    private final JwtBlackListRepository jwtBlackListRepository;
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request)
    {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);

            var jwtBlackLIst = JwtBlackList.builder()
                    .jwtToken(jwt).build();
            jwtBlackListRepository.save(jwtBlackLIst);
            return ResponseEntity.ok().build();

        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid Token");
    }

}
