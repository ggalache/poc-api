package ar.com.galicia.pocapi.spring.config;

import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.common.ext.WSSecurityException.ErrorCode;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.message.token.UsernameToken;
import org.apache.wss4j.dom.validate.Credential;
import org.apache.wss4j.dom.validate.UsernameTokenValidator;
import org.apache.wss4j.dom.validate.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CommonSoapConfig {


}
