package com.duelgenji.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveToFile {
	
	
	public void s(){
		File file = new File("C:/Users/kwan56/Desktop/testCase.json");
	    try (FileOutputStream fop = new FileOutputStream(file)) {
	        // if file doesn't exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        // get the content in bytes
	        byte[] contentInBytes ="string".getBytes();

	        fop.write(contentInBytes);
	        fop.flush();
	        fop.close();
	        System.out.println("Done");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
