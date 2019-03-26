

/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/
package com.inbracompany.train.sdk;

import java.io.File;

import javax.swing.filechooser.FileSystemView; 


public class EntryPoint {
	
	public static void main (String[] args) {
		
		if(args[0]=="train" && args[1]=="init"){
			File rootFolder = FileSystemView.getFileSystemView().getRoots()[0];
			rootFolder.getPath();
		}
		
		File rootFolder = FileSystemView.getFileSystemView().getRoots()[0];
		rootFolder.getPath();
	}
	

} 
