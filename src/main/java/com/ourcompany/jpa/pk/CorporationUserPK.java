package com.ourcompany.jpa.pk;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data @NoArgsConstructor
public class CorporationUserPK implements Serializable {
    @NonNull
    public String person;
    @NonNull
    public String corporation;

}
