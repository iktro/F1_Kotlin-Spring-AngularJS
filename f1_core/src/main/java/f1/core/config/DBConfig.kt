package f1.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ["f1.core.dao"])
open class DBConfig {
    @Bean(destroyMethod = "close")
    open fun dataSource(dbConfiguration: HikariConfig?): DataSource {
        return HikariDataSource(dbConfiguration)
    }

    @Bean
    open fun entityManager(entityManagerFactory: EntityManagerFactory): EntityManager {
        return entityManagerFactory.createEntityManager()
    }

    @Bean
    open fun transactionManager(entityManagerFactory: EntityManagerFactory?, dataSource: DataSource?): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory
        transactionManager.dataSource = dataSource
        return transactionManager
    }

    @Bean
    open fun entityManagerFactory(dataSource: DataSource?): EntityManagerFactory {
        val vendorAdapter = HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl(true)
        val factory = LocalContainerEntityManagerFactoryBean()
        factory.jpaVendorAdapter = vendorAdapter
        factory.jpaPropertyMap["hibernate.dialect"] = "org.hibernate.dialect.MySQL5Dialect"
        factory.setPackagesToScan("f1.project.entity")
        factory.dataSource = dataSource
        factory.afterPropertiesSet()
        return factory.getObject()
    }
}