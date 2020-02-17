
package com.gongchuangsu.helloweb.model;

import java.sql.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {

	private long id;
	private Integer employee_id;
	private int attempts;
	private String time_taken;
	private String time_taken_module_1;
	private String time_taken_module_2;
	private String time_taken_module_3;
	private String score_module_1;
	private String score_module_2;
	private String score_module_3;
	private String date_taken;
	private String score_received;
	private String type;
	private String platform;
	private String session_status;
	private Date created_at;
	private Date updated_at;
	private String status;
	private String employee_name;
	private int archives;
	private String pictureBase64;
	
	public Session() {

	}
	public Session(long id, int employee_id, int attempts, String time_taken, String time_taken_module_1,
			String time_taken_module_2, String time_taken_module_3, String date_taken, String score_received,
			String type, String platform, String session_status, Date created_at, Date updated_at, String status) {
		this.id = id;
		this.employee_id = employee_id;
		this.attempts = attempts;
		this.time_taken = time_taken;
		this.time_taken_module_1 = time_taken_module_1;
		this.time_taken_module_2 = time_taken_module_2;
		this.time_taken_module_3 = time_taken_module_3;
		this.date_taken = date_taken;
		this.score_received = score_received;
		this.type = type;
		this.platform = platform;
		this.session_status = session_status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.status = status;
	}

	
	public String getEmployee_name() {
		return employee_name;
	}
	
	public void setEmployee_name(String name) {
		this.employee_name = name;
	}

	public String getPictureBase64() {
		return pictureBase64;
	}
	
	public String setPictureBase64(String PictureBase64) {
		return this.pictureBase64 = PictureBase64;
	}

	@Column(name = "archives", nullable = false)
	public int getArchives() {
		return archives;
	}
	
	public void setArchives(int a) {
		this.archives = a;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "employee_id", nullable = false)
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Column(name = "attempts", nullable = false)
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	@Column(name = "time_taken", nullable = false)
	public String getTime_taken() {
		return time_taken;
	}

	public void setTime_taken(String time_taken) {
		this.time_taken = time_taken;
	}

	@Column(name = "score_module_1", nullable = true)
	public String getScore_module_1() {
		return score_module_1;
	}

	public void setScore_module_1(String score_module_1) {
		this.score_module_1 = score_module_1;
	}

	@Column(name = "score_module_2", nullable = true)
	public String getScore_module_2() {
		return score_module_2;
	}

	public void setScore_module_2(String score_module_2) {
		this.score_module_2 = score_module_2;
	}

	@Column(name = "score_module_3", nullable = true)
	public String getScore_module_3() {
		return score_module_3;
	}

	public void setScore_module_3(String score_module_3) {
		this.score_module_3 = score_module_3;
	}

	@Column(name = "time_taken_module_1", nullable = false)
	public String getTime_taken_module_1() {
		return time_taken_module_1;
	}

	public void setTime_taken_module_1(String time_taken_module_1) {
		this.time_taken_module_1 = time_taken_module_1;
	}

	@Column(name = "time_taken_module_2", nullable = false)
	public String getTime_taken_module_2() {
		return time_taken_module_2;
	}

	public void setTime_taken_module_2(String time_taken_module_2) {
		this.time_taken_module_2 = time_taken_module_2;
	}

	@Column(name = "time_taken_module_3", nullable = false)
	public String getTime_taken_module_3() {
		return time_taken_module_3;
	}

	public void setTime_taken_module_3(String time_taken_module_3) {
		this.time_taken_module_3 = time_taken_module_3;
	}

	@Column(name = "date_taken", nullable = false)
	public String getDate_taken() {
		return date_taken;
	}

	public void setDate_taken(String date_taken) {
		this.date_taken = date_taken;
	}

	@Column(name = "score_received", nullable = true)
	public String getScore_received() {
		return score_received;
	}

	public void setScore_received(String score_received) {
		this.score_received = score_received;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "platform", nullable = false)
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Column(name = "session_status", nullable = false)
	public String getSession_status() {
		return session_status;
	}

	public void setSession_status(String session_status) {
		this.session_status = session_status;
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

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", employee_id=" + employee_id + ", attempts=" + attempts + ", time_taken="
				+ time_taken + "," + ", time_taken_module_1 = " + time_taken_module_1 + ", time_taken_module_2 = "
				+ time_taken_module_2 + ", time_taken_module_3 = " + time_taken_module_3 + ", date_taken = "
				+ date_taken + ", score_received = " + score_received + ", type = " + type + ", platform = " + platform
				+ ",session_status = " + session_status + ", created_at = " + created_at + ", updated_at = "
				+ updated_at + ", status = " + status + "]";
	}

}