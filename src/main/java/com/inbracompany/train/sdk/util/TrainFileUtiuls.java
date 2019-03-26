package com.inbracompany.train.sdk.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class TrainFileUtiuls {

	private static final String MD5 = "MD5";

	public static String getChecksum(Serializable object) throws IOException, NoSuchAlgorithmException {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			MessageDigest md = MessageDigest.getInstance(MD5);
			byte[] thedigest = md.digest(baos.toByteArray());
			return DatatypeConverter.printHexBinary(thedigest);
		} finally {
			oos.close();
			baos.close();
		}
	}

	public static byte[] readFileToByteArray(File file) {
		FileInputStream fis = null;
		// Creating a byte array using the length of the file
		// file.length returns long which is cast to int
		byte[] bArray = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();

		} catch (IOException ioExp) {
			throw new RuntimeException("Problem to convert file to byte array.");
		}
		return bArray;
	}

	public static byte[] readFileToByteArray(String fileStr) {
		FileInputStream fis = null;
		// Creating a byte array using the length of the file
		// file.length returns long which is cast to int
		File file = new File(fileStr);
		byte[] bArray = new byte[(int) file.length()];try
		{
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();
	
		}catch(IOException ioExp){
			throw new RuntimeException("Problem to convert file to byte array.");
		}
		return bArray;
	}

}
