package com.inbracompany.train.sdk.persistence.mongo.config.repository.trainmodelrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inbracompany.train.sdk.model.trainmodel.impl.ResourceModel;

@Repository
public interface IResourceModelRepository extends CrudRepository<ResourceModel, String> {}
