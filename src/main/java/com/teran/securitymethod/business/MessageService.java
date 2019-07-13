package com.teran.securitymethod.business;

import com.teran.securitymethod.config.AdminRole;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.RolesAllowed;

public interface MessageService {

    String unsecured();

    @Secured("ROLE_ADMIN")
    String secured();

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GUEST')")
    String otherSecured();

    @AdminRole
    String annotationSecured();
}
