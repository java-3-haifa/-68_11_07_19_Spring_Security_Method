package com.teran.securitymethod.business;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public String unsecured() {
        return "Unsecured service message";
    }

    @Override
    public String secured() {
        return "Secured message service";
    }

    @Override
    public String otherSecured() {
        return "Other secured message service";
    }

    @Override
    public String annotationSecured() {
        return "Annotation secured message";
    }
}
