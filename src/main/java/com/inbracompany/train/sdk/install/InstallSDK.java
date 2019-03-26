package com.inbracompany.train.sdk.install;

import java.io.IOException;

public class InstallSDK {
	
	public static void main(String[] args) throws IOException {

		TrainFolderInstall.trainFolderInstall();
		String os = CheckOSToInstall.checkDockerBeforeInstall();
		CheckDockertoInstall.checkDockertoInstall(os);

	}
}
