package ar.com.galicia.pocapi.soap;

import ar.com.galicia.pocapi.soap.client.Divide;
import ar.com.galicia.pocapi.soap.client.DivideResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CalculatorSOAPClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CalculatorSOAPClient.class);
    @Value("${soap.calculator.url}")
    private String calculatorUrl;





    public DivideResponse divide(int dividend, int divider) {

        Divide request = new Divide();
        request.setIntA(dividend);
        request.setIntB(divider);
        log.info("Requesting divide for " + dividend+"/"+ divider);


        DivideResponse response = (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(calculatorUrl, request,
                        new SoapActionCallback(
                                "http://tempuri.org/Divide"));

        return response;
    }
//    public AddResponse add(int number1, int number2) {
//
//
//       log.info("Requesting add for " + number1 +" and "+number2);
////
//        int result = calc.getCalculatorSoap().add(number1,number2);
//        AddResponse response=new AddResponse();
//        response.setAddResult(result);
//        return response;
//    }
//    public DivideResponse divide(int dividend, int divider) {
//
//        int result = calc.getCalculatorSoap().divide(dividend,divider);
//        DivideResponse response=new DivideResponse();
//        response.setDivideResult(result);
//        return response;
//
//    }
}
