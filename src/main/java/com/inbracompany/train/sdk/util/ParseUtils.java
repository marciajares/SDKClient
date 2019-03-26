package com.inbracompany.train.sdk.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ParseUtils {
	
	public static String getException(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

}
