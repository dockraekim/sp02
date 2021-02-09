package com.netchus.domain;

public class EnvironmentVO {

	private String sensorId;
	private double temp;
	private double humidity;
	private double tm1;
	private double tm2_5;
	private double tm10;
	private double co2;
	private double tvoc;
	private String date;
	public String getSensorId() {
		return sensorId;
	}

	public double getTemp() {
		return temp;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getTm1() {
		return tm1;
	}

	public double getTm2_5() {
		return tm2_5;
	}

	public double getTm10() {
		return tm10;
	}

	public double getco2() {
		return co2;
	}

	public double getTvoc() {
		return tvoc;
	}

	public String getDate() {
		return date;
	}

	
	public EnvironmentVO(String sensorId, double temp, double humidity, double tm1, double tm2_5, double tm10,
			double co2, double tvoc, String date) {
		super();
		this.sensorId = sensorId;
		this.temp = temp;
		this.humidity = humidity;
		this.tm1 = tm1;
		this.tm2_5 = tm2_5;
		this.tm10 = tm10;
		this.co2 = co2;
		this.tvoc = tvoc;
		this.date = date;
	}
	
	

	@Override
	public String toString() {
		return "{\"sensorId\":\"" + sensorId + "\", \"temp\":" + temp + ", \"humidity\":" + humidity + ", \"tm1\":" + tm1
				+ ", \"tm2_5\":" + tm2_5 + ", \"tm10\":" + tm10 + ", \"co2\":" + co2 + ", \"tvoc\":" + tvoc + ", \"date\":\"" + date + "\"}";
	}
	
}
