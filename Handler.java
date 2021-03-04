package com.heena.ec.covid;
import java.awt.List;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
public class Handler {
	
	public static void main(String[]args) throws ClientProtocolException, IOException {
		
		  Handler handler = new Handler();
		  
		  //handler.goal1
		  handler.goal2();
	}
	 public void goal2() throws ClientProtocolException, IOException {
		 CovidService service = new CovidService();
		 List<State> stateList = service.getListofStatus();
		 
		 for(State state : stateList) {
			 
			 System.out.println(state.getName());
				System.out.println(state.getCapital());
				System.out.println(state.getPopulation());
				System.out.println(state.getCovid());

				
		 }
		 
	 }
	 public void goal1() throws ClientProtocolException, IOException {
		 CovidService service = new CovidService();
		State state = service.getStateObject();
		
		System.out.println(state.getName());
		System.out.println(state.getCapital());
		System.out.println(state.getPopulation());
		System.out.println(state.getCovid());

		
		
		
		}
}