package f1.web

import f1.core.config.AppConfig
import f1.core.config.DBConfig
import f1.web.config.WSConfig
import org.apache.cxf.transport.servlet.CXFServlet
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
import javax.servlet.ServletContext

class Initializer : AbstractAnnotationConfigDispatcherServletInitializer() {

    override fun onStartup(servletContext: ServletContext) {
        super.onStartup(servletContext)
        val servlet = servletContext.addServlet("cxfServlet", CXFServlet())
        servlet.setLoadOnStartup(1)
        servlet.addMapping("/api/*")
    }

    override fun getRootConfigClasses(): Array<Class<*>> {
        return arrayOf(AppConfig::class.java, DBConfig::class.java, WSConfig::class.java)
    }

    override fun getServletConfigClasses(): Array<Class<*>> {
        return arrayOf()
    }

    override fun getServletMappings(): Array<String> {
        return arrayOf("/web/")
    }
}