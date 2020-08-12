package com.test.model;

import com.test.persistence.Column;
import com.test.persistence.Entity;
import com.test.persistence.Id;
import com.test.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @Column(name = "ID", dataType = "NUMBER", length = 5)
    private Long id;
    @Column(name = "FIRST_NAME", dataType = "VARCHAR", length = 50)
    private String firstName;
    @Column(name = "LAST_NAME", dataType = "VARCHAR", length = 50)
    private String lastName;
    @Column(name = "AGE", dataType = "NUMBER", length = 3)
    private int age;
    @Column(name = "NATIONAL_CARD", dataType = "VARCHAR", length = 10)
    private String nationalCard;
    @Column(name = "EMAIL", dataType = "VARCHAR", length = 100)
    private String email;
    @Column(name = "PASS", dataType = "VARCHAR", length = 50)
    private String pass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id ||
                nationalCard == person.nationalCard ||
                email == person.email;
    }

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, int age, String nationalCard, String email, String pass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationalCard = nationalCard;
        this.email = email;
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nationalCard, email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationalCard() {
        return nationalCard;
    }

    public void setNationalCard(String nationalCard) {
        this.nationalCard = nationalCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
