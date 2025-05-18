package com.vinterbash.web.model;

public class Result {
	String schoolName;
	String eventName;
	String eventPlace;
	Integer  eventPoints;
	
	public Result() {
		super();
	}

	public Result(String schoolName, String eventName, String eventPlace, Integer eventPoints) {
		super();
		this.schoolName = schoolName;
		this.eventName = eventName;
		this.eventPlace = eventPlace;
		this.eventPoints = eventPoints;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public Integer getEventPoints() {
		return eventPoints;
	}

	public void setEventPoints(Integer eventPoints) {
		this.eventPoints = eventPoints;
	}

	
	
	
	
	
}
