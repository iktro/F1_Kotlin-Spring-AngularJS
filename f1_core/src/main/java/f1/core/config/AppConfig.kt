package f1.core.config

import com.zaxxer.hikari.HikariConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["f1.core.service"])
open class AppConfig {
    @Bean
    open fun dbConfiguration(): HikariConfig {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:mysql://" + DB_HOST + "/" + DB_SCHEMA + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"
        config.username = DB_USER
        config.password = DB_PASSWORD
        config.addDataSourceProperty("cachePrepStmts", "true")
        config.addDataSourceProperty("prepStmtCacheSize", "250")
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
        config.driverClassName = "com.mysql.cj.jdbc.Driver"
        return config
    }

    companion object {
        const val DB_HOST = "localhost:3306"
        const val DB_SCHEMA = "f1"
        const val DB_USER = "iktro_root"
        const val DB_PASSWORD = "root"
    }
}