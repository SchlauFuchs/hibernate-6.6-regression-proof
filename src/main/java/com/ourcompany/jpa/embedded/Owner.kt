package com.ourcompany.jpa.embedded

import com.ourcompany.jpa.Corporation
import com.ourcompany.jpa.CorporationUser
import com.ourcompany.jpa.Person
import jakarta.persistence.Embeddable
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinColumns
import jakarta.persistence.ManyToOne

@Embeddable
class Owner {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    lateinit var person: Person

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_owner_corporation")
    var corporation: Corporation? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(
        JoinColumn(name = "user_id_owner_corporation", referencedColumnName = "user_id_corporation", insertable = false, updatable = false),
        JoinColumn(name = "owner", referencedColumnName = "user_id_person", insertable = false, updatable = false),
    )
    var firmUser: CorporationUser? = null
}
