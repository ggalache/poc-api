package ar.com.galicia.pocapi.spring.monitoring.health.soap;

import ar.com.galicia.pocapi.soap.CalculatorSOAPClient;
import ar.com.galicia.pocapi.soap.client.AddResponse;
import ar.com.galicia.pocapi.soap.client.DivideResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.WebServiceIOException;

@Component
public class SOAPServiceHealthIndicator implements HealthIndicator {
    @Autowired
    private CalculatorSOAPClient calcService;
    @Override
    public Health health() {
        try {
            DivideResponse result = calcService.divide(1, 1);
        }catch(WebServiceIOException e){
            return Health.down().withException(e.getRootCause()).build();
        }
        return Health.up().build();
    }
}
