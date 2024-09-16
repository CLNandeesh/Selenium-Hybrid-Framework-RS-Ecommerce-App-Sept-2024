package com.ibm.ecommerceapplication.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

		// read json to string
		String jsonContent = FileUtils.readFileToString(
				new File("./\\src\\test\\java\\com\\ibm\\ecommerceapplication\\testdata\\logindata.json"),
				StandardCharsets.UTF_8);

		
        //Create N number of Hash map of key and value as String and store all those 
		//into List of Hash map and return the List
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

		// {map, map}

	}
}
