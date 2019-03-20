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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Group_Profile")
public class GroupProfile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GROUP_ID")
	private Integer groupId;

	@Column(name = "Display_Name")
	private String displayName;
	
	@Column(name = "created_By", nullable = true, length = 40)
	private Integer createdBy;

	@Column(name = "current_Profile")
	private String currentProfile;

	@Column(name = "About_Group")
	private String aboutGroup;
	
	@OneToMany(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	private java.util.Set<GroupAdmin> adminSet = new java.util.HashSet<GroupAdmin>();

	@OneToMany(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	private List<MediaFiles> files = new ArrayList<MediaFiles>();


	
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	 * 
	 * @JoinTable(name = "group_profile_group_member", joinColumns =
	 * {@JoinColumn(name="groupId")}, inverseJoinColumns =
	 * {@JoinColumn(name="contactId")}) private List<UserContact> groupMember = new
	 * ArrayList<UserContact>();
	 */	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable (name = "group_profile_group_member", joinColumns=
	    { @JoinColumn (name = "group_id")}, inverseJoinColumns=
	    { @JoinColumn (name = "contact_id")})
	private List<UserContact> groupMember;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable (name = "user_groups", joinColumns=
	    { @JoinColumn (name = "group_id")}, inverseJoinColumns=
	    { @JoinColumn (name = "userid")})
	private List<GroupProfile> userList;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getCurrentProfile() {
		return currentProfile;
	}

	public void setCurrentProfile(String currentProfile) {
		this.currentProfile = currentProfile;
	}

	public String getAboutGroup() {
		return aboutGroup;
	}

	public void setAboutGroup(String aboutGroup) {
		this.aboutGroup = aboutGroup;
	}

	public java.util.Set<GroupAdmin> getAdminSet() {
		return adminSet;
	}

	public void setAdminSet(java.util.Set<GroupAdmin> adminSet) {
		this.adminSet = adminSet;
	}

	public List<MediaFiles> getFiles() {
		return files;
	}

	public void setFiles(List<MediaFiles> files) {
		this.files = files;
	}

	public List<UserContact> getGroupMember() {
		return groupMember;
	}

	public void setGroupMember(List<UserContact> groupMember) {
		this.groupMember = groupMember;
	}

	public List<GroupProfile> getUserList() {
		return userList;
	}

	public void setUserList(List<GroupProfile> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "GroupProfile [groupId=" + groupId + ", displayName=" + displayName + ", createdBy=" + createdBy
				+ ", currentProfile=" + currentProfile + ", aboutGroup=" + aboutGroup + ", adminSet=" + adminSet
				+ ", files=" + files + ", groupMember=" + groupMember + ", userList=" + userList + "]";
	}



}
