package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EngController {

    @RequestMapping(value = "/eng",method = RequestMethod.GET)
    public String getLanguage(){
        return "english";
    }
}
