	package com.vinterbash.web.model;
	
	public class Organizer {
		private String organizerId;
		private String organizerName;
		private String password;
		private String yearOfPassing;
		private String qualification;
		private String contactNumber;
		
		
		public Organizer() {
			super();
		}
		
		public Organizer(String organizerId, String organizerName, String password, String yearOfPassing,
				String qualification, String contactNumber) {
			super();
			this.organizerId = organizerId;
			this.organizerName = organizerName;
			this.password = password;
			this.yearOfPassing = yearOfPassing;
			this.qualification = qualification;
			this.contactNumber = contactNumber;
		}
		
		public String getOrganizerId() {
			return organizerId;
		}
		public void setOrganizerId(String organizerId) {
			this.organizerId = organizerId;
		}
		public String getOrganizerName() {
			return organizerName;
		}
		public void setOrganizerName(String organizerName) {
			this.organizerName = organizerName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getYearOfPassing() {
			return yearOfPassing;
		}
		public void setYearOfPassing(String yearOfPassing) {
			this.yearOfPassing = yearOfPassing;
		}
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
	
	}
