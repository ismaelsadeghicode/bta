package com.example.jwt;


import org.springframework.security.core.GrantedAuthority;

public enum Roule implements GrantedAuthority {
admin,user;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
