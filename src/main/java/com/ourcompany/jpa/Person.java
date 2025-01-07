package com.ourcompany.jpa

import jakarta.persistence.Cacheable
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Cacheable
@Entity
@DiscriminatorValue("PERS")
class Person : User() {
    @Column(name = "surname")
    var surname: String? = null
}
