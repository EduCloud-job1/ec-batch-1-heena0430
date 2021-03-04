package com.heena.ec.covid;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
public class CovidService {
	
	public State getStateObject() throws ClientProtocolException, IOException 
	{
		String apiUrl = "https://s3.ap-south-1.amazonaws.com/const.educloud.in/api/Maha.json";
		String json_response = getJsonResponse(apiUrl);
		Gson gson = new Gson();
		State state = gson.fromJson(json_response, State.class);
		
		
		return state;
		
	}

	private String getJsonResponse(String apiUrl) throws IOException, ClientProtocolException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(apiUrl);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		HttpEntity entity1 = response1.getEntity();
		String json_response = EntityUtils.toString(entity1);
		System.out.println(json_response);
		return json_response;
	}
	
	public List<State> getListofStatus() throws ClientProtocolException, IOException {
		
		String apiUrl = "https://s3.ap-south-1.amazonaws.com/const.educloud.in/api/State-Covid.json";
		String json_response = getJsonResponse(apiUrl);
		Gson gson = new Gson();
		
		Type UserListType = new TypeToken<ArrayList<State>>() {}.getType();
		 ArrayList<User> stateList = gson.fromJson(json_response, userListType);
		 
		 return stateList;
			 
		 }
		
	}

