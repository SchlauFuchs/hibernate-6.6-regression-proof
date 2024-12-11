package com.ourcompany.jpa.pk

import lombok.NoArgsConstructor
import java.io.Serializable
import java.util.*

@NoArgsConstructor
data class CorporationUserPK(
    var person: String,
    var corporation: String,
) : Serializable {
    override fun equals(other: Any?): Boolean {
        return if (this === other) {
            true
        } else if (other is CorporationUserPK) {
            person == other.person && corporation == other.corporation
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(person, corporation)
    }
}
