package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location{

	@JsonProperty("localtime")
	private String localtime;

	@JsonProperty("country")
	private String country;

	@JsonProperty("localtime_epoch")
	private int localtimeEpoch;

	@JsonProperty("name")
	private String name;

	@JsonProperty("lon")
	private Object lon;

	@JsonProperty("region")
	private String region;

	@JsonProperty("lat")
	private Object lat;

	@JsonProperty("tz_id")
	private String tzId;

	public void setLocaltime(String localtime){
		this.localtime = localtime;
	}

	public String getLocaltime(){
		return localtime;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setLocaltimeEpoch(int localtimeEpoch){
		this.localtimeEpoch = localtimeEpoch;
	}

	public int getLocaltimeEpoch(){
		return localtimeEpoch;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLon(Object lon){
		this.lon = lon;
	}

	public Object getLon(){
		return lon;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	public void setTzId(String tzId){
		this.tzId = tzId;
	}

	public String getTzId(){
		return tzId;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"localtime = '" + localtime + '\'' + 
			",country = '" + country + '\'' + 
			",localtime_epoch = '" + localtimeEpoch + '\'' + 
			",name = '" + name + '\'' + 
			",lon = '" + lon + '\'' + 
			",region = '" + region + '\'' + 
			",lat = '" + lat + '\'' + 
			",tz_id = '" + tzId + '\'' + 
			"}";
		}
}