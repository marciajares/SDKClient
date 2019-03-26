package com.inbracompany.train.sdk.model.messagemodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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
@XStreamAlias("resource")
@Document(collection = "resource_message")
public class ResourceMessageModel  implements IDigitalObject, ITrain,IMetada, IMongo{
	

	@Id
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

	@XStreamAlias("extension")
	private String extension;
	
	@XStreamAlias("testEnviroment")
	private String testEnviroment;
	
	@XStreamAlias("version")
	private String version;
	
	@XStreamAlias("type")
	private String type;
	
	@XStreamAlias("description")
	private String description;

	@XStreamAlias("xml")
	private String xml;
	
	@XStreamAlias("checksum")
	private String checksum;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getTestEnviroment() {
		return testEnviroment;
	}
	public void setTestEnviroment(String testEnviroment) {
		this.testEnviroment = testEnviroment;
	}
	//

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

		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
	    
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
