package com.abnb.TestAuthenticationRESTApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @RequestMapping(value = "noproc", method = RequestMethod.GET)
    public String data() {
            return "Data from Test Unprotected Controller API";
    }
}
