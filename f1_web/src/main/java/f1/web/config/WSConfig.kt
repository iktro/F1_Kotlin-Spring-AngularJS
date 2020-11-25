package f1.web.config

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import f1.web.controller.RestController
import org.apache.cxf.Bus
import org.apache.cxf.endpoint.Server
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import java.util.*

@Configuration
@ComponentScan("f1.web.controller")
@ImportResource("classpath:META-INF/cxf/cxf.xml")
open class WSConfig {
    @Bean
    open fun jaxrsServer(jsonProvider: JacksonJsonProvider?, cxfBus: Bus?, controllers: List<RestController>?): Server {
        val sf = JAXRSServerFactoryBean()
        val serviceBeans: List<Any> = ArrayList<Any>(controllers)
        sf.setServiceBeans(serviceBeans)
        sf.providers = listOf(jsonProvider)
        sf.address = "/"
        sf.bus = cxfBus
        return sf.create()
    }

    @Bean
    open fun jsonProvider(): JacksonJsonProvider {
        return JacksonJsonProvider()
    }
}