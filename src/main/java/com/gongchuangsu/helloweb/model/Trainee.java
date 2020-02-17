package com.gongchuangsu.helloweb.model;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

	@Entity
	@Table(name = "trainee")
	public class Trainee {

	    private long id;
	    private String employee_name;
	    private String employee_email;
	    private Date created_at;
	    private Date updated_at;
	    private MultipartFile picture;
	    private String pictureBase64;
	    private String fileName;
	    private String best_time;
	    private String attempt;
	    
	    public String getBest_time() {
			return best_time;
		}

		public void setBest_time(String best_time) {
			this.best_time = best_time;
		}

	    public String getAttempt() {
			return attempt;
		}

		public void setAttempt(String attempt) {
			this.attempt = attempt;
		}
	    
//	    @Access(AccessType.PROPERTY)
//	    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	    @JoinColumn(name = "id", referencedColumnName = "employee_id")
//	    private Session session;
//	    
//
//		public Session getSession() {
//			return session;
//		}
//
//		public void setSessions(Session session) {
//			this.session = session;
//		}
//	    
	    public Trainee(){
	    	
	    }
	    
	    public Trainee(long id, String employee_name, String employee_email, Date created_at,
	    		Date updated_at, MultipartFile picture, String pictureBase64, String fileName) {
	    	this.id = id;
	    	this.employee_name= employee_name;
	    	this.employee_email = employee_email;
	    	this.created_at = created_at;
	    	this.updated_at = updated_at;
	    	this.picture = picture;
	    	this.pictureBase64 = pictureBase64;
	    	this.fileName = fileName;
	    }
	    
	    @Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		@Column(name = "name", nullable = false)
		public String getEmployee_name() {
			return employee_name;
		}

		public void setEmployee_name(String employee_name) {
			this.employee_name = employee_name;
		}

		@Column(name = "employee_email", nullable = false)
		public String getEmployee_email() {
			return employee_email;
		}

		public void setEmployee_email(String employee_email) {
			this.employee_email = employee_email;
		}

		@Column(name = "created_at", nullable = true)
		public Date getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}

		@Column(name = "updated_at", nullable = true)
		public Date getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(Date updated_at) {
			this.updated_at = updated_at;
		}
		
		@Transient
		public MultipartFile getPicture() {
			return picture;
		}

		public void setPicture(MultipartFile picture) {
			this.picture = picture;
		}

		@Column(name = "pictureBase64", nullable = true)
		public String getPictureBase64() {
			return pictureBase64;
		}

		public void setPictureBase64(String pictureBase64) {
			this.pictureBase64 = pictureBase64;
		}

		@Column(name = "fileName", nullable = true)
		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		@Override
	    public String toString() {
			return "Trainee [id=" + id + ", employee_name=" + employee_name + ", employee_email=" + employee_email
					+ ", created_at=" + created_at + ", updated_at=" + updated_at 
					+ ",picture = "+ picture +"]";
		}

	}
