package com.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
@Table(name = "User_Register")
public class UserRegister implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userId;

	@Column(name = "user_name", nullable = true, length = 32)
	private String userName;

	@Column(name = "Source_From", nullable = true, length = 24)
	private String sourceFrom;

	@Column(name = "pass_word", nullable = true, length = 24)
	private String password;


	@Column(name = "mobil_number", nullable = true, length = 13)
	private String mobilNumber;
	
	@Column(name = "token", nullable = true, length = 200)
	private long Token;
	
	@Column(name = "pattern" ,nullable = true, length = 200)
	private String pattern;

	@Column(name = "status", nullable = true, length = 200)
	private Boolean isActive;
	
	@Column(name = "createDate", nullable = true)
	private String createDate;
	
	@Column(name = "lastModifiedDate", nullable = true, length = 200)
	private Date lastModifiedDate;
	


	@OneToOne(cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="USR_DET_ID")
	private UserProfile profile = new UserProfile();



	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable (name = "user_groups", joinColumns=
	    { @JoinColumn (name = "userid")}, inverseJoinColumns=
	    { @JoinColumn (name = "group_id")})
	private List<GroupProfile> groupList;




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getSourceFrom() {
		return sourceFrom;
	}




	public void setSourceFrom(String sourceFrom) {
		this.sourceFrom = sourceFrom;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getMobilNumber() {
		return mobilNumber;
	}




	public void setMobilNumber(String mobilNumber) {
		this.mobilNumber = mobilNumber;
	}




	public long getToken() {
		return Token;
	}




	public void setToken(long token) {
		Token = token;
	}




	public String getPattern() {
		return pattern;
	}




	public void setPattern(String pattern) {
		this.pattern = pattern;
	}




	public Boolean getIsActive() {
		return isActive;
	}




	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}




	public String getCreateDate() {
		return createDate;
	}




	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}




	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}




	public void setLastModifiedDate(Date date) {
		this.lastModifiedDate = date;
	}




	public UserProfile getProfile() {
		return profile;
	}




	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}




	public List<GroupProfile> getGroupList() {
		return groupList;
	}




	public void setGroupList(List<GroupProfile> groupList) {
		this.groupList = groupList;
	}




	@Override
	public String toString() {
		return "UserRegister [userId=" + userId + ", userName=" + userName + ", sourceFrom=" + sourceFrom
				+ ", password=" + password + ", mobilNumber=" + mobilNumber + ", Token=" + Token + ", pattern="
				+ pattern + ", isActive=" + isActive + ", createDate=" + createDate + ", lastModifiedDate="
				+ lastModifiedDate + ", profile=" + profile + "]";
	}
	

}
