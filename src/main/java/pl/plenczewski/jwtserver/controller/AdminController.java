package pl.plenczewski.jwtserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.plenczewski.jwtserver.security.*;
import pl.plenczewski.jwtserver.security.response.JwtResponse;

@RestController
public class AdminController {



    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/admin")
    public String getAdmin(){
        return "hello";
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity logins(@RequestBody LoginRequests loginRequests){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequests.getUsername(), loginRequests.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @GetMapping("check")
    public String check(){
        return "elo";
    }


}
