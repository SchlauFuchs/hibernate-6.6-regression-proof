package com.ourcompany.repository

import com.ourcompany.jpa.DocumentReceiver
import com.ourcompany.jpa.pk.DocumentReceiverPK
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface NoticeRecipientRepository : JpaRepository<DocumentReceiver, DocumentReceiverPK> {
    @Query(
        """
        SELECT r FROM DocumentReceiver r 
        JOIN FETCH r.document 
        WHERE r.document.id = :noticeId AND r.user.id = :recipientId
        """,
    )
    fun findByNoticeIdAndRecipientId(
        noticeId: Int,
        recipientId: String,
    ): Optional<DocumentReceiver>
}
