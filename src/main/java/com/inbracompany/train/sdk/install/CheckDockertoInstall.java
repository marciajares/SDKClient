package com.inbracompany.train.sdk.install;

import java.io.File;

//TODO Need a big refactoring to implement the Strategy Pattern instead of many if/elses
//TODO should be tested not just based on the files existence but trying to send a command to docker like docker -v
public class CheckDockertoInstall {

	public static void checkDockertoInstall(String osName) {

		String OSname = osName.toLowerCase();
		;

		if (OSname.contains("Windows".toLowerCase())) {
			boolean isInstalled = checkInstallationOnWindows();
			if (isInstalled) {
				return;
			}

		}
		if (OSname.contains("Mac".toLowerCase())) {
			boolean isInstalled = checkInstallationOnMAC();
			if (isInstalled) {
				return;
			}
		}
		if (OSname.contains("Unix".toLowerCase())) {
			boolean isInstalled = checkInstallationOnUNIX();
			if (isInstalled) {
				return;
			}
		}
		if (OSname.contains("Linux".toLowerCase())) {
			boolean isInstalled = checkInstallationOnLinux();
			if (isInstalled) {
				return;
			}
		}
		if (OSname.contains("Solaris".toLowerCase())) {
			boolean isInstalled = checkInstallationOnSolaris();
			if (isInstalled) {
				return;
			}
		} else {
			throw new RuntimeException("OS Not Supported!!!");
		}

	}

	private static boolean checkInstallationOnWindows() {
		File file1 = new File("C\\ProgramData\\Docker");
		File file2 = new File("C:\\Users\\Public\\Documents\\Hyper-V\\Virtual hard disks");
		if (file1.exists() || file2.exists()) {
			return true;
		} else {
			installDockerOnWindows();
		}
		return false;
	}

	private static boolean checkInstallationOnMAC() {
		File file1 = new File("/Users/$(logname)/.docker");
		File file2 = new File("/usr/local/bin/docker");
		if (file1.exists() || file2.exists()) {
			return true;
		} else {
			installDockerOnMac();
		}
		return false;
	}

	private static boolean checkInstallationOnUNIX() {
		File file1 = new File("/Users/$(whoami)/.docker");
		File file2 = new File("/var/lib/docker/aufs/diff/\"{{.Id}}\"");
		File file3 = new File("/var/lib/docker/aufs/diff/\"{.Id}\"");
		File file4 = new File("/var/lib/docker/aufs/diff/{print $1}");

		if (file1.exists() || file2.exists() || file3.exists() || file4.exists()) {
			return true;
		} else {
			installDockerOnUnix();
		}
		return false;
	}

	private static boolean checkInstallationOnLinux() {
		File file1 = new File("/Users/$(whoami)/.docker");
		File file2 = new File("/var/lib/docker/aufs/diff/\"{{.Id}}\"");
		File file3 = new File("/var/lib/docker/aufs/diff/\"{.Id}\"");
		File file4 = new File("/var/lib/docker/aufs/diff/{print $1}");
		if (file1.exists() || file2.exists() || file3.exists() || file4.exists()) {
			return true;
		} else {
			installDockerOnLinux();
		}
		return false;
	}

	private static boolean checkInstallationOnSolaris() {
		File file1 = new File("/Users/$(whoami)/.docker");
		File file2 = new File("/var/lib/docker/aufs/diff/\"{{.Id}}\"");
		File file3 = new File("/var/lib/docker/aufs/diff/\"{.Id}\"");
		File file4 = new File("/var/lib/docker/aufs/diff/{print $1}");
		if (file1.exists() || file2.exists() || file3.exists() || file4.exists()) {
			return true;
		} else {
			installDockerOnSolaris();
		}
		return false;

	}

	private static void installDockerOnWindows() {
		

	}

	private static void installDockerOnMac() {
		// TODO Auto-generated method stub

	}

	private static void installDockerOnUnix() {
		// TODO Auto-generated method stub

	}

	private static void installDockerOnLinux() {
		// TODO Auto-generated method stub

	}

	private static void installDockerOnSolaris() {
		// TODO Auto-generated method stub

	}

}
