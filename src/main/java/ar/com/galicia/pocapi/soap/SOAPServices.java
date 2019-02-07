package ar.com.galicia.pocapi.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class SOAPServices {

	private static final String SOAP_ACTION_URI = "http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP";

	@Autowired
	private WebServiceTemplate soapServiceTemplate;

//	public ForecastReturn getAdd(String zipCode) {
//
//		GetCityForecastByZIP request = new GetCityForecastByZIP();
//		request.setZIP(zipCode);
//
//		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) soapServiceTemplate
//				.marshalSendAndReceive(request, new SoapActionCallback(
//						SOAP_ACTION_URI));
//
//		return response.getGetCityForecastByZIPResult();
//	}
}
