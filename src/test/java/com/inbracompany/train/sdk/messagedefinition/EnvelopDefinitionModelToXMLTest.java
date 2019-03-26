package com.inbracompany.train.sdk.messagedefinition;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.inbracompany.train.sdk.model.messagemodel.impl.EnvelopeMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.RequestMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.ResourceMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.ResponseMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.TrainMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.VagonMessageModel;
import com.inbracompany.train.sdk.util.TrainFileUtiuls;
import com.thoughtworks.xstream.XStream;

public class EnvelopDefinitionModelToXMLTest {
	
    @Test  
    public void setUp() throws Exception {  
    	XStream xstream = new XStream();
    	EnvelopeMessageModel envelope = new EnvelopeMessageModel();
    	
        envelope = new EnvelopeMessageModel();  
        envelope.setAuthor("jbjares");
        envelope.setDate("28/06/1982");
        envelope.setPackageName("de.fraunhofer.train");
        envelope.setProjectName("BMI Tainning");
        envelope.setVersion("1.0.0.0");
        //Set Request Definition
        envelope.setRequestDefinition(getRequestDefinition());
        envelope.setResponseDefinition(getResponseDefinition());
        //set other onjects 
        envelope.setDigitalObjID("envelope_1");
        
        //TODO evaluate this field with the team
        envelope.setTrackerHost(null);
        envelope.setParentDigitalObjID(null);
        envelope.setTrackerID("stamp1");
        envelope.setChildsDigitalObjID(Arrays.asList("req_1","res_1"));
        xstream.processAnnotations(EnvelopeMessageModel.class);
        String str = xstream.toXML(envelope);
        System.out.println(str);
    }  

    
    @SuppressWarnings("unchecked")
	public List<ResourceMessageModel> getResourcesDefinition() throws NoSuchAlgorithmException, IOException {
    	List<ResourceMessageModel> resources = new ArrayList<ResourceMessageModel>();
    	
    	//add 1 resource
    	ResourceMessageModel rdPyScript = new ResourceMessageModel();
    	rdPyScript.setDescription("Python Script to Calculte BMI after FHIR CQL Result");
    	rdPyScript.setExtension(".py");
    	rdPyScript.setChecksum(TrainFileUtiuls.getChecksum("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py"));
    	rdPyScript.setTestEnviroment("python -v");
    	rdPyScript.setType("py_script");
    	rdPyScript.setVersion("1.0.0");
    	rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
    	rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
    	rdPyScript.setDigitalObjID("resource_1");
    	rdPyScript.setTrackerID("stamp1");
    	resources.add(rdPyScript);
    	
    	//add 2 resource
    	ResourceMessageModel cqlScript = new ResourceMessageModel();
    	cqlScript.setDescription("Python Script to Calculte BMI after FHIR CQL Result");
    	//cqlScript.setDigitalObjReference("DOIR02");
    	cqlScript.setExtension(".py");
    	cqlScript.setChecksum(getFileMD5("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/input.cql"));
    	cqlScript.setTestEnviroment("curl 'http://localhost:8080/DiagnosticOrder' \\\n" + 
    			"     -H 'Authorization: Basic Y2xpZW50OnNlY3JldA=='");
    	cqlScript.setType("cql_script");
    	cqlScript.setVersion("1.0.0");
    	resources.add(cqlScript);  	
    	rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
    	rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
    	rdPyScript.setDigitalObjID("resource_2");
    	rdPyScript.setTrackerID("stamp1");
    	
    	//add 3 resource
    	ResourceMessageModel requirementScript = new ResourceMessageModel();
    	requirementScript.setDescription("Simple TXT file to deal PIP deal with the project Dependencies");
    	//requirementScript.setDigitalObjReference("DOIR03");
    	requirementScript.setExtension(".txt");
    	requirementScript.setChecksum(TrainFileUtiuls.getChecksum("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/requirements.txt"));
    	requirementScript.setTestEnviroment("pip -v");
    	requirementScript.setType("requirement_script");
    	requirementScript.setVersion("1.0.0");
    	rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
    	rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
    	rdPyScript.setDigitalObjID("resource_3");
    	rdPyScript.setTrackerID("stamp1");
    	resources.add(requirementScript);  
    	
    	//add 4 resource
    	ResourceMessageModel dockerFile = new ResourceMessageModel();
    	dockerFile.setDescription("Simple TXT file to deal PIP deal with the project Dependencies");
    	//dockerFile.setDigitalObjReference("DOIR04");
    	dockerFile.setExtension("");
    	dockerFile.setChecksum(TrainFileUtiuls.getChecksum("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/Dockerfile"));
    	dockerFile.setTestEnviroment("docker -v");
    	dockerFile.setType("docker_script");
    	dockerFile.setVersion("1.0.0");
    	rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
    	rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
    	rdPyScript.setDigitalObjID("resource_4");
    	rdPyScript.setTrackerID("stamp1");
    	resources.add(dockerFile);  
    	
    	//add 5 resource
    	ResourceMessageModel buildSH = new ResourceMessageModel();
    	buildSH.setDescription("Bash script to mount all the files in a single docker container.");
    	//buildSH.setDigitalObjReference("DOIR05");
    	buildSH.setExtension("");
    	buildSH.setChecksum(TrainFileUtiuls.getChecksum("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/build.sh"));
    	buildSH.setTestEnviroment("");
    	buildSH.setType("build_script_sh");
    	buildSH.setVersion("1.0.0");
    	rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
    	rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
    	rdPyScript.setDigitalObjID("resource_5");
    	rdPyScript.setTrackerID("stamp1");
    	resources.add(buildSH);  
    	
    	return resources;
    }
    private String getFileMD5(String file) throws IOException, NoSuchAlgorithmException {
    	String checksum = TrainFileUtiuls.getChecksum(new File(file));
		return checksum;
	}
	public List<VagonMessageModel> getVagonsDefinition() throws NoSuchAlgorithmException, IOException{
    	List<VagonMessageModel> vagondef1List = new ArrayList<VagonMessageModel>();
    	
    	//add vagon1 
    	VagonMessageModel vagondef1 = new VagonMessageModel();
    	vagondef1.setDescription("Holds the resources to mount the container to run and calculate the BMI based on FHIR Server");
    	//vagondef1.setId("DOIVDEF01");
    	vagondef1.setType("vagon");
    	vagondef1.setVersion("1.0.0");
    	vagondef1.setChildsDigitalObjID(Arrays.asList("","","","",""));
    	//vagondef1.setDigitalObjHostBase(digitalObjHostBase);
    	vagondef1.setPosition("vagoDef_1");
    	vagondef1.setDigitalObjID("vagonDef_1");
    	vagondef1.setResourcesDefinition(getResourcesDefinition());
    	vagondef1.setTrackerID("stamp1");
    	
    	//add the first vagon
    	vagondef1List.add(vagondef1);
    	
    	
    	return vagondef1List;
    	
    }
    public TrainMessageModel getTrainDefinition() throws NoSuchAlgorithmException, IOException {
    	TrainMessageModel trainDefinition = new TrainMessageModel();
        trainDefinition.setDescription("Train which aims to do BMI trainning");
        trainDefinition.setChildsDigitalObjID(Arrays.asList("vagon_1"));
        trainDefinition.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
        trainDefinition.setDigitalObjID("trainDef_1");
        trainDefinition.setType("train");
        trainDefinition.setVersion("1.0.0");
        trainDefinition.setVagonsDefinition(getVagonsDefinition());
        trainDefinition.setParentDigitalObjID("reqDef_1");
        trainDefinition.setTrackerHost(null);
        trainDefinition.setTrackerID("stamp1");
        return trainDefinition;
    }
    public RequestMessageModel getRequestDefinition() throws NoSuchAlgorithmException, IOException {
    	RequestMessageModel requestDefinition = new RequestMessageModel();
    	requestDefinition.setChildsDigitalObjID(Arrays.asList("reqDef_1"));
    	requestDefinition.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
    	requestDefinition.setDigitalObjID("req_1");
    	requestDefinition.setParentDigitalObjID("envelope_1");
    	requestDefinition.setChildsDigitalObjID(Arrays.asList("reqDef_1"));
    	requestDefinition.setTrainDefinition(getTrainDefinition());
    	requestDefinition.setTrackerID("stamp1");
    	return requestDefinition;
    }

    private List<ResponseMessageModel> getResponseDefinition() {
    	List<ResponseMessageModel> response = new ArrayList<ResponseMessageModel>();
    	ResponseMessageModel responseDefinition = new ResponseMessageModel();
    	responseDefinition.setDigitalObjID("res_1");
    	responseDefinition.setDescription("The enviroment is not ready to run receive the vagon 1");
    	responseDefinition.setVagonPosition("res_1");
    	responseDefinition.setGeneratedTrackerID("7576577758807656565e4");
    	responseDefinition.setResult(TrainFileUtiuls.readFileToByteArray(new File("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/main/resources/resultMessage.txt")));
    	responseDefinition.setResultType("NOK");
    	responseDefinition.setStatusCode("400");
    	responseDefinition.setType("roll_1");
    	responseDefinition.setVersion("0.0.3");
		return response;
	}
 


}
