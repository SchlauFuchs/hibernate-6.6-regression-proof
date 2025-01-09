package com.ourcompany.jpa;

import jakarta.persistence.Cacheable;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Cacheable
@Table(name = "users")
@DiscriminatorColumn(name = "type")
@Entity
public abstract class User {
    @Id
    String id;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "id='" + id + '\'' +
                '}';
    }
}
