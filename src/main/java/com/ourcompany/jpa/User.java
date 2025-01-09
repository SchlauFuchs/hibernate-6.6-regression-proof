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
}
