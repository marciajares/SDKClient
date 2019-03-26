package com.inbracompany.train.sdk.messagedefinition;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.inbracompany.train.sdk.model.messagemodel.impl.EnvelopeMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.RequestMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.ResourceMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.ResponseMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.TrainMessageModel;
import com.inbracompany.train.sdk.model.messagemodel.impl.VagonMessageModel;
import com.inbracompany.train.sdk.persistence.mongo.config.messagemodelconfig.EnvelopeMessageConfig;
import com.inbracompany.train.sdk.persistence.mongo.config.repository.messagemodelrepository.IEnvelopeMessageModelRepository;
import com.inbracompany.train.sdk.util.TrainFileUtiuls;
import com.thoughtworks.xstream.XStream;

@EnableAspectJAutoProxy
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EnvelopeMessageConfig.class })
public class EnvelopDefinitionModelToMongoTest {

	@Autowired
	IEnvelopeMessageModelRepository envelopeMessageModelRepository;

	@Test
	public void contextLoads() throws NoSuchAlgorithmException, IOException {
		Assert.notNull(envelopeMessageModelRepository);

		XStream xstream = new XStream();
		EnvelopeMessageModel envelope = new EnvelopeMessageModel();

		envelope = new EnvelopeMessageModel();
		envelope.setAuthor("jbjares");
		envelope.setDate("28/06/1982");
		envelope.setPackageName("de.fraunhofer.train");
		envelope.setProjectName("BMI Tainning");
		envelope.setVersion("1.0.0.0");
		// Set Request Definition
		envelope.setRequestDefinition(getRequestDefinition());

		String resp = xstream.toXML(getResponseDefinition1());
		System.out.println(resp);

		envelope.setResponseDefinition(getResponseDefinition1());
		// set other onjects
		envelope.setDigitalObjID("envelope_1");

		// TODO evaluate this field with the team
		envelope.setTrackerHost(null);
		envelope.setParentDigitalObjID(null);
		envelope.setTrackerID("stamp1");
		envelope.setChildsDigitalObjID(Arrays.asList("req_1", "res_1"));
		xstream.processAnnotations(EnvelopeMessageModel.class);
		String str = xstream.toXML(envelope);
		envelope.setXMLVersion(str);
		envelopeMessageModelRepository.save(envelope);
		System.out.println(str);
	}

	@SuppressWarnings("unchecked")
	public List<ResourceMessageModel> getResourcesDefinition2() throws NoSuchAlgorithmException, IOException {
		List<ResourceMessageModel> resources = new ArrayList<ResourceMessageModel>();

		// add 1 resource
		ResourceMessageModel rdPyScript = new ResourceMessageModel();
		rdPyScript.setDescription("Python Script to Calculte BMI after FHIR CQL Result");
		rdPyScript.setExtension(".py");
		rdPyScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py"));
		rdPyScript.setTestEnviroment("python -v");
		rdPyScript.setType("py_script");
		rdPyScript.setVersion("1.0.0");
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_1");
		rdPyScript.setTrackerID("stamp1");
		resources.add(rdPyScript);

		// add 2 resource
		ResourceMessageModel cqlScript = new ResourceMessageModel();
		cqlScript.setDescription("Python Script to Calculte BMI after FHIR CQL Result");
		// cqlScript.setDigitalObjReference("DOIR02");
		cqlScript.setExtension(".py");
		cqlScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/input.cql"));
		cqlScript.setTestEnviroment("curl 'http://localhost:8080/DiagnosticOrder' \\\n"
				+ "     -H 'Authorization: Basic Y2xpZW50OnNlY3JldA=='");
		cqlScript.setType("cql_script");
		cqlScript.setVersion("1.0.0");
		resources.add(cqlScript);
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_2");
		rdPyScript.setTrackerID("stamp1");

		// add 3 resource
		ResourceMessageModel requirementScript = new ResourceMessageModel();
		requirementScript.setDescription("Simple TXT file to deal PIP deal with the project Dependencies");
		// requirementScript.setDigitalObjReference("DOIR03");
		requirementScript.setExtension(".txt");
		requirementScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/requirements.txt"));
		requirementScript.setTestEnviroment("pip -v");
		requirementScript.setType("requirement_script");
		requirementScript.setVersion("1.0.0");
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_3");
		rdPyScript.setTrackerID("stamp1");
		resources.add(requirementScript);

		// add 4 resource
		ResourceMessageModel dockerFile = new ResourceMessageModel();
		dockerFile.setDescription("Simple TXT file to deal PIP deal with the project Dependencies");
		// dockerFile.setDigitalObjReference("DOIR04");
		dockerFile.setExtension("");
		dockerFile.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/Dockerfile"));
		dockerFile.setTestEnviroment("docker -v");
		dockerFile.setType("docker_script");
		dockerFile.setVersion("1.0.0");
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_4");
		rdPyScript.setTrackerID("stamp1");
		resources.add(dockerFile);

		// add 5 resource
		ResourceMessageModel buildSH = new ResourceMessageModel();
		buildSH.setDescription("Bash script to mount all the files in a single docker container.");
		// buildSH.setDigitalObjReference("DOIR05");
		buildSH.setExtension("");
		buildSH.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/build.sh"));
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

	@SuppressWarnings("unchecked")
	public List<ResourceMessageModel> getResourcesDefinition1() throws NoSuchAlgorithmException, IOException {
		List<ResourceMessageModel> resources = new ArrayList<ResourceMessageModel>();

		// add 1 resource
		ResourceMessageModel rdPyScript = new ResourceMessageModel();
		rdPyScript.setDescription("Python Script to Calculte BMI after FHIR CQL Result");
		rdPyScript.setExtension(".py");
		rdPyScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py"));
		rdPyScript.setTestEnviroment("python -v");
		rdPyScript.setType("py_script");
		rdPyScript.setVersion("1.0.0");
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_1");
		rdPyScript.setTrackerID("stamp1");
		resources.add(rdPyScript);

		// add 2 resource
		ResourceMessageModel cqlScript = new ResourceMessageModel();
		cqlScript.setDescription("Python Script to Calculte BMI after FHIR CQL Result");
		// cqlScript.setDigitalObjReference("DOIR02");
		cqlScript.setExtension(".py");
		cqlScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/input.cql"));
		cqlScript.setTestEnviroment("curl 'http://localhost:8080/DiagnosticOrder' \\\n"
				+ "     -H 'Authorization: Basic Y2xpZW50OnNlY3JldA=='");
		cqlScript.setType("cql_script");
		cqlScript.setVersion("1.0.0");
		resources.add(cqlScript);
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_2");
		rdPyScript.setTrackerID("stamp1");

		// add 3 resource
		ResourceMessageModel requirementScript = new ResourceMessageModel();
		requirementScript.setDescription("Simple TXT file to deal PIP deal with the project Dependencies");
		// requirementScript.setDigitalObjReference("DOIR03");
		requirementScript.setExtension(".txt");
		requirementScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/requirements.txt"));
		requirementScript.setTestEnviroment("pip -v");
		requirementScript.setType("requirement_script");
		requirementScript.setVersion("1.0.0");
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_3");
		rdPyScript.setTrackerID("stamp1");
		resources.add(requirementScript);

		// add 4 resource
		ResourceMessageModel dockerFile = new ResourceMessageModel();
		dockerFile.setDescription("Simple TXT file to deal PIP deal with the project Dependencies");
		// dockerFile.setDigitalObjReference("DOIR04");
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

		// add 5 resource
		ResourceMessageModel buildSH = new ResourceMessageModel();
		buildSH.setDescription("Bash script to mount all the files in a single docker container.");
		// buildSH.setDigitalObjReference("DOIR05");
		buildSH.setExtension("");
		buildSH.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/build.sh"));
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



	public List<VagonMessageModel> getVagonsDefinition2() throws NoSuchAlgorithmException, IOException {
		List<VagonMessageModel> vagondef1List = new ArrayList<VagonMessageModel>();

		// add vagon1
		VagonMessageModel vagondef1 = new VagonMessageModel();
		vagondef1.setDescription(
				"Sample Vagon");
		vagondef1.setType("vagon");
		vagondef1.setVersion("1.0.0");
		// vagondef1.setChildsDigitalObjID(childsDigitalObjID);
		// vagondef1.setDigitalObjHostBase(digitalObjHostBase);
		vagondef1.setDigitalObjID("vagonDef_2");
		vagondef1.setResourcesDefinition(getResourcesDefinition2());
		vagondef1.setTrackerID("stamp1");

		// add the first vagon
		vagondef1List.add(vagondef1);

		return vagondef1List;

	}

	public List<VagonMessageModel> getVagonsDefinition1() throws NoSuchAlgorithmException, IOException {
		List<VagonMessageModel> vagondef1List = new ArrayList<VagonMessageModel>();

		// add vagon1
		VagonMessageModel vagondef1 = new VagonMessageModel();
		vagondef1.setDescription(
				"Holds the resources to mount the container to run and calculate the BMI based on FHIR Server");
		vagondef1.setType("vagon");
		vagondef1.setVersion("1.0.0");
		// vagondef1.setChildsDigitalObjID(childsDigitalObjID);
		// vagondef1.setDigitalObjHostBase(digitalObjHostBase);
		vagondef1.setDigitalObjID("vagonDef_1");
		vagondef1.setResourcesDefinition(getResourcesDefinition1());
		vagondef1.setTrackerID("stamp1");

		// add the first vagon
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
		trainDefinition.setVagonsDefinition(getVagonsDefinition1());
		trainDefinition.setVagonsDefinition(getVagonsDefinition2());
		trainDefinition.setParentDigitalObjID("reqDef_1");
		// trainDefinition.setTrackerHost(trackerHost);
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

	private List<ResponseMessageModel> getResponseDefinition1() {
		List<ResponseMessageModel> response = new ArrayList<ResponseMessageModel>();
		ResponseMessageModel responseDefinition1 = new ResponseMessageModel();
		responseDefinition1.setDigitalObjID("res_1");
		responseDefinition1.setDescription("Response 200");
		responseDefinition1.setChecksum("res_1");
		responseDefinition1.setGeneratedTrackerID("xyz0123");
		// responseDefinition.setResult("200".getBytes());
		responseDefinition1.setResultType("OK");
		responseDefinition1.setStatusCode("201");
		responseDefinition1.setType("roll_1");
		responseDefinition1.setVersion("0.0.3");
		response.add(responseDefinition1);
		ResponseMessageModel responseDefinition2 = new ResponseMessageModel();
		responseDefinition2.setDigitalObjID("res_2");
		responseDefinition2.setDescription("ERROR 500");
		responseDefinition2.setChecksum("res_2");
		responseDefinition2.setGeneratedTrackerID("abc123");
		//responseDefinition2.setResult("200".getBytes());
		responseDefinition2.setResultType("FAIL");
		responseDefinition2.setStatusCode("502");
		responseDefinition2.setType("roll_2");
		responseDefinition2.setVersion("0.0.4");
		response.add(responseDefinition2);
		return response;
	}

}
