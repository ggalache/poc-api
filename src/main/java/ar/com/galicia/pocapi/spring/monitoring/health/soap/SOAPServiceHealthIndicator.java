package ar.com.galicia.pocapi.spring.monitoring.health.soap;

import ar.com.galicia.pocapi.soap.CalculatorSOAPClient;
import ar.com.galicia.pocapi.soap.client.AddResponse;
import ar.com.galicia.pocapi.soap.client.DivideResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.WebServiceTransformerException;
import org.springframework.ws.soap.client.SoapFaultClientException;

import java.io.IOException;

@Component
public class SOAPServiceHealthIndicator implements HealthIndicator {
    @Autowired
    private CalculatorSOAPClient calcService;
    @Override
    public Health health() {
        try {
            DivideResponse result = calcService.divide(1, 1);
        }
        catch (  WebServiceTransformerException e){
            return Health.unknown().withException(e.getRootCause()).build();
        }
        catch (SoapFaultClientException e){
            return Health.unknown().withException(e).build();
        }
        catch(WebServiceIOException e){
            return Health.down(e).build();
        }
        return Health.up().build();
    }
}
