package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Location.
 */
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
	private Double lon;

	@JsonProperty("region")
	private String region;

	@JsonProperty("lat")
	private Double lat;

	@JsonProperty("tz_id")
	private String tzId;

	/**
	 * Set localtime.
	 *
	 * @param localtime the localtime
	 */
	public void setLocaltime(String localtime){
		this.localtime = localtime;
	}

	/**
	 * Get localtime string.
	 *
	 * @return the string
	 */
	public String getLocaltime(){
		return localtime;
	}

	/**
	 * Set country.
	 *
	 * @param country the country
	 */
	public void setCountry(String country){
		this.country = country;
	}

	/**
	 * Get country string.
	 *
	 * @return the string
	 */
	public String getCountry(){
		return country;
	}

	/**
	 * Set localtime epoch.
	 *
	 * @param localtimeEpoch the localtime epoch
	 */
	public void setLocaltimeEpoch(int localtimeEpoch){
		this.localtimeEpoch = localtimeEpoch;
	}

	/**
	 * Get localtime epoch int.
	 *
	 * @return the int
	 */
	public int getLocaltimeEpoch(){
		return localtimeEpoch;
	}

	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Get name string.
	 *
	 * @return the string
	 */
	public String getName(){
		return name;
	}

	/**
	 * Set lon.
	 *
	 * @param lon the lon
	 */
	public void setLon(Double lon){
		this.lon = lon;
	}

	/**
	 * Get lon object.
	 *
	 * @return the object
	 */
	public Object getLon(){
		return lon;
	}

	/**
	 * Set region.
	 *
	 * @param region the region
	 */
	public void setRegion(String region){
		this.region = region;
	}

	/**
	 * Get region string.
	 *
	 * @return the string
	 */
	public String getRegion(){
		return region;
	}

	/**
	 * Set lat.
	 *
	 * @param lat the lat
	 */
	public void setLat(Double lat){
		this.lat = lat;
	}

	/**
	 * Get lat object.
	 *
	 * @return the object
	 */
	public Object getLat(){
		return lat;
	}

	/**
	 * Set tz id.
	 *
	 * @param tzId the tz id
	 */
	public void setTzId(String tzId){
		this.tzId = tzId;
	}

	/**
	 * Get tz id string.
	 *
	 * @return the string
	 */
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