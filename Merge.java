package com.heena.ec.MergeFile;

import org.json.JSONException;
import org.json.JSONObject;
 

public class Merge {
 
	public static void main(String[] args) {
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
 
		json1.put("Crunchify", "Java Company");
		json1.put("Google", "Search Company");
		json1.put("Yahoo", "Web Company");
 
		json2.put("Facebook", "Social Network Company");
		json2.put("Twitter", "Another Social Company");
		json2.put("Linkedin", "Professional Network Company");
		
		System.out.println("json1: " + json1);
		System.out.println("json2: " + json2);
 
		JSONObject mergedJSON = mergeJSONObjects(json1, json2);
		System.out.println("\nmergedJSON: " + mergedJSON);
	}
 
	public static JSONObject mergeJSONObjects(JSONObject json1, JSONObject json2) {
		JSONObject mergedJSON = new JSONObject();
		try {
			mergedJSON = new JSONObject(json1, JSONObject.getNames(json1));
			for (String crunchifyKey : JSONObject.getNames(json2)) {
				mergedJSON.put(crunchifyKey, json2.get(crunchifyKey));
			}
 
		} catch (JSONException e) {
			throw new RuntimeException("JSON Exception" + e);
		}
		return mergedJSON;
	}
}