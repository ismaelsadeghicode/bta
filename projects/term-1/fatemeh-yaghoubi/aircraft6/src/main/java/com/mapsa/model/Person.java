package com.mapsa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Data
@Table(name = "Person")
public class Person {
    private long id;
    private String age;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String phone;

    @Id
    @Column(name = "ID", table = "PERSON")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AGE", table = "PERSON")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "FIRST_NAME", table = "PERSON")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", table = "PERSON")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "NATIONAL_CODE", table = "PERSON")
    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Basic
    @Column(name = "PHONE", table = "PERSON")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(age, person.age) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(nationalCode, person.nationalCode) &&
                Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, firstName, lastName, nationalCode, phone);
    }
}
