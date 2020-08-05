package com.test.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Person {
    private String name;
    private String password;
    private String email;
    private Date dateOfRegistering=new Date();


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfRegistering() {
        return dateOfRegistering;
    }

    public Person(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Person(){}

    public static boolean checkEmail(String email){
        if(email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
    return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", dateOfRegistering=" + dateOfRegistering ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
    public boolean checkPassword(String password){
        if(this.password.equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
