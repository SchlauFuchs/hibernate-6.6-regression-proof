package com.ourcompany.jpa.embedded;

import com.ourcompany.jpa.Corporation;
import com.ourcompany.jpa.CorporationUser;
import com.ourcompany.jpa.Person;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Embeddable
public class Owner {
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_owner_corporation")
    Corporation corporation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "user_id_owner_corporation", referencedColumnName = "user_id_corporation", insertable = false, updatable = false),
            @JoinColumn(name = "owner", referencedColumnName = "user_id_person", insertable = false, updatable = false),
    })
    CorporationUser firmUser;

}
