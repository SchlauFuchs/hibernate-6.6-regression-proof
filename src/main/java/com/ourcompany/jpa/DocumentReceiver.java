package com.ourcompany.jpa;

import com.ourcompany.jpa.pk.DocumentReceiverPK;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "document_receiver")
@IdClass(DocumentReceiverPK.class)
public class DocumentReceiver {

    @Id
    @ManyToOne
    @JoinColumn(name = "document_id", updatable = false)
    public Document document;

    @Id
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "usr_id", updatable = false)
    public User user;

    @ManyToOne
    @JoinColumn(name = "user_id_corporation")
    public Corporation  firm;
}
