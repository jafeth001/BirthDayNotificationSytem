package com.IZSoftware.Birthday.Notification.service;

import com.IZSoftware.Birthday.Notification.config.JwtService;
import com.IZSoftware.Birthday.Notification.dto.UserAuthenticateRequest;
import com.IZSoftware.Birthday.Notification.dto.UserAuthenticateResponse;
import com.IZSoftware.Birthday.Notification.dto.UserRegisterRequest;
import com.IZSoftware.Birthday.Notification.entity.*;
import com.IZSoftware.Birthday.Notification.enums.UserRole;
import com.IZSoftware.Birthday.Notification.exception.ExcessUserException;
import com.IZSoftware.Birthday.Notification.exception.ResourceNotFoundException;
import com.IZSoftware.Birthday.Notification.exception.UserExistException;
import com.IZSoftware.Birthday.Notification.repository.DepartmentRepository;
import com.IZSoftware.Birthday.Notification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public UserAuthenticateResponse register(UserRegisterRequest request, Long departmentId) throws UserExistException, ResourceNotFoundException, ExcessUserException {
        Optional<Department> department = (departmentRepository.findById(departmentId)) ;
        if(department.isEmpty()){
            throw new ResourceNotFoundException("Department not found, " + departmentId);
        }
        var savedUser = userRepository.findByEmail(request.getEmail());
        if(savedUser != null){
            throw new UserExistException("User already exist, " + request.getEmail());
        }
        if(userRepository.count()==10){
            throw new ExcessUserException("Department cannot have more than  10 users");
        }
        var user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setDepartment(department.get());
        user.setRole(UserRole.USER);
        user.setBirthday(request.getBirthday());

        userRepository.save(user);
        var token = jwtService.generatetoken(user);
        var userAuthenticateResponse = new UserAuthenticateResponse();
        userAuthenticateResponse.setToken(token);
        userAuthenticateResponse.setMessage("Account Created Successfully, " + request.getEmail());
        return userAuthenticateResponse;

    }

    public UserAuthenticateResponse authenticate(UserAuthenticateRequest request) throws ResourceNotFoundException {
        var savedUser = userRepository.findByEmail(request.getEmail());
        if(savedUser==null){
            throw new ResourceNotFoundException("User not found, " + request.getEmail());
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail());
        var token = jwtService.generatetoken(user);
        var userAuthenticateResponse = new UserAuthenticateResponse();
        userAuthenticateResponse.setToken(token);
        userAuthenticateResponse.setMessage("Login Successfully, " + request.getEmail());
        return userAuthenticateResponse;
    }
}
