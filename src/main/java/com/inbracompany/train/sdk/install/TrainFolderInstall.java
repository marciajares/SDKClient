package com.inbracompany.train.sdk.install;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class TrainFolderInstall {
	
	public static void trainFolderInstall(){
		File file = FileSystemView.getFileSystemView().getHomeDirectory();
		new File(file.getAbsolutePath()+"/.train").mkdir();
		new File(file.getAbsolutePath()+"/.train/"+"/data");
		new File(file.getAbsolutePath()+"/.train/"+"/logs");
		new File(file.getAbsolutePath()+"/.train/"+"/config");
		new File(file.getAbsolutePath()+"/.train/"+"/network");
		new File(file.getAbsolutePath()+"/.train/"+"/defaults");
		new File(file.getAbsolutePath()+"/.train/"+"/data/"+".VirtualRepository");
		new File(file.getAbsolutePath()+"/.train/"+"/data/.VirtualRepository/"+".ID");
		new File(file.getAbsolutePath()+"/.train/"+"/data/.VirtualRepository/"+".digest");	
		new File(file.getAbsolutePath()+"/.train/"+"/data/.VirtualRepository/"+".CreatedSince");
		new File(file.getAbsolutePath()+"/.train/"+"/data/.VirtualRepository/"+".CreatedAt");
		new File(file.getAbsolutePath()+"/.train/"+"/data/.VirtualRepository/"+".Size");
		new File(file.getAbsolutePath()+"/.train/"+"/data/.VirtualRepository/"+".simpleName");
		new File(file.getAbsolutePath()+"/.train/"+"/data/.VirtualRepository/"+".DOPointer").mkdir();
	}

}
