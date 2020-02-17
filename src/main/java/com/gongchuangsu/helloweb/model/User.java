package com.gongchuangsu.helloweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class User implements Serializable,UserDetails{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;              
	
	@NotNull
	@Column(name="name")
	private String name;
	

	@NotNull
	@Column(name="enabled")
	private int enabled;
	
	@NotNull
	@Column(name="employeeId")
	private String eid;
	
	@NotNull
	@Column(name="password")
	private String password;    
	
	@NotNull
	@Column(name="email")
	private String email; 

	@NotNull
	@Column(name="admin_position")
	private String admin_position; 

	@NotNull
	@Column(name="remember_token")
	private String remember_token; 
	
	public int getId(){
		return id;
	}

	public int setId(int id){
		return this.id = id;
	}

	public int getEnabled(){
		return enabled;
	}

	public int setEnabled(int val){
		return this.enabled = val;
	}
	public String getName() {
		return name;
	}

	public void setName(String username) {
		this.name = username;
	}

	public String getAdmin_position() {
		return admin_position;
	}

	public void setAdmin_position(String role) {
		this.admin_position = role;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid= eid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailaddress) {
		this.email = emailaddress;
	}

	public void setRememberMe(String remember_token) {
		this.remember_token = remember_token;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> userRole = new ArrayList<GrantedAuthority>();
		userRole.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "USER";
			}
		});
		return userRole;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
