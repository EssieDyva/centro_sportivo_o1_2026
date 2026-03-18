package com.betacom.jpa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.enums.Role;

@RestController
@RequestMapping("/rest/role")
public class RoleController {
    
    @GetMapping("/list")
    public ResponseEntity<List<Role>> list() {
        List<Role> roles = Arrays.asList(Role.values());
        return ResponseEntity.ok(roles);
    }
}