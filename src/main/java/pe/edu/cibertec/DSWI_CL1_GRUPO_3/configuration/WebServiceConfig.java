package pe.edu.cibertec.DSWI_CL1_GRUPO_3.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "pregunta2")
    public DefaultWsdl11Definition prestamoWsdl11Definition(XsdSchema prestamoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PrestamoPort");
        wsdl11Definition.setLocationUri("/ws/pregunta2");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws1/objects");
        wsdl11Definition.setSchema(prestamoSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema prestamoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/pregunta2.xsd"));
    }

    @Bean(name = "pregunta2-2")
    public DefaultWsdl11Definition numeroWsdl11Definition(XsdSchema numeroSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("NumeroPort");
        wsdl11Definition.setLocationUri("/ws/pregunta2-2");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws2/objects");
        wsdl11Definition.setSchema(numeroSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema numeroSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/pregunta2-2.xsd"));
    }

    @Bean(name = "pregunta2-3")
    public DefaultWsdl11Definition resultadoWsdl11Definition(XsdSchema resultadoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ResultadoPort");
        wsdl11Definition.setLocationUri("/ws/pregunta2-3");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws3/objects");
        wsdl11Definition.setSchema(resultadoSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema resultadoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/pregunta2-3.xsd"));
    }

    //Dios ya no más
    @Bean(name = "pregunta2-4")
    public DefaultWsdl11Definition compraWsdl11Definition(XsdSchema compraSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CompraPort");
        wsdl11Definition.setLocationUri("/ws/pregunta2-4");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws4/objects");
        wsdl11Definition.setSchema(compraSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema compraSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/pregunta2-4.xsd"));
    }

    @Bean(name = "preguntafinal")
    public DefaultWsdl11Definition anioWsdl11Definition(XsdSchema anioSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("FinalPort");
        wsdl11Definition.setLocationUri("/ws/preguntafinal");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws5/objects");
        wsdl11Definition.setSchema(anioSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema anioSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/preguntafinal.xsd"));
    }



    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "personajes")
    public DefaultWsdl11Definition personajeWsdl11Definition(XsdSchema personajeSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PersonajesPort");
        wsdl11Definition.setLocationUri("/ws/personajes");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(personajeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema personajeSchema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/personaje.xsd"));
    }

}