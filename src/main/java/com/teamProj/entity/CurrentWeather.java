package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Current weather.
 */
public class CurrentWeather{

	@JsonProperty("current")
	private Current current;

	@JsonProperty("location")
	private Location location;

	/**
	 * Set current.
	 *
	 * @param current the current
	 */
	public void setCurrent(Current current){
		this.current = current;
	}

	/**
	 * Get current current.
	 *
	 * @return the current
	 */
	public Current getCurrent(){
		return current;
	}

	/**
	 * Set location.
	 *
	 * @param location the location
	 */
	public void setLocation(Location location){
		this.location = location;
	}

	/**
	 * Get location location.
	 *
	 * @return the location
	 */
	public Location getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"CurrentWeather{" + 
			"current = '" + current + '\'' + 
			",location = '" + location + '\'' + 
			"}";
		}
}