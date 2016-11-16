package com.sktelecom.tdrive;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class CommonUtil {
	public static String fileToString() {

		String fileString = new String();
		FileInputStream inputStream = null;
		ByteArrayOutputStream byteOutStream = null;
		try {
			inputStream = new FileInputStream("D:/Tulips.jpg");
			byteOutStream = new ByteArrayOutputStream();
			int len = 0;

			byte[] buf = new byte[1024];
			while ((len = inputStream.read(buf)) != -1) {
				byteOutStream.write(buf, 0, len);
			}
			byte[] fileArray = byteOutStream.toByteArray();
			fileString = new String(Base64.encodeBase64(fileArray));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				byteOutStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("fileString === :: " + fileString);
		return fileString;
	}
	
	public static void main(String[] args) {
		fileToString();
	}
}
