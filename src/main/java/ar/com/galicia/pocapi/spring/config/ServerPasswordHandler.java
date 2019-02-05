package ar.com.galicia.pocapi.spring.config;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;

@Component
public class ServerPasswordHandler implements CallbackHandler {

	@Override
		public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
	        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
	   	 
	        if (pc.getIdentifier().equals("esurijon")) {
	        	//pc.setPassword("baufest.2018");
	        } else {
	        	throw new IOException("invalid user name");
	        } 
			
		}

}