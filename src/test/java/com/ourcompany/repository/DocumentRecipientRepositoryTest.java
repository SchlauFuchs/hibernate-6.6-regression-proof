package com.ourcompany.repository;

import com.ourcompany.jpa.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class DocumentRecipientRepositoryTest {

    static SessionFactory sessionFactory;
    static EntityManager entityManager;

    @Test
    public void failingDocumentRead() {
        System.out.println("Attempt 1 - pass");
        String query = "SELECT d FROM Document d";
        entityManager.createQuery(query, Document.class).getResultList();

        System.out.println("Attempt 2 - fails in Hibernate 6.6.x");
        entityManager.createQuery(query, Document.class).getResultList();
    }

    @BeforeAll
    static void setup() throws IOException {
        var registry = new
                StandardServiceRegistryBuilder()
                .applySetting("hibernate.connection.url", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
                .applySetting("hibernate.connection.driver_class", "org.h2.Driver")
                .applySetting("hibernate.hbm2ddl.auto", "create-drop")
                .applySetting("hibernate.show_sql", "true")
                .build();

        try {
            var metadata = new MetadataSources(registry);
            var reflections = new Reflections("com.ourcompany.jpa");
            reflections.getTypesAnnotatedWith(Entity.class).iterator().forEachRemaining(metadata::addAnnotatedClass);

            sessionFactory = metadata.buildMetadata().buildSessionFactory();

            entityManager = sessionFactory.createEntityManager();
            try (InputStream data = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.sql")) {
                try (Session session = sessionFactory.openSession()) {
                    session.doWork(connection -> {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(data));
                        RunScript.execute(connection, reader);
                        connection.commit();
                    });
                }
            }
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
    }

    @AfterAll
    static void tearDown() {
        entityManager.close();
    }
}

