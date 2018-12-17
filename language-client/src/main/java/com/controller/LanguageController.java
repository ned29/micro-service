package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LanguageController {

    private RestTemplate restTemplate;

    @Autowired
    private LanguageController(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/lang/{name}", method = RequestMethod.GET)
    public String getLanguage(@PathVariable String lang) {
        ResponseEntity<String> response;
        if (lang.equals("eng")) {
            response = restTemplate.getForEntity("/eng", String.class);
            return response.getBody();
        } else {
            response = restTemplate.getForEntity("/ukr", String.class);
            return response.getBody();
        }
    }
}