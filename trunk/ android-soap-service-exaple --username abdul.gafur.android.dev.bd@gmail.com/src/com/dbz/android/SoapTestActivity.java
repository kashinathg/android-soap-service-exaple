package com.dbz.android;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SoapTestActivity extends Activity {

	 private static final String METHOD_NAME = "Cities";
	 private static final String SOAP_ACTION = "http://footballpool.dataaccess.eu/Cities";
	 private static final String NAMESPACE = "http://footballpool.dataaccess.eu";
	 private static final String URL = "http://footballpool.dataaccess.eu/data/info.wso";


	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		 try {
			 
	            SoapSerializationEnvelope env = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 
	        env.dotNet = true;
            env.xsd = SoapSerializationEnvelope.XSD;
            env.xsi = SoapSerializationEnvelope.XSI;

	 
	            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	            
	        
	            ///request.addProperty("apiKey", "mobile123");

	            env.setOutputSoapObject(request);
	 
	          HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	           // AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);
	 
	            androidHttpTransport.call(SOAP_ACTION, env);
	           Object result = env.getResponse();
	           
	            Log.d("CityName", result.toString());
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}