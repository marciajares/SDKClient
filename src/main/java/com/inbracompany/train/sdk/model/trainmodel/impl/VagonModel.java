package com.inbracompany.train.sdk.model.trainmodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.train.sdk.model.IDigitalObject;
import com.inbracompany.train.sdk.model.IMetada;
import com.inbracompany.train.sdk.model.IMongo;
import com.inbracompany.train.sdk.model.ITrain;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/

@XStreamAlias("vagon")
@Document(collection = "vagon")
public class VagonModel implements IDigitalObject , ITrain, IMongo{

	
	@Id
	@XStreamAlias("_id")
	private ObjectId _id = new ObjectId("59ea560248b3890c2d193ed5");
	
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


	@XStreamAlias("xml")
	private String xml;
	
	@XStreamImplicit(itemFieldName="resource")
	private List<ResourceModel> resources = new ArrayList<ResourceModel>();

	public List<ResourceModel> getResources() {
		return resources;
	}

	public void setResources(List<ResourceModel> resources) {
		this.resources = resources;
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
	

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }
	
	
}
