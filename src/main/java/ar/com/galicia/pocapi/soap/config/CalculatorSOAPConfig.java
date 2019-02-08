package ar.com.galicia.pocapi.soap.config;

import ar.com.galicia.pocapi.soap.CalculatorSOAPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalculatorSOAPConfig {
    @Value("${soap.calculator.url}")
    private String calculatorUrl;
    @Value(("${soap.calculator.package}"))
    private String calculatorPackage;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath(calculatorPackage);
        return marshaller;
    }

    @Bean
    public CalculatorSOAPClient soapClient(Jaxb2Marshaller marshaller) {
        CalculatorSOAPClient client = new CalculatorSOAPClient();

        client.setDefaultUri(calculatorUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
