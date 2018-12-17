package com.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LanguageController {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/lang/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> getLanguage(@PathVariable String lang, Model model) {
        ResponseEntity<String> response;
        if (lang.equals("eng")) {
            response = restTemplate.getForEntity(eurekaClient.getNextServerFromEureka("eng-client", false).getHomePageUrl() + "/eng", String.class);
            model.addAttribute("lang", response.getBody());
            return ResponseEntity.ok("index");
        } else {
            response = restTemplate.getForEntity(eurekaClient.getNextServerFromEureka("eng-client", false).getHomePageUrl() + "/ukr", String.class);
            model.addAttribute("lang", response.getBody());
            return ResponseEntity.ok("index");
        }
    }
}