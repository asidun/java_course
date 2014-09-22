package com.diosoft.trsine.calendar.common;

import java.util.List;
import java.util.UUID;

import java.util.Date;

public class Event {
	
	private String description;
	private Date startDate;
	private Date endDate;
	private List<Attendee> attendees;
	private String location;
	private UUID id;
	
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Attendee> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	private Event(Builder builder){
		this.description = builder.description;
		this.startDate = builder.startDate;
		this.endDate = builder.endDate;
		this.attendees = builder.attendees;
		this.location = builder.location;
		this.id = builder.id;
	}
	
	public static class Builder{
		
		private String description;		
		private Date endDate;
		private Date startDate;
		private List<Attendee> attendees;
		private String location;
		private UUID id;
		
		public Builder(){
			
		}
		
		public Builder description(String description){
			this.description = description;
			return this;
		}

		public Builder startDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}
		public Builder endDate(Date endDate) {
			this.endDate = endDate;
			return this;
		}
		public Builder attendees(List<Attendee> attendees) {
			this.attendees = attendees;
			return this;
		}

		public Builder location(String location) {
			this.location = location;
			return this;
		}

		public Builder id(UUID id) {			
			this.id = id;
			return this;
		}
		
		public Event build(){
			return new Event(this);
		}

	}

}
