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
@XStreamAlias("responses")
@Document(collection = "response_message")
public class ResponseMessageModel implements IDigitalObject, ITrain, IMetada, IMongo{
	
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

	@XStreamAlias("statusCode")
	private String statusCode;
	
	@XStreamAlias("result")
	private byte[] result;
	
	@XStreamAlias("checksum")
	private String checksum;
	
	@XStreamAlias("resultType")
	private String resultType;
	
	@XStreamAlias("generatedTrackerID")
	private String generatedTrackerID;
	
	@XStreamAlias("vagonPosition")
	private String vagonPosition;
	
	@XStreamAlias("version")
	private String version;
	
	@XStreamAlias("type")
	private String type;
	
	@XStreamAlias("description")
	private String description;

	
	@XStreamAlias("xml")
	private String xml;

	
	public String getVagonPosition() {
		return vagonPosition;
	}
	public void setVagonPosition(String vagonPosition) {
		this.vagonPosition = vagonPosition;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public byte[] getResult() {
		return result;
	}
	public void setResult(byte[] result) {
		this.result = result;
	}
	
	
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getGeneratedTrackerID() {
		return generatedTrackerID;
	}
	public void setGeneratedTrackerID(String generatedTrackerID) {
		this.generatedTrackerID = generatedTrackerID;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
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
