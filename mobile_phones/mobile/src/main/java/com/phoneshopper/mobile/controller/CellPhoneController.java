package com.phoneshopper.mobile.controller;


import com.phoneshopper.mobile.model.CellPhone;
import com.phoneshopper.mobile.service.CellPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController(value = "/cellphone-api")
public class CellPhoneController {
    private final String MIME_TYPE="application/json";
    private final CellPhoneService cellPhoneService;

    @Autowired()
    public CellPhoneController(CellPhoneService cellPhoneService) {
        this.cellPhoneService = cellPhoneService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping(path = "/new", consumes = MIME_TYPE, produces = MIME_TYPE)
    public ResponseEntity<CellPhone> createCellPhone(@Valid() @RequestBody()CellPhone cell) {
        /*Add Interceptor before every request that will make sure there is a Jwt*/
        return ResponseEntity.status(201).body(cellPhoneService.createCellPhone(cell));


    }

    @GetMapping(path = "/all")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("Hello");
    }
}
