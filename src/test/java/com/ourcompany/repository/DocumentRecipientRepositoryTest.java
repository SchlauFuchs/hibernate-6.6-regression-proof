package com.ourcompany.repository

import com.ourcompany.jpa.DocumentReceiver
import jakarta.persistence.Entity
import jakarta.persistence.EntityManager
import org.h2.tools.RunScript
import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.reflections.Reflections

class DocumentRecipientRepositoryTest {
    @Test
    fun failingRepositoryRead() {
        println("Attempt 1 - pass")
        entityManager.createQuery(
            "SELECT r FROM DocumentReceiver r \n" +
                "JOIN FETCH r.document \n" +
                "WHERE r.document.id = :noticeId AND r.user.id = :recipientId",
            DocumentReceiver::class.java,
        )
            .setParameter("noticeId", 2100180)
            .setParameter("recipientId", "srussell001")
            .resultList

        println("Attempt 2 - fails in Hibernate 6.6.x")
        entityManager.createQuery(
            "SELECT r FROM DocumentReceiver r \n" +
                "JOIN FETCH r.document \n" +
                "WHERE r.document.id = :noticeId AND r.user.id = :recipientId",
            DocumentReceiver::class.java,
        )
            .setParameter("noticeId", 2100180)
            .setParameter("recipientId", "srussell001")
            .resultList
    }

    companion object {
        private lateinit var sessionFactory: SessionFactory
        private lateinit var entityManager: EntityManager

        @JvmStatic
        @BeforeAll
        fun setup() {
            val registry =
                StandardServiceRegistryBuilder()
                    .applySetting("hibernate.connection.url", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
                    .applySetting("hibernate.connection.driver_class", "org.h2.Driver")
                    .applySetting("hibernate.hbm2ddl.auto", "create-drop")
                    .applySetting("hibernate.show_sql", "true")
                    .build()

            try {
                val metadata = MetadataSources(registry)
                val reflections = Reflections("com.ourcompany.jpa")
                reflections.getTypesAnnotatedWith(Entity::class.java)
                    .forEach { metadata.addAnnotatedClass(it) }

                sessionFactory = metadata.buildMetadata().buildSessionFactory()

                entityManager = sessionFactory.createEntityManager()
                Thread.currentThread().contextClassLoader.getResourceAsStream("data.sql")!!.use { data ->
                    sessionFactory.openSession().use { session ->
                        session.doWork { connection ->
                            RunScript.execute(
                                connection,
                                data.bufferedReader(),
                            )
                            connection.commit()
                        }
                    }
                }
            } catch (e: Exception) {
                StandardServiceRegistryBuilder.destroy(registry)
                throw e
            }
        }

        @JvmStatic
        @AfterAll
        fun tearDown() {
            entityManager.close()
        }
    }
}
