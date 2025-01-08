package com.ourcompany.jpa;

import com.ourcompany.jpa.pk.CorporationUserPK;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "corporation_person_xref")
@IdClass(CorporationUserPK.class)
public class CorporationUser {
    @Id @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id_person", updatable = false)
    public Person person;

    @Id @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id_corporation", updatable = false)
    public Corporation corporation;
}
