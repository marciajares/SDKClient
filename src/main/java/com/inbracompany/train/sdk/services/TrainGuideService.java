package com.inbracompany.train.sdk.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.inbracompany.train.sdk.model.station.impl.TrainGuideModel;
import com.thoughtworks.xstream.XStream;

@Service
public class TrainGuideService {
	
	XStream xstream = new XStream();
	
	//TODO configurar a chamada para que seja https
	public String getTheMetadataSchemaFromStation() throws ClientProtocolException, IOException {
		xstream.omitField(TrainGuideModel.class, "getTheMetadataSchemaFromStation");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://targethost/login");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "vip"));
		nvps.add(new BasicNameValuePair("password", "secret"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);

		String content = null;
		return content;
	}
	
	//TODO configurar a chamada para que seja https
	public String getTheEnvironmentMetadaFromStation() throws ClientProtocolException, IOException {
		xstream.omitField(TrainGuideModel.class, "getTheEnvironmentMetadaFromStation");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://targethost/login");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "vip"));
		nvps.add(new BasicNameValuePair("password", "secret"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);

		String content = null;
		return content;
	}

}
