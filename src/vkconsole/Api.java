package vkconsole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Api {
	private HttpURLConnection conn;
	private int responseCode;
	private String token;
	
	public Api() {
		token = null;
	}
	public Api(String token) {
		this.token = token;
	}

	private JsonObject send() {
		try {
			conn.connect();
		    responseCode = conn.getResponseCode();
		    
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    InputStream is = conn.getInputStream();
	
		    byte[] buffer = new byte[8192];
		    int bytesRead;
		    while ((bytesRead = is.read(buffer)) != -1) {
		        baos.write(buffer, 0, bytesRead);
		    }
		    Gson gson = new Gson();
		    System.out.println(baos.toString());
		    JsonObject result = gson.fromJson( baos.toString(), JsonObject.class);
		    return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void initConnection(String request) {
		request = "https://api.vk.com/method/" + request + (token == null ? "" : "&access_token="+ token);
		System.out.println(request);
		try {
			URL url = new URL(request);
			conn = (HttpURLConnection) url.openConnection();
			
			
			conn.setDoOutput(true);
		    conn.setDoInput(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	public JsonObject post(String request, String params) {
		
		initConnection(request);
		conn.setRequestProperty("Content-Length", "" + Integer.toString(params.getBytes().length));
		try {
			conn.setRequestMethod("POST");
			OutputStream os = conn.getOutputStream();
			byte[] data = params.getBytes("UTF-8");
			os.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		return send();
	}
	public JsonObject get(String request) {
		initConnection(request);
		try {
			conn.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return send();
	}
	
	public int getResponseCode() {
		return this.responseCode;
	}
	
	
	public static float intToCoin(String count) {
		BigDecimal result = new BigDecimal(count).divide(new BigDecimal("100000000"));
		return Float.parseFloat(result.toString());	
	}
	
	public static String toDate(long arg) {
		
		return new Date((arg+1467057600) * 1000).toString();
	}
	
	

}

