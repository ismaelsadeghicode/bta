package com.mapsa.springsecurity.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Admin,User;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
