package com.ourcompany.jpa;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Cacheable
@Entity
@DiscriminatorValue("CORP")
public class Corporation extends User {
    @Column(name = "corporate_name")
    String corporateName;
}
