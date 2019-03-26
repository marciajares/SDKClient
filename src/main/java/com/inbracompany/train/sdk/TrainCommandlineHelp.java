package com.inbracompany.train.sdk;

/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/

public class TrainCommandlineHelp {
	
	public static void main(String[] args) {
		showHelp();
	}
	
	
	public static void showHelp() { 		
		
		System.out.println("Welcome to trainSDK Help");

		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("/n/n ========== Basic Instructions To Model Your Train /n/n");
		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("Use the train plus some command to perform one of the actions below:");
		System.out.println("train init [create a new train projects. after the creation of your train/project, an ID will be generated, this ID should be used to create or attach new vagons to your project]");
		System.out.println("train add --vagon -trainid [add a vagon (one or more) to your train project. Never forget to include the -trainid at the moment of te vagon addition/attach]");
		System.out.println("train add --metadata -resourceid [add the metadata related to the related resource. Never forget to add the -resourceid before to create or import a the metadata]");
		System.out.println("train add --resource -vaganid [Add resources to your vagan, the way you would like to model or compose your train solution. You are free to add any kind or type of \n resources as you want in your new vagan. However, never forget to add the -vaganid befor create or import a new resource]");
		System.out.println("train add --metadata -resourceid [add the metadata related to the related resource. Never forget to add the -resourceid before to create or import a the metadata]");
		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("/n/n ========== Basic Instructions To Use the Dustributed Objects Stored into the SDK Client Machines /n/n");
		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("train --searchAll [ At any moment you can use this command to list All of the existent Distributed objects, choose one based on the id, read the description and try to reuse it in your new train project]");
		System.out.println("train --searchAll -regex [At any moment you can use this command to list Digital Objects. The regex function will filter the objects to be listed based on the type and description, \n choose one based on the id,. Again, a list will be showed, and you will can try to reuse it in your new train project]");
		System.out.println("train --pull -trainid [the pull function could be used to push one Digital Object to be reused. It could occur when some user tries to reproduce the work of another person]");
		System.out.println("train --pull -vagonid -trainid [the pull function could be used to push one Digital Object to be reused. It's Useful to compose a new train reusing the work of someonelse. \nThe latest argument is the id of the new train which this vagon will be part]");
		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("/n/n ========== The Instructions below shows how to Compile and Send the Message Request, before send the Train itself /n/n");
		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println(" Att.: 1) This tool are under development, possible to be converted for any kind of plugin such as eclipse which alread offer many other plugins to develop different kind of\n"
				+ " languages or scrpts gigev support for auto complete, sintax validation, and much more, in this mean time based on command line we should use vi or any other external tool to develope the related " +
		"resource. Speacially because, each one of this resources is just completed if it's composed by one second resource, the metadata which contains all the description about the resource, vagon or train, including the /n/n" +
				"important information such as station id, order of execution, and much more. So It's important to say because there are proposed solutions to auto discover this kind of information" +
				"without break the security of the data (we are not talking abiut SSL, Private or Public Keys, yet). /n/n " +
				"2) All resources/vagons/trains which are well formed and compiling, they goes direct to the Digital Objects Repository, withou need to perform a pull command.");

		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("/n/n ========== The Instructions below shows how to Compile and Send the train.  attention of the next to commands, once they are so important.");
		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("train --compile -vagonid [ If the vagon is incomplete or cant attend the station requirements it will not compilable, a warn will show explaining the details.]");
		System.out.println("train --compile -resourceid [if the resource is incomplete or cant attend the station requirements it will not compilable, a warn will show explaining the details.]");
		System.out.println("train --compile -trainid [ This process will do a verification on content related to that train, and if at least one can't compile the Message Request will not send till everything is compiling.]");
		System.out.println("/n/n/n ================================================================ /n/n/n");
		System.out.println("Even after the compilation the train which is already on Digital object will not be send, just the Envelope containing the message request" +
				"which has the complete information about the whole train. The aims of this request is simulate the train/vagons run over all the stations testing if nothing change" +
				"if nothing had change the composer goes to repository to compose the real train and send it to the router, router will send each vagon for each station" +
				"as well as will start a listener waiting for each part of train, where every part is together the router send the parts back do the composer" +
				"at this moment the composer will not compose the train any more, just a response envelope (with the results in the same order or the train), and send back to the end user" +
				"or in the time of the message request, or the train execution into the station, in any case an error occurs, the composer will make a response envelopse with predefined" +
				"error messages and codes and will sent back to the end user, for correction e possible retry. /n/n");


	}

}
