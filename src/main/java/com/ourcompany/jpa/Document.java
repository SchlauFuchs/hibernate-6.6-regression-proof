package com.ourcompany.jpa;

import com.ourcompany.jpa.embedded.Owner;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "documents")
public class Document {
    @Column(nullable = false, insertable = false, updatable = false)
    @Id
    public Integer id = 0;

    @Embedded
    public Owner owner = new Owner();

}
