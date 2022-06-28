package com.phoneshopper.mobile.controller;


import com.phoneshopper.mobile.model.CellPhone;
import com.phoneshopper.mobile.service.CellPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping(value = "/cellphone-api")
public class CellPhoneController {
    private final String MIME_TYPE="application/json";
    private final CellPhoneService cellPhoneService;

    @Autowired()
    public CellPhoneController(CellPhoneService cellPhoneService) {
        this.cellPhoneService = cellPhoneService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping(value = "/new", consumes = MIME_TYPE, produces = MIME_TYPE)
    public ResponseEntity<CellPhone> createCellPhone(@Valid() @RequestBody()CellPhone cell) {
        /*Add Interceptor before every request that will make sure there is a Jwt*/
        return ResponseEntity.status(201).body(cellPhoneService.createCellPhone(cell));


    }

    @GetMapping(value = "/all")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("Hello");
    }
}
