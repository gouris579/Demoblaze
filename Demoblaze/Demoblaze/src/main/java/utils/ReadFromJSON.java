package utils;

import java.io.FileReader;

import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFromJSON
{
	String n;
	JSONObject jo;

	public JSONObject readfromJSON(String foldername,String filename,String keyword) throws IOException, ParseException 
	{
		Reader reader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\"+foldername+"\\"+filename+".json");
		JSONParser parser = new JSONParser();
		JSONArray jsonArr = (JSONArray) parser.parse(reader);

		for (Object obj : jsonArr) {
			jo = (JSONObject) obj;
			n = (String) jo.get(keyword);
		}
		return jo;

	}

}
