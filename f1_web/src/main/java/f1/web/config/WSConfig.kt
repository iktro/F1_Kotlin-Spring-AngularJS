package f1.web.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import f1.web.controller.RestController;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan({"f1.web.controller"})
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public
class WSConfig {

    @Bean
    public Server jaxrsServer(JacksonJsonProvider jsonProvider, Bus cxfBus, List<RestController> controllers) {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        List<Object> serviceBeans = new ArrayList<>(controllers);
        sf.setServiceBeans(serviceBeans);
        sf.setProviders(Collections.singletonList(jsonProvider));
        sf.setAddress("/");
        sf.setBus(cxfBus);
        return sf.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }
}