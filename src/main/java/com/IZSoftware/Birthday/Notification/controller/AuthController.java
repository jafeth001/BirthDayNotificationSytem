package com.IZSoftware.Birthday.Notification.controller;

import com.IZSoftware.Birthday.Notification.dto.UserAuthenticateRequest;
import com.IZSoftware.Birthday.Notification.dto.UserAuthenticateResponse;
import com.IZSoftware.Birthday.Notification.dto.UserRegisterRequest;
import com.IZSoftware.Birthday.Notification.exception.ExcessUserException;
import com.IZSoftware.Birthday.Notification.exception.ResourceNotFoundException;
import com.IZSoftware.Birthday.Notification.exception.UserExistException;
import com.IZSoftware.Birthday.Notification.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register/{departmentId}")
    public ResponseEntity<UserAuthenticateResponse> register(@RequestBody UserRegisterRequest request,
                                                             @PathVariable("departmentId") Long departmentId)
            throws UserExistException, ResourceNotFoundException, ExcessUserException {
        return ResponseEntity.ok(authService.register(request, departmentId));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserAuthenticateResponse> authenticate(@RequestBody UserAuthenticateRequest request)
            throws UserExistException, ResourceNotFoundException {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
