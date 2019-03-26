package com.inbracompany.train.sdk.model.trainmodel.impl;
/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/
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

@XStreamAlias("train")
@Document(collection = "train")
public class TrainModel  implements IDigitalObject , ITrain, IMongo, IMetada{
	

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
	
	@XStreamImplicit(itemFieldName="vagons")
	private List<VagonModel> vagons = new ArrayList<VagonModel>();
	
	@XStreamAlias("xml")
	private String xml;

	public List<VagonModel> getVagons() {
		return vagons;
	}
	public void setVagons(List<VagonModel> vagons) {
		this.vagons = vagons;
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
	
	public void setXMLVersion(String xml) {
		this.xml=xml;
	}
	@Override
	public String getXMLVersion() {
		return xml;
	}
	@Override
	public void setDescription(String description) {
		throw new UnsupportedOperationException();
	}
	@Override
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	@Override
	public void setType(String type) {
		throw new UnsupportedOperationException();
	}
	@Override
	public String getType() {
		throw new UnsupportedOperationException();
	}
	@Override
	public void setVersion(String version) {
		throw new UnsupportedOperationException();
	}
	@Override
	public String getVersion() {
		throw new UnsupportedOperationException();
	}


}
