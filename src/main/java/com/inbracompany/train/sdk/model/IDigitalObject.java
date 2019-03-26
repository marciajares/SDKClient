package com.inbracompany.train.sdk.model;

import java.util.List;

import org.bson.types.ObjectId;

/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/

public interface IDigitalObject {
	

	public String getDigitalObjID();

	public void setDigitalObjID(String digitalObjID) ;

	public String getParentDigitalObjID();

	public void setParentDigitalObjID(String parentDigitalObjID);

	public List<String> getChildsDigitalObjID();

	public void setChildsDigitalObjID(List<String> childsDigitalObjID);

	public String getDigitalObjHostBase();

	public void setDigitalObjHostBase(String digitalObjHostBase);

	public String getTrackerHost();

	public void setTrackerHost(String trackerHost);

	public String getTrackerID();

	public void setTrackerID(String trackerID);
	
    public ObjectId getId();
    public void setId(ObjectId id);


}
