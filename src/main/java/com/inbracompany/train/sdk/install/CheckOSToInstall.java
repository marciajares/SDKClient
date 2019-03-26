package com.inbracompany.train.sdk.install;

public class CheckOSToInstall {
	
	public static String checkDockerBeforeInstall() {
		String OSname = System.getProperty("os.name").toLowerCase();;
		
		if (OSname.contains("Windows".toLowerCase())) {
			return "Windows".toLowerCase();
		} 
		if (OSname.contains("Mac".toLowerCase())) {
			return "Mac".toLowerCase();
		} 
		if (OSname.contains("Unix".toLowerCase())) {
			return "Unix".toLowerCase();
		} 
		if (OSname.contains("Linux".toLowerCase())) {
			return "Linux".toLowerCase();
		} 
		if (OSname.contains("Solaris".toLowerCase())) {
			return "Solaris".toLowerCase();
		} else {
			throw new RuntimeException("OS Not Supported!!!");
		}
	
	}

}
