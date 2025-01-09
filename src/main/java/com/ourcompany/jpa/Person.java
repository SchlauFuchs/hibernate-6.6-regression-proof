package com.ourcompany.jpa;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Cacheable
@Entity
@DiscriminatorValue("PERS")
public class Person extends User {
    @Column(name = "surname")
    String surname;
}

