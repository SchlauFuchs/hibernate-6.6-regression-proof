package com.ourcompany.jpa.pk;

import com.ourcompany.jpa.Document;
import com.ourcompany.jpa.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DocumentReceiverPK implements Serializable {
    @NonNull
    Document document;
    @NonNull
    User user;
}
