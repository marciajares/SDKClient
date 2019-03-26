package com.inbracompany.train.sdk.model.messagemodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.inbracompany.train.sdk.model.IDigitalObject;
import com.inbracompany.train.sdk.model.IMetada;
import com.inbracompany.train.sdk.model.IMongo;
import com.inbracompany.train.sdk.model.ITrain;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/

@Repository
@XStreamAlias("Envelope")
@Document(collection = "envelope_message")
public class EnvelopeMessageModel implements IDigitalObject, ITrain, IMetada,IMongo {
	

	@Id
	private ObjectId _id;
	
	@XStreamAsAttribute
	@XStreamAlias("digitalObjID")
	private String digitalObjID;
	
	@XStreamAlias("parentDigitalObjID")
	private String parentDigitalObjID;
	
	@XStreamImplicit(itemFieldName="childsDigitalObjID")
	private List<String> childsDigitalObjID = new ArrayList<String>();
	
	@XStreamAlias("digitalObjHostBase")
	private String digitalObjHostBase;
	
	@XStreamAlias("trackerHost")
	private String trackerHost;
	
	@XStreamAlias("trackerID")
	private String trackerID;


	
	@XStreamAsAttribute
	@XStreamAlias("packageName")
	private String packageName;
	
	@XStreamAsAttribute
	@XStreamAlias("projectName")
	private String projectName;
	
	@XStreamAsAttribute
	@XStreamAlias("author")
	private String author;
	
	@XStreamAsAttribute
	@XStreamAlias("date")
	private String date;
	

	
	@XStreamAlias("request")
	private RequestMessageModel requestDefinition = new RequestMessageModel();

	//DBRef
	@XStreamImplicit(itemFieldName="responses")
	private List<ResponseMessageModel> responseDefinition;

	@XStreamAsAttribute
	@XStreamAlias("version")
	private String version;
	
	@XStreamAlias("type")
	private String type;
	
	@XStreamAlias("description")
	private String description;

	@XStreamAlias("xml")
	private String xml;


	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public RequestMessageModel getRequestDefinition() {
		return requestDefinition;
	}
	public void setRequestDefinition(RequestMessageModel requestDefinition) {
		this.requestDefinition = requestDefinition;
	}


	public List<ResponseMessageModel> getResponseDefinition() {
		return responseDefinition;
	}
	public void setResponseDefinition(List<ResponseMessageModel> responseDefinition) {
		this.responseDefinition = responseDefinition;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}


public String getDigitalObjID() {
		return digitalObjID;
	}

	public void setDigitalObjID(String digitalObjID) {
		this.digitalObjID = digitalObjID;
	}

	public String getParentDigitalObjID() {
		return parentDigitalObjID;
	}

	public void setParentDigitalObjID(String parentDigitalObjID) {
		this.parentDigitalObjID = parentDigitalObjID;
	}

	public List<String> getChildsDigitalObjID() {
		return childsDigitalObjID;
	}

	public void setChildsDigitalObjID(List<String> childsDigitalObjID) {
		this.childsDigitalObjID = childsDigitalObjID;
	}

	public String getDigitalObjHostBase() {
		return digitalObjHostBase;
	}

	public void setDigitalObjHostBase(String digitalObjHostBase) {
		this.digitalObjHostBase = digitalObjHostBase;
	}

	public String getTrackerHost() {
		return trackerHost;
	}

	public void setTrackerHost(String trackerHost) {
		this.trackerHost = trackerHost;
	}

	public String getTrackerID() {
		return trackerID;
	}

	public void setTrackerID(String trackerID) {
		this.trackerID = trackerID;
	}

	
	public String getPosition() {
		throw new UnsupportedOperationException();
	}

	public void setPosition(String position) {
		throw new UnsupportedOperationException();
	}

	public String getPreviousStation() {
		throw new UnsupportedOperationException();
	}

	public void setPreviousStation(String previousStation) {
		throw new UnsupportedOperationException();
	}

	public String getCurrentlyStation() {
		throw new UnsupportedOperationException();
	}

	public void setCurrentlyStation(String currentlyStation) {
		throw new UnsupportedOperationException();
	}

	public String getNextStation() {
		throw new UnsupportedOperationException();
	}

	public void setNextStation(String setNextStation) {
		throw new UnsupportedOperationException();
		
	}

	public void setSubstituteVagon(String substituteVagonID) {
		throw new UnsupportedOperationException();
		
	}

	public String getSubstituteVagon() {
		throw new UnsupportedOperationException();
	}
	

	public void setDescription(String description) {
		this.description=description;
		
	}

	public String getDescription() {
		return description;
	}


	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}


	@Override
	public void setXMLVersion(String xml) {
		this.xml=xml;
	}
	@Override
	public String getXMLVersion() {
		return xml;
	}
	@Override
	public ObjectId getId() {
		return this._id;
	}
	@Override
	public void setId(ObjectId _id) {
		this._id=_id;
	}


}
