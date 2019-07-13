package com.teran.securitymethod.controller;


import com.teran.securitymethod.business.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    MessageService service;

    @GetMapping("unsecured")
    public String getUnsecured() {
        return service.unsecured();
    }

    @GetMapping("secured")
    public String getSecured() {
        System.out.println("Secured method");
        return service.secured();
    }

    @GetMapping("otherSecured")
    public String getOtherSecured() {
        System.out.println("Other secured method");
        return service.otherSecured();
    }

    @GetMapping("annotationSecured")
    public String getAnnotationSecured() {
        System.out.println("Annotation secured method");
        return service.annotationSecured();
    }
}
