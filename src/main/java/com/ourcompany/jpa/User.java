package com.ourcompany.jpa

import jakarta.persistence.Cacheable
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Cacheable
@Table(name = "users")
@DiscriminatorColumn(name = "type")
@Entity
abstract class User {
    @Id
    lateinit var id: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return if (other is User) id == other.id else false
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
