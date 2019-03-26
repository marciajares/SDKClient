package com.inbracompany.train.sdk.model;


/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/

public interface ITrain {
	
	public String getPosition();

	public void setPosition(String position);
	
	public String getPreviousStation();
	
	public void setPreviousStation(String previousStation);
	
	public String getCurrentlyStation();
	
	public void setCurrentlyStation(String currentlyStation);
	
	public String getNextStation();
	
	public void setNextStation(String setNextStation);
	
	public void setSubstituteVagon(String substituteVagonID);
	
	public String getSubstituteVagon();
	//TODO Think...
	
}
