package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Current.
 */
public class Current{

	@JsonProperty("feelslike_c")
	private double feelslikeC;

	@JsonProperty("wetbulb_f")
	private double wetbulbF;

	@JsonProperty("feelslike_f")
	private double feelslikeF;

	@JsonProperty("wind_degree")
	private int windDegree;

	@JsonProperty("wetbulb_c")
	private double wetbulbC;

	@JsonProperty("windchill_f")
	private double windchillF;

	@JsonProperty("windchill_c")
	private double windchillC;

	@JsonProperty("last_updated_epoch")
	private int lastUpdatedEpoch;

	@JsonProperty("temp_c")
	private double tempC;

	@JsonProperty("temp_f")
	private double tempF;

	@JsonProperty("cloud")
	private int cloud;

	@JsonProperty("wind_kph")
	private double windKph;

	@JsonProperty("wind_mph")
	private double windMph;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("dewpoint_f")
	private double dewpointF;

	@JsonProperty("gti")
	private double gti;

	@JsonProperty("dni")
	private double dni;

	@JsonProperty("will_it_rain")
	private int willItRain;

	@JsonProperty("uv")
	private double uv;

	@JsonProperty("last_updated")
	private String lastUpdated;

	@JsonProperty("heatindex_f")
	private double heatindexF;

	@JsonProperty("dewpoint_c")
	private double dewpointC;

	@JsonProperty("diff_rad")
	private double diffRad;

	@JsonProperty("is_day")
	private int isDay;

	@JsonProperty("precip_in")
	private double precipIn;

	@JsonProperty("heatindex_c")
	private double heatindexC;

	@JsonProperty("wind_dir")
	private String windDir;

	@JsonProperty("gust_mph")
	private double gustMph;

	@JsonProperty("pressure_in")
	private double pressureIn;

	@JsonProperty("gust_kph")
	private double gustKph;

	@JsonProperty("chance_of_rain")
	private int chanceOfRain;

	@JsonProperty("precip_mm")
	private double precipMm;

	@JsonProperty("short_rad")
	private double shortRad;

	@JsonProperty("condition")
	private Condition condition;

	@JsonProperty("will_it_snow")
	private int willItSnow;

	@JsonProperty("vis_km")
	private double visKm;

	@JsonProperty("chance_of_snow")
	private int chanceOfSnow;

	@JsonProperty("pressure_mb")
	private double pressureMb;

	@JsonProperty("vis_miles")
	private double visMiles;

	/**
	 * Set feelslike c.
	 *
	 * @param feelslikeC the feelslike c
	 */
	public void setFeelslikeC(double feelslikeC){
		this.feelslikeC = feelslikeC;
	}

	/**
	 * Get feelslike c double.
	 *
	 * @return the double
	 */
	public double getFeelslikeC(){
		return feelslikeC;
	}

	/**
	 * Set wetbulb f.
	 *
	 * @param wetbulbF the wetbulb f
	 */
	public void setWetbulbF(double wetbulbF){
		this.wetbulbF = wetbulbF;
	}

	/**
	 * Get wetbulb f double.
	 *
	 * @return the double
	 */
	public double getWetbulbF(){
		return wetbulbF;
	}

	/**
	 * Set feelslike f.
	 *
	 * @param feelslikeF the feelslike f
	 */
	public void setFeelslikeF(double feelslikeF){
		this.feelslikeF = feelslikeF;
	}

	/**
	 * Get feelslike f double.
	 *
	 * @return the double
	 */
	public double getFeelslikeF(){
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
	public void setWetbulbC(double wetbulbC){
		this.wetbulbC = wetbulbC;
	}

	/**
	 * Get wetbulb c double.
	 *
	 * @return the double
	 */
	public double getWetbulbC(){
		return wetbulbC;
	}

	/**
	 * Set windchill f.
	 *
	 * @param windchillF the windchill f
	 */
	public void setWindchillF(double windchillF){
		this.windchillF = windchillF;
	}

	/**
	 * Get windchill f double.
	 *
	 * @return the double
	 */
	public double getWindchillF(){
		return windchillF;
	}

	/**
	 * Set windchill c.
	 *
	 * @param windchillC the windchill c
	 */
	public void setWindchillC(double windchillC){
		this.windchillC = windchillC;
	}

	/**
	 * Get windchill c double.
	 *
	 * @return the double
	 */
	public double getWindchillC(){
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
	public void setTempC(double tempC){
		this.tempC = tempC;
	}

	/**
	 * Get temp c double.
	 *
	 * @return the double
	 */
	public double getTempC(){
		return tempC;
	}

	/**
	 * Set temp f.
	 *
	 * @param tempF the temp f
	 */
	public void setTempF(double tempF){
		this.tempF = tempF;
	}

	/**
	 * Get temp f double.
	 *
	 * @return the double
	 */
	public double getTempF(){
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
	public void setWindKph(double windKph){
		this.windKph = windKph;
	}

	/**
	 * Get wind kph double.
	 *
	 * @return the double
	 */
	public double getWindKph(){
		return windKph;
	}

	/**
	 * Set wind mph.
	 *
	 * @param windMph the wind mph
	 */
	public void setWindMph(double windMph){
		this.windMph = windMph;
	}

	/**
	 * Get wind mph double.
	 *
	 * @return the double
	 */
	public double getWindMph(){
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
	public void setDewpointF(double dewpointF){
		this.dewpointF = dewpointF;
	}

	/**
	 * Get dewpoint f double.
	 *
	 * @return the double
	 */
	public double getDewpointF(){
		return dewpointF;
	}

	/**
	 * Set gti.
	 *
	 * @param gti the gti
	 */
	public void setGti(double gti){
		this.gti = gti;
	}

	/**
	 * Get gti double.
	 *
	 * @return the double
	 */
	public double getGti(){
		return gti;
	}

	/**
	 * Set dni.
	 *
	 * @param dni the dni
	 */
	public void setDni(double dni){
		this.dni = dni;
	}

	/**
	 * Get dni double.
	 *
	 * @return the double
	 */
	public double getDni(){
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
	public void setUv(double uv){
		this.uv = uv;
	}

	/**
	 * Get uv double.
	 *
	 * @return the double
	 */
	public double getUv(){
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
	public void setHeatindexF(double heatindexF){
		this.heatindexF = heatindexF;
	}

	/**
	 * Get heatindex f double.
	 *
	 * @return the double
	 */
	public double getHeatindexF(){
		return heatindexF;
	}

	/**
	 * Set dewpoint c.
	 *
	 * @param dewpointC the dewpoint c
	 */
	public void setDewpointC(double dewpointC){
		this.dewpointC = dewpointC;
	}

	/**
	 * Get dewpoint c double.
	 *
	 * @return the double
	 */
	public double getDewpointC(){
		return dewpointC;
	}

	/**
	 * Set diff rad.
	 *
	 * @param diffRad the diff rad
	 */
	public void setDiffRad(double diffRad){
		this.diffRad = diffRad;
	}

	/**
	 * Get diff rad double.
	 *
	 * @return the double
	 */
	public double getDiffRad(){
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
	public void setPrecipIn(double precipIn){
		this.precipIn = precipIn;
	}

	/**
	 * Get precip in double.
	 *
	 * @return the double
	 */
	public double getPrecipIn(){
		return precipIn;
	}

	/**
	 * Set heatindex c.
	 *
	 * @param heatindexC the heatindex c
	 */
	public void setHeatindexC(double heatindexC){
		this.heatindexC = heatindexC;
	}

	/**
	 * Get heatindex c double.
	 *
	 * @return the double
	 */
	public double getHeatindexC(){
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
	public void setGustMph(double gustMph){
		this.gustMph = gustMph;
	}

	/**
	 * Get gust mph double.
	 *
	 * @return the double
	 */
	public double getGustMph(){
		return gustMph;
	}

	/**
	 * Set pressure in.
	 *
	 * @param pressureIn the pressure in
	 */
	public void setPressureIn(double pressureIn){
		this.pressureIn = pressureIn;
	}

	/**
	 * Get pressure in double.
	 *
	 * @return the double
	 */
	public double getPressureIn(){
		return pressureIn;
	}

	/**
	 * Set gust kph.
	 *
	 * @param gustKph the gust kph
	 */
	public void setGustKph(double gustKph){
		this.gustKph = gustKph;
	}

	/**
	 * Get gust kph double.
	 *
	 * @return the double
	 */
	public double getGustKph(){
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
	public void setPrecipMm(double precipMm){
		this.precipMm = precipMm;
	}

	/**
	 * Get precip mm double.
	 *
	 * @return the double
	 */
	public double getPrecipMm(){
		return precipMm;
	}

	/**
	 * Set short rad.
	 *
	 * @param shortRad the short rad
	 */
	public void setShortRad(double shortRad){
		this.shortRad = shortRad;
	}

	/**
	 * Get short rad double.
	 *
	 * @return the double
	 */
	public double getShortRad(){
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
	public void setVisKm(double visKm){
		this.visKm = visKm;
	}

	/**
	 * Get vis km double.
	 *
	 * @return the double
	 */
	public double getVisKm(){
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
	public void setPressureMb(double pressureMb){
		this.pressureMb = pressureMb;
	}

	/**
	 * Get pressure mb double.
	 *
	 * @return the double
	 */
	public double getPressureMb(){
		return pressureMb;
	}

	/**
	 * Set vis miles.
	 *
	 * @param visMiles the vis miles
	 */
	public void setVisMiles(double visMiles){
		this.visMiles = visMiles;
	}

	/**
	 * Get vis miles double.
	 *
	 * @return the double
	 */
	public double getVisMiles(){
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