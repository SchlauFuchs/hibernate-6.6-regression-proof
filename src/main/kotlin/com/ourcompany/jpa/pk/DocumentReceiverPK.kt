package com.ourcompany.jpa.pk

import com.ourcompany.jpa.Document
import com.ourcompany.jpa.User
import lombok.NoArgsConstructor
import java.io.Serializable

@NoArgsConstructor
data class DocumentReceiverPK(
    var document: Document,
    var user: User,
) : Serializable
