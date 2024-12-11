package com.ourcompany.jpa

import jakarta.persistence.Cacheable
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Cacheable
@Entity
@DiscriminatorValue("CORP")
class Corporation : User() {
    @Column(name = "corporate_name")
    var corporateName: String? = null
}
