package com.ourcompany.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.test.context.TestPropertySource
import javax.sql.DataSource

@DataJpaTest
@EnableAutoConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableJpaRepositories(
    includeFilters = [ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = [NoticeRecipientRepository::class]
    )]
)
@EntityScan(basePackages = ["com.ourcompany.jpa"])
@TestPropertySource(
    properties = [
        "spring.jpa.hibernate.ddl-auto=create",
        "spring.jpa.defer-datasource-initialization=true",
        "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect",
    ]
)
class DocumentRecipientRepositoryTest {

    @Configuration
    class TestConfig{
        @Bean
        fun dataSource(environment: Environment?): DataSource {
            return EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseConnection.H2.type)
                .build()
        }
    }


    @Autowired
    lateinit var underTest: NoticeRecipientRepository

    @Test
    fun failingRepositoryRead() {
        println("Attempt 1 - pass")
        underTest.findByNoticeIdAndRecipientId(2100180, "srussell001")
        println("Attempt 2 - fails in Hibernate 6.6.x")
        underTest.findByNoticeIdAndRecipientId(2100180, "srussell001")
    }
}