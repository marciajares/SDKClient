package com.inbracompany.train.sdk.trainmodel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inbracompany.train.sdk.model.trainmodel.impl.ResourceModel;
import com.inbracompany.train.sdk.model.trainmodel.impl.TrainModel;
import com.inbracompany.train.sdk.model.trainmodel.impl.VagonModel;
import com.inbracompany.train.sdk.persistence.mongo.config.messagemodelconfig.EnvelopeMessageConfig;
import com.inbracompany.train.sdk.persistence.mongo.config.repository.trainmodelrepository.ITrainModelRepository;
import com.inbracompany.train.sdk.util.TrainFileUtiuls;
import com.thoughtworks.xstream.XStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EnvelopeMessageConfig.class })
public class TrainModelToMongoTest {

	@Autowired
	ITrainModelRepository trainModelRepository;

	@SuppressWarnings("unchecked")
	@Test
	public void setUp() throws Exception {
		XStream xstream = new XStream();
		TrainModel train = new TrainModel();

		train.setChildsDigitalObjID(Arrays.asList("vagon_1"));
		train.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		train.setDigitalObjID("train_1");
		train.setParentDigitalObjID(null);
		train.setTrackerID("stamp1");
		train.setVagons(getVagons());

		xstream.processAnnotations(TrainModel.class);
		String str = xstream.toXML(train);
		train.setXMLVersion(str);
		trainModelRepository.save(train);
		System.out.println(str);
	}

	private List<VagonModel> getVagons() {
		List<VagonModel> vegons = new ArrayList<VagonModel>();

		// add vagon1
		VagonModel vagon1 = new VagonModel();
		vagon1.setChildsDigitalObjID(Arrays.asList("resource_1","resource_2","resource_3","resource_4","resource_5"));
		vagon1.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		vagon1.setDigitalObjID("vagon_1");
		vagon1.setTrackerID("stamp1");
		vagon1.setParentDigitalObjID("train_1");
		vegons.add(vagon1);

		return vegons;
	}

	@SuppressWarnings("unchecked")
	public List<ResourceModel> getResources() throws NoSuchAlgorithmException, IOException {
		List<ResourceModel> resources = new ArrayList<ResourceModel>();

		// add 1 resource
		ResourceModel rdPyScript = new ResourceModel();
		rdPyScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py"));
		rdPyScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		rdPyScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		rdPyScript.setDigitalObjID("resource_1");
		byte[] fileStream1 = Files.readAllBytes(new File("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py").toPath());
		rdPyScript.setFile(fileStream1);
		rdPyScript.setTrackerID("stamp1");
		rdPyScript.setParentDigitalObjID("vagon_1");
		resources.add(rdPyScript);

		// add 2 resource
		ResourceModel cqlScript = new ResourceModel();
		cqlScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/input.cql"));
		cqlScript.setDigitalObjID("resource_2");
		byte[] fileStream2 = Files.readAllBytes(new File("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py").toPath());
		cqlScript.setFile(fileStream2);
		cqlScript.setTrackerID("stamp1");
		cqlScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		cqlScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		cqlScript.setParentDigitalObjID("vagon_1");
		resources.add(cqlScript);
		

		// add 3 resource
		ResourceModel requirementScript = new ResourceModel();
		requirementScript.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/requirements.txt"));
		requirementScript.setDigitalObjID("resource_3");
		byte[] fileStream3 = Files.readAllBytes(new File("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py").toPath());
		requirementScript.setFile(fileStream3);
		requirementScript.setTrackerID("stamp1");
		requirementScript.setChildsDigitalObjID(Collections.EMPTY_LIST);
		requirementScript.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		requirementScript.setParentDigitalObjID("vagon_1");
		resources.add(requirementScript);
		

		// add 4 resource
		ResourceModel dockerFile = new ResourceModel();
		dockerFile.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/Dockerfile"));
		dockerFile.setDigitalObjID("resource_4");
		byte[] fileStream4 = Files.readAllBytes(new File("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py").toPath());
		dockerFile.setFile(fileStream4);
		dockerFile.setTrackerID("stamp1");
		dockerFile.setChildsDigitalObjID(Collections.EMPTY_LIST);
		dockerFile.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		dockerFile.setParentDigitalObjID("vagon_1");
		resources.add(dockerFile);

		// add 5 resource
		ResourceModel buildSH = new ResourceModel();
		buildSH.setChecksum(TrainFileUtiuls.getChecksum(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/build.sh"));
		buildSH.setDigitalObjID("resource_5");
		byte[] fileStream5 = Files.readAllBytes(new File("/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/test/resources/de/fraunhofer/train/sdk/messagedefinition/script.py").toPath());
		buildSH.setFile(fileStream5);
		buildSH.setTrackerID("stamp1");
		buildSH.setChildsDigitalObjID(Collections.EMPTY_LIST);
		buildSH.setDigitalObjHostBase("http://127.0.0.1:28017/TrainObjectRepository/train/?filter__id=");
		buildSH.setParentDigitalObjID("vagon_1");
		resources.add(buildSH);

		return resources;
	}


}
