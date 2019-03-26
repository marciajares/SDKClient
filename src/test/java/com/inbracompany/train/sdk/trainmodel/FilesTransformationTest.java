package com.inbracompany.train.sdk.trainmodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.inbracompany.train.sdk.util.TrainFileUtiuls;

public class FilesTransformationTest {

	@Test
	public void execute() throws NoSuchAlgorithmException, IOException {
		File codesystemBundleJson = new File(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/main/resources/stationmetadata/codesystem-bundle.json");
		File valuesetConditionBundleJson = new File(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/main/resources/stationmetadata/valueset-condition-bundle.json");
		File valuesetObservationBundleJson = new File(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/main/resources/stationmetadata/valueset-observation-bundle.json");
		List<File> jsonFilesAsString = Arrays.asList(codesystemBundleJson, valuesetConditionBundleJson,
				valuesetObservationBundleJson);

		for (File jsonFile : jsonFilesAsString) {
			TrainFileUtiuls.readFileToByteArray(jsonFile);
		}
	}

	@Test
	public void whenConvertingInProgressToFile_thenCorrect() throws IOException {

		InputStream initialStream = new FileInputStream(new File(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/main/resources/stationmetadata/codesystem-bundle.json"));
		File targetFile = new File(
				"/Users/jbjares/workspaces/model-design-by-commandline/TrainSDK/src/main/resources/utils/targetFile.tmp");
		OutputStream outStream = new FileOutputStream(targetFile);

		byte[] buffer = new byte[8 * 1024];
		int bytesRead;
		while ((bytesRead = initialStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		ByteBuffer buf = ByteBuffer.wrap(buffer);
		String stream = StandardCharsets.UTF_8.decode(buf).toString();
		System.out.println(stream);

		IOUtils.closeQuietly(initialStream);
		IOUtils.closeQuietly(outStream);
	}

}
