package com.ourcompany.jpa

import com.ourcompany.jpa.embedded.Owner
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "documents")
class Document {
    @Column(nullable = false, insertable = false, updatable = false)
    @Id
    var id: Int = 0

    @Embedded
    var owner: Owner = Owner()

    @OneToMany(mappedBy = "document")
    var recipients: MutableList<DocumentReceiver> = mutableListOf()
}
