package com.inbracompany.train.sdk.messagedefinition;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.inbracompany.train.sdk.action.EnvelopeMessageAction;
import com.inbracompany.train.sdk.mock.EnvelopDefinitionModelMock;
import com.inbracompany.train.sdk.model.messagemodel.impl.EnvelopeMessageModel;
import com.inbracompany.train.sdk.persistence.mongo.config.messagemodelconfig.EnvelopeMessageConfig;

@EnableAspectJAutoProxy
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EnvelopeMessageConfig.class })
public class EnvelopDefinitionActionTest {

	@Autowired
	EnvelopeMessageAction envelopeMessageAction;
	
	@Autowired EnvelopDefinitionModelMock envelopDefinitionModelMock;
	

	@Test
	public void contextLoads() throws NoSuchAlgorithmException, IOException {
		Assert.notNull(envelopeMessageAction);
		EnvelopeMessageModel envelopeMessageModel = envelopDefinitionModelMock.getIEnvelopeMessageModelMock();
		Assert.notNull(envelopeMessageModel);
		EnvelopeMessageModel result = envelopeMessageAction.saveEnvelopModel(envelopeMessageModel);
		Assert.notNull(result);

	}


}
