package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ParkingParser {
	private URL urlToParse;
	private StringBuffer extractedDatas;
	
	public ParkingParser(){
		this.extractedDatas = new StringBuffer();
	}

	public void setUrlToParse(String urlToParse) {
		try {
			this.urlToParse = new URL(urlToParse);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void parse() {
		
	}

	public void getDatas() {
		try {
			HttpURLConnection connection = (HttpURLConnection) this.urlToParse.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			
				connection.setRequestMethod("GET");
			
			connection.connect();
			InputStream in = connection.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String inputLine;
			while((inputLine=reader.readLine()) != null){
				extractedDatas.append(inputLine);
				System.out.println(inputLine);
			}
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
