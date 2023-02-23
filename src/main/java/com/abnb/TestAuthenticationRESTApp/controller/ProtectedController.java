package com.abnb.TestAuthenticationRESTApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedController {
    
    @RequestMapping(value = "proc", method = RequestMethod.GET)
    public String data() {
            return "GREAT protected Controller API";
    }
}
