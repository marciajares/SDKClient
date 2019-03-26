package com.inbracompany.train.sdk.persistence.mongo.config.repository.messagemodelrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inbracompany.train.sdk.model.messagemodel.impl.ResponseMessageModel;


@Repository
public interface IResponseMessageModelRepository extends CrudRepository<ResponseMessageModel, String> {}
