package com.ourcompany.jpa;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Cacheable
@Entity
@DiscriminatorValue("PERS")
public class Person extends User {
    @Column(name = "surname")
    String surname;
}

