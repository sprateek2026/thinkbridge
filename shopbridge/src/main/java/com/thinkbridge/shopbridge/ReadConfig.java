package com.thinkbridge.shopbridge;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		
		try {
			FileInputStream fis = new FileInputStream("config.properties");
			prop= new Properties();
			
			prop.load(fis);
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getlanguage() {

		
		String language=(String) prop.getProperty("language");
		return language;
	}	
	
public String getapplicationurl() {

	String url= prop.getProperty("baseURL");
	
	return url;
}

public String getusername() {

	String username= prop.getProperty("username");
	
	return username;
}


public String getorg() {

	String org= prop.getProperty("orgname");
	
	return org;
}

public String getemail() {

	String email= prop.getProperty("email");
	
	return email;
}


}
