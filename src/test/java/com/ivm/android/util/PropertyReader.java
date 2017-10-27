package com.ivm.android.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	String path = getPath();
	public String readApplicationFile(String key) {
		String value = "";
		try {
			Properties prop = new Properties();
			File f;

			f = new File(path + "//src//test//java//config//application.properties");
			
			if (f.exists()) 
			{
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			}
		} catch (Exception e) {
			System.out.println("Failed to read from application.properties file.");
		}
		return value;
	}

	public String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	
}
