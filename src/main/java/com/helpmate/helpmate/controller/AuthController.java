package com.helpmate.helpmate.controller;

import com.helpmate.helpmate.entity.Role;
import com.helpmate.helpmate.entity.User;
import com.helpmate.helpmate.entity.enums.RoleType;
import com.helpmate.helpmate.payload.JWTAuthResponse;
import com.helpmate.helpmate.payload.LoginDto;
import com.helpmate.helpmate.payload.SignUpDto;
import com.helpmate.helpmate.repository.RoleRepository;
import com.helpmate.helpmate.repository.UserRepository;
import com.helpmate.helpmate.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@Api(value = "Auth controller exposes signIn and signUp REST APIs")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

   // @ApiOperation(value = "REST API to Register or Signup user to QuickShopper")
    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //get token from tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

    //@ApiOperation(value = "REST API to SignIn or LogIn user to QuickShopper")
    @PostMapping("/user/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        //check if email exists in DatabaseSys
        Optional<User> existingUser = userRepository.findUserByEmail(signUpDto.getEmail());
        System.out.println(existingUser.isPresent());
        if(existingUser.isPresent()){
            return new ResponseEntity<>("Email already exists!", HttpStatus.BAD_REQUEST);
        }

        //create user object
        User user = new User();
        user.setFirstname(signUpDto.getFirstname());
        user.setLastname(signUpDto.getLastname());
        user.setEmail(signUpDto.getEmail());
        user.setPhoneNo(signUpDto.getPhoneNo());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role role = roleRepository.findRoleByRoleType(RoleType.USER);
        user.setRole(role);


        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
