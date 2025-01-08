package com.ourcompany.jpa;

import com.ourcompany.jpa.embedded.Owner;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "documents")
public class Document {
    @NonNull
    @Column(nullable = false, insertable = false, updatable = false)
    @Id
    public Integer id = 0;

    @NonNull
    @Embedded
    public Owner owner = new Owner();

    @NonNull
    @OneToMany(mappedBy = "document")
    public List<DocumentReceiver> recipients= new ArrayList<>();
}
