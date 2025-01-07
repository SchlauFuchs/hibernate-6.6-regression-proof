package com.ourcompany.jpa

import com.ourcompany.jpa.pk.DocumentReceiverPK
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "document_receiver")
@IdClass(DocumentReceiverPK::class)
class DocumentReceiver : Target {
    override val recipientId
        get() = user.id

    @Id
    @ManyToOne
    @JoinColumn(name = "document_id", updatable = false)
    override lateinit var document: Document

    @Id
    @ManyToOne(targetEntity = User::class)
    @JoinColumn(name = "usr_id", updatable = false)
    lateinit var user: User

    @ManyToOne
    @JoinColumn(name = "user_id_corporation")
    var firm: Corporation? = null
}
