package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Current.
 */
public class Current{

	@JsonProperty("feelslike_c")
	private Double feelslikeC;

	@JsonProperty("wetbulb_f")
	private Double wetbulbF;

	@JsonProperty("feelslike_f")
	private Double feelslikeF;

	@JsonProperty("wind_degree")
	private int windDegree;

	@JsonProperty("wetbulb_c")
	private Double wetbulbC;

	@JsonProperty("windchill_f")
	private Double windchillF;

	@JsonProperty("windchill_c")
	private Double windchillC;

	@JsonProperty("last_updated_epoch")
	private int lastUpdatedEpoch;

	@JsonProperty("temp_c")
	private Double tempC;

	@JsonProperty("temp_f")
	private Double tempF;

	@JsonProperty("cloud")
	private int cloud;

	@JsonProperty("wind_kph")
	private Double windKph;

	@JsonProperty("wind_mph")
	private Double windMph;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("dewpoint_f")
	private Double dewpointF;

	@JsonProperty("gti")
	private Double gti;

	@JsonProperty("dni")
	private Double dni;

	@JsonProperty("will_it_rain")
	private int willItRain;

	@JsonProperty("uv")
	private Double uv;

	@JsonProperty("last_updated")
	private String lastUpdated;

	@JsonProperty("heatindex_f")
	private Double heatindexF;

	@JsonProperty("dewpoint_c")
	private Double dewpointC;

	@JsonProperty("diff_rad")
	private Double diffRad;

	@JsonProperty("is_day")
	private int isDay;

	@JsonProperty("precip_in")
	private Double precipIn;

	@JsonProperty("heatindex_c")
	private Double heatindexC;

	@JsonProperty("wind_dir")
	private String windDir;

	@JsonProperty("gust_mph")
	private Double gustMph;

	@JsonProperty("pressure_in")
	private Double pressureIn;

	@JsonProperty("gust_kph")
	private Double gustKph;

	@JsonProperty("chance_of_rain")
	private int chanceOfRain;

	@JsonProperty("precip_mm")
	private Double precipMm;

	@JsonProperty("short_rad")
	private Double shortRad;

	@JsonProperty("condition")
	private Condition condition;

	@JsonProperty("will_it_snow")
	private int willItSnow;

	@JsonProperty("vis_km")
	private Double visKm;

	@JsonProperty("chance_of_snow")
	private int chanceOfSnow;

	@JsonProperty("pressure_mb")
	private Double pressureMb;

	@JsonProperty("vis_miles")
	private Double visMiles;

	/**
	 * Set feelslike c.
	 *
	 * @param feelslikeC the feelslike c
	 */
	public void setFeelslikeC(Double feelslikeC){
		this.feelslikeC = feelslikeC;
	}

	/**
	 * Get feelslike c Double.
	 *
	 * @return the Double
	 */
	public Double getFeelslikeC(){
		return feelslikeC;
	}

	/**
	 * Set wetbulb f.
	 *
	 * @param wetbulbF the wetbulb f
	 */
	public void setWetbulbF(Double wetbulbF){
		this.wetbulbF = wetbulbF;
	}

	/**
	 * Get wetbulb f Double.
	 *
	 * @return the Double
	 */
	public Double getWetbulbF(){
		return wetbulbF;
	}

	/**
	 * Set feelslike f.
	 *
	 * @param feelslikeF the feelslike f
	 */
	public void setFeelslikeF(Double feelslikeF){
		this.feelslikeF = feelslikeF;
	}

	/**
	 * Get feelslike f Double.
	 *
	 * @return the Double
	 */
	public Double getFeelslikeF(){
		return feelslikeF;
	}

	/**
	 * Set wind degree.
	 *
	 * @param windDegree the wind degree
	 */
	public void setWindDegree(int windDegree){
		this.windDegree = windDegree;
	}

	/**
	 * Get wind degree int.
	 *
	 * @return the int
	 */
	public int getWindDegree(){
		return windDegree;
	}

	/**
	 * Set wetbulb c.
	 *
	 * @param wetbulbC the wetbulb c
	 */
	public void setWetbulbC(Double wetbulbC){
		this.wetbulbC = wetbulbC;
	}

	/**
	 * Get wetbulb c Double.
	 *
	 * @return the Double
	 */
	public Double getWetbulbC(){
		return wetbulbC;
	}

	/**
	 * Set windchill f.
	 *
	 * @param windchillF the windchill f
	 */
	public void setWindchillF(Double windchillF){
		this.windchillF = windchillF;
	}

	/**
	 * Get windchill f Double.
	 *
	 * @return the Double
	 */
	public Double getWindchillF(){
		return windchillF;
	}

	/**
	 * Set windchill c.
	 *
	 * @param windchillC the windchill c
	 */
	public void setWindchillC(Double windchillC){
		this.windchillC = windchillC;
	}

	/**
	 * Get windchill c Double.
	 *
	 * @return the Double
	 */
	public Double getWindchillC(){
		return windchillC;
	}

	/**
	 * Set last updated epoch.
	 *
	 * @param lastUpdatedEpoch the last updated epoch
	 */
	public void setLastUpdatedEpoch(int lastUpdatedEpoch){
		this.lastUpdatedEpoch = lastUpdatedEpoch;
	}

	/**
	 * Get last updated epoch int.
	 *
	 * @return the int
	 */
	public int getLastUpdatedEpoch(){
		return lastUpdatedEpoch;
	}

	/**
	 * Set temp c.
	 *
	 * @param tempC the temp c
	 */
	public void setTempC(Double tempC){
		this.tempC = tempC;
	}

	/**
	 * Get temp c Double.
	 *
	 * @return the Double
	 */
	public Double getTempC(){
		return tempC;
	}

	/**
	 * Set temp f.
	 *
	 * @param tempF the temp f
	 */
	public void setTempF(Double tempF){
		this.tempF = tempF;
	}

	/**
	 * Get temp f Double.
	 *
	 * @return the Double
	 */
	public Double getTempF(){
		return tempF;
	}

	/**
	 * Set cloud.
	 *
	 * @param cloud the cloud
	 */
	public void setCloud(int cloud){
		this.cloud = cloud;
	}

	/**
	 * Get cloud int.
	 *
	 * @return the int
	 */
	public int getCloud(){
		return cloud;
	}

	/**
	 * Set wind kph.
	 *
	 * @param windKph the wind kph
	 */
	public void setWindKph(Double windKph){
		this.windKph = windKph;
	}

	/**
	 * Get wind kph Double.
	 *
	 * @return the Double
	 */
	public Double getWindKph(){
		return windKph;
	}

	/**
	 * Set wind mph.
	 *
	 * @param windMph the wind mph
	 */
	public void setWindMph(Double windMph){
		this.windMph = windMph;
	}

	/**
	 * Get wind mph Double.
	 *
	 * @return the Double
	 */
	public Double getWindMph(){
		return windMph;
	}

	/**
	 * Set humidity.
	 *
	 * @param humidity the humidity
	 */
	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	/**
	 * Get humidity int.
	 *
	 * @return the int
	 */
	public int getHumidity(){
		return humidity;
	}

	/**
	 * Set dewpoint f.
	 *
	 * @param dewpointF the dewpoint f
	 */
	public void setDewpointF(Double dewpointF){
		this.dewpointF = dewpointF;
	}

	/**
	 * Get dewpoint f Double.
	 *
	 * @return the Double
	 */
	public Double getDewpointF(){
		return dewpointF;
	}

	/**
	 * Set gti.
	 *
	 * @param gti the gti
	 */
	public void setGti(Double gti){
		this.gti = gti;
	}

	/**
	 * Get gti Double.
	 *
	 * @return the Double
	 */
	public Double getGti(){
		return gti;
	}

	/**
	 * Set dni.
	 *
	 * @param dni the dni
	 */
	public void setDni(Double dni){
		this.dni = dni;
	}

	/**
	 * Get dni Double.
	 *
	 * @return the Double
	 */
	public Double getDni(){
		return dni;
	}

	/**
	 * Set will it rain.
	 *
	 * @param willItRain the will it rain
	 */
	public void setWillItRain(int willItRain){
		this.willItRain = willItRain;
	}

	/**
	 * Get will it rain int.
	 *
	 * @return the int
	 */
	public int getWillItRain(){
		return willItRain;
	}

	/**
	 * Set uv.
	 *
	 * @param uv the uv
	 */
	public void setUv(Double uv){
		this.uv = uv;
	}

	/**
	 * Get uv Double.
	 *
	 * @return the Double
	 */
	public Double getUv(){
		return uv;
	}

	/**
	 * Set last updated.
	 *
	 * @param lastUpdated the last updated
	 */
	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	/**
	 * Get last updated string.
	 *
	 * @return the string
	 */
	public String getLastUpdated(){
		return lastUpdated;
	}

	/**
	 * Set heatindex f.
	 *
	 * @param heatindexF the heatindex f
	 */
	public void setHeatindexF(Double heatindexF){
		this.heatindexF = heatindexF;
	}

	/**
	 * Get heatindex f Double.
	 *
	 * @return the Double
	 */
	public Double getHeatindexF(){
		return heatindexF;
	}

	/**
	 * Set dewpoint c.
	 *
	 * @param dewpointC the dewpoint c
	 */
	public void setDewpointC(Double dewpointC){
		this.dewpointC = dewpointC;
	}

	/**
	 * Get dewpoint c Double.
	 *
	 * @return the Double
	 */
	public Double getDewpointC(){
		return dewpointC;
	}

	/**
	 * Set diff rad.
	 *
	 * @param diffRad the diff rad
	 */
	public void setDiffRad(Double diffRad){
		this.diffRad = diffRad;
	}

	/**
	 * Get diff rad Double.
	 *
	 * @return the Double
	 */
	public Double getDiffRad(){
		return diffRad;
	}

	/**
	 * Set is day.
	 *
	 * @param isDay the is day
	 */
	public void setIsDay(int isDay){
		this.isDay = isDay;
	}

	/**
	 * Get is day int.
	 *
	 * @return the int
	 */
	public int getIsDay(){
		return isDay;
	}

	/**
	 * Set precip in.
	 *
	 * @param precipIn the precip in
	 */
	public void setPrecipIn(Double precipIn){
		this.precipIn = precipIn;
	}

	/**
	 * Get precip in Double.
	 *
	 * @return the Double
	 */
	public Double getPrecipIn(){
		return precipIn;
	}

	/**
	 * Set heatindex c.
	 *
	 * @param heatindexC the heatindex c
	 */
	public void setHeatindexC(Double heatindexC){
		this.heatindexC = heatindexC;
	}

	/**
	 * Get heatindex c Double.
	 *
	 * @return the Double
	 */
	public Double getHeatindexC(){
		return heatindexC;
	}

	/**
	 * Set wind dir.
	 *
	 * @param windDir the wind dir
	 */
	public void setWindDir(String windDir){
		this.windDir = windDir;
	}

	/**
	 * Get wind dir string.
	 *
	 * @return the string
	 */
	public String getWindDir(){
		return windDir;
	}

	/**
	 * Set gust mph.
	 *
	 * @param gustMph the gust mph
	 */
	public void setGustMph(Double gustMph){
		this.gustMph = gustMph;
	}

	/**
	 * Get gust mph Double.
	 *
	 * @return the Double
	 */
	public Double getGustMph(){
		return gustMph;
	}

	/**
	 * Set pressure in.
	 *
	 * @param pressureIn the pressure in
	 */
	public void setPressureIn(Double pressureIn){
		this.pressureIn = pressureIn;
	}

	/**
	 * Get pressure in Double.
	 *
	 * @return the Double
	 */
	public Double getPressureIn(){
		return pressureIn;
	}

	/**
	 * Set gust kph.
	 *
	 * @param gustKph the gust kph
	 */
	public void setGustKph(Double gustKph){
		this.gustKph = gustKph;
	}

	/**
	 * Get gust kph Double.
	 *
	 * @return the Double
	 */
	public Double getGustKph(){
		return gustKph;
	}

	/**
	 * Set chance of rain.
	 *
	 * @param chanceOfRain the chance of rain
	 */
	public void setChanceOfRain(int chanceOfRain){
		this.chanceOfRain = chanceOfRain;
	}

	/**
	 * Get chance of rain int.
	 *
	 * @return the int
	 */
	public int getChanceOfRain(){
		return chanceOfRain;
	}

	/**
	 * Set precip mm.
	 *
	 * @param precipMm the precip mm
	 */
	public void setPrecipMm(Double precipMm){
		this.precipMm = precipMm;
	}

	/**
	 * Get precip mm Double.
	 *
	 * @return the Double
	 */
	public Double getPrecipMm(){
		return precipMm;
	}

	/**
	 * Set short rad.
	 *
	 * @param shortRad the short rad
	 */
	public void setShortRad(Double shortRad){
		this.shortRad = shortRad;
	}

	/**
	 * Get short rad Double.
	 *
	 * @return the Double
	 */
	public Double getShortRad(){
		return shortRad;
	}

	/**
	 * Set condition.
	 *
	 * @param condition the condition
	 */
	public void setCondition(Condition condition){
		this.condition = condition;
	}

	/**
	 * Get condition condition.
	 *
	 * @return the condition
	 */
	public Condition getCondition(){
		return condition;
	}

	/**
	 * Set will it snow.
	 *
	 * @param willItSnow the will it snow
	 */
	public void setWillItSnow(int willItSnow){
		this.willItSnow = willItSnow;
	}

	/**
	 * Get will it snow int.
	 *
	 * @return the int
	 */
	public int getWillItSnow(){
		return willItSnow;
	}

	/**
	 * Set vis km.
	 *
	 * @param visKm the vis km
	 */
	public void setVisKm(Double visKm){
		this.visKm = visKm;
	}

	/**
	 * Get vis km Double.
	 *
	 * @return the Double
	 */
	public Double getVisKm(){
		return visKm;
	}

	/**
	 * Set chance of snow.
	 *
	 * @param chanceOfSnow the chance of snow
	 */
	public void setChanceOfSnow(int chanceOfSnow){
		this.chanceOfSnow = chanceOfSnow;
	}

	/**
	 * Get chance of snow int.
	 *
	 * @return the int
	 */
	public int getChanceOfSnow(){
		return chanceOfSnow;
	}

	/**
	 * Set pressure mb.
	 *
	 * @param pressureMb the pressure mb
	 */
	public void setPressureMb(Double pressureMb){
		this.pressureMb = pressureMb;
	}

	/**
	 * Get pressure mb Double.
	 *
	 * @return the Double
	 */
	public Double getPressureMb(){
		return pressureMb;
	}

	/**
	 * Set vis miles.
	 *
	 * @param visMiles the vis miles
	 */
	public void setVisMiles(Double visMiles){
		this.visMiles = visMiles;
	}

	/**
	 * Get vis miles Double.
	 *
	 * @return the Double
	 */
	public Double getVisMiles(){
		return visMiles;
	}

	@Override
 	public String toString(){
		return 
			"Current{" + 
			"feelslike_c = '" + feelslikeC + '\'' + 
			",wetbulb_f = '" + wetbulbF + '\'' + 
			",feelslike_f = '" + feelslikeF + '\'' + 
			",wind_degree = '" + windDegree + '\'' + 
			",wetbulb_c = '" + wetbulbC + '\'' + 
			",windchill_f = '" + windchillF + '\'' + 
			",windchill_c = '" + windchillC + '\'' + 
			",last_updated_epoch = '" + lastUpdatedEpoch + '\'' + 
			",temp_c = '" + tempC + '\'' + 
			",temp_f = '" + tempF + '\'' + 
			",cloud = '" + cloud + '\'' + 
			",wind_kph = '" + windKph + '\'' + 
			",wind_mph = '" + windMph + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",dewpoint_f = '" + dewpointF + '\'' + 
			",gti = '" + gti + '\'' + 
			",dni = '" + dni + '\'' + 
			",will_it_rain = '" + willItRain + '\'' + 
			",uv = '" + uv + '\'' + 
			",last_updated = '" + lastUpdated + '\'' + 
			",heatindex_f = '" + heatindexF + '\'' + 
			",dewpoint_c = '" + dewpointC + '\'' + 
			",diff_rad = '" + diffRad + '\'' + 
			",is_day = '" + isDay + '\'' + 
			",precip_in = '" + precipIn + '\'' + 
			",heatindex_c = '" + heatindexC + '\'' + 
			",wind_dir = '" + windDir + '\'' + 
			",gust_mph = '" + gustMph + '\'' + 
			",pressure_in = '" + pressureIn + '\'' + 
			",gust_kph = '" + gustKph + '\'' + 
			",chance_of_rain = '" + chanceOfRain + '\'' + 
			",precip_mm = '" + precipMm + '\'' + 
			",short_rad = '" + shortRad + '\'' + 
			",condition = '" + condition + '\'' + 
			",will_it_snow = '" + willItSnow + '\'' + 
			",vis_km = '" + visKm + '\'' + 
			",chance_of_snow = '" + chanceOfSnow + '\'' + 
			",pressure_mb = '" + pressureMb + '\'' + 
			",vis_miles = '" + visMiles + '\'' + 
			"}";
		}
}