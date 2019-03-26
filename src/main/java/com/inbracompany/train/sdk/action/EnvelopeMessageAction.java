package com.inbracompany.train.sdk.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inbracompany.train.sdk.annotation.TrackMessageOrg;
import com.inbracompany.train.sdk.model.messagemodel.impl.EnvelopeMessageModel;
import com.inbracompany.train.sdk.persistence.mongo.config.repository.messagemodelrepository.IEnvelopeMessageModelRepository;

@Service
public class EnvelopeMessageAction {
	
	@Autowired IEnvelopeMessageModelRepository envelopeMessageModelRepository;
	
	@TrackMessageOrg(name = "trackMessageOrg")
	public EnvelopeMessageModel saveEnvelopModel(EnvelopeMessageModel envelopeMessageModel) throws NoSuchAlgorithmException, IOException {
		return envelopeMessageModelRepository.save(envelopeMessageModel);
	}

}
