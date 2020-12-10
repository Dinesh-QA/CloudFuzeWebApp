package com.cloudfuze.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingConfig {
	Properties pro;
	FileInputStream fis;
	public ReadingConfig(){
		File file = new File("./Configurations/config.properties");
		try {
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println(e.getMessage());		
		}
	}
	public String url() throws IOException {
		String url = pro.getProperty("URL");
		return url;
	}
	public String Browser() throws IOException {
		String browser = pro.getProperty("browser");
		return browser;
	}
}
