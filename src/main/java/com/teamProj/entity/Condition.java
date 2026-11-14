package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Condition.
 */
public class Condition{

	@JsonProperty("code")
	private int code;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("text")
	private String text;

	/**
	 * Set code.
	 *
	 * @param code the code
	 */
	public void setCode(int code){
		this.code = code;
	}

	/**
	 * Get code int.
	 *
	 * @return the int
	 */
	public int getCode(){
		return code;
	}

	/**
	 * Set icon.
	 *
	 * @param icon the icon
	 */
	public void setIcon(String icon){
		this.icon = icon;
	}

	/**
	 * Get icon string.
	 *
	 * @return the string
	 */
	public String getIcon(){
		return icon;
	}

	/**
	 * Set text.
	 *
	 * @param text the text
	 */
	public void setText(String text){
		this.text = text;
	}

	/**
	 * Get text string.
	 *
	 * @return the string
	 */
	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"Condition{" + 
			"code = '" + code + '\'' + 
			",icon = '" + icon + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}