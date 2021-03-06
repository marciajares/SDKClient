package com.inbracompany.train.sdk.persistence.mongo.config.repository.messagemodelrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inbracompany.train.sdk.annotation.TrackMessageOrg;
import com.inbracompany.train.sdk.model.messagemodel.impl.EnvelopeMessageModel;


@Repository
public interface IEnvelopeMessageModelRepository extends CrudRepository<EnvelopeMessageModel, String> {



	
}
