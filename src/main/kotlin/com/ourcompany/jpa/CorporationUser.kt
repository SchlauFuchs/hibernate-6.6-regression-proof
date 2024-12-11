package com.ourcompany.jpa

import com.ourcompany.jpa.pk.CorporationUserPK
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "corporation_person_xref")
@IdClass(CorporationUserPK::class)
class CorporationUser {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id_person", updatable = false)
    lateinit var person: Person

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id_corporation", updatable = false)
    lateinit var corporation: Corporation

}
