package com.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
@Table(name = "User_Profile")
public class UserProfile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_DET_ID", nullable = true, length = 32)
	private Integer profileId;

	@Column(name = "Display_Name", nullable = true, length = 32)
	private String displayName;

	@Column(name = "current_Profile", nullable = true, length = 32)
	private String currentProfile;
	
	@Column(name = "About_User", nullable = true, length = 32)
	private String aboutUser;
	
	@Column(name = "File_Create_Date", nullable = true, length = 32)
	private String createDate;


	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="USR_DET_ID", nullable = true)
	private List<MediaFiles> files=new ArrayList<MediaFiles>();


	public Integer getProfileId() {
		return profileId;
	}


	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getCurrentProfile() {
		return currentProfile;
	}


	public void setCurrentProfile(String currentProfile) {
		this.currentProfile = currentProfile;
	}


	public String getAboutUser() {
		return aboutUser;
	}


	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public List<MediaFiles> getFiles() {
		return files;
	}


	public void setFiles(List<MediaFiles> files) {
		this.files = files;
	}


	@Override
	public String toString() {
		return "UserProfile [profileId=" + profileId + ", displayName=" + displayName + ", currentProfile="
				+ currentProfile + ", aboutUser=" + aboutUser + ", createDate=" + createDate + ", files=" + files + "]";
	}

	 

}
