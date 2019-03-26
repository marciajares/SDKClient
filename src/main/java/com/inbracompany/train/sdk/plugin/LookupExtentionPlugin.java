package com.inbracompany.train.sdk.plugin;

import java.util.ArrayList;
import java.util.List;

/** Joao Bosco Jares MSc.(jbjares@gmail.com) **/
public class LookupExtentionPlugin{
	//TODO THink about the idea.
	private String name;
	private String url;
	private List<String> endpoint = new ArrayList<String>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(List<String> endpoint) {
		this.endpoint = endpoint;
	}

}