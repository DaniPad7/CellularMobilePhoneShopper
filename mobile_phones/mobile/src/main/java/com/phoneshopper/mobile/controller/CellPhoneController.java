package com.phoneshopper.mobile.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/cellphone-api")
public class CellPhoneController {

    @GetMapping(path = "/")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping(path = "/all")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("Hello");
    }
}
