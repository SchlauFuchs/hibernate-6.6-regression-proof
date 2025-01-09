package com.ourcompany.jpa.pk;

import com.ourcompany.jpa.Document;
import com.ourcompany.jpa.User;

import java.io.Serializable;

public class DocumentReceiverPK implements Serializable {
    Document document;
    User user;
}
