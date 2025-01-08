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
@DiscriminatorValue("CORP")
public class Corporation extends User {
    @Column(name = "corporate_name")
    String corporateName;
}
