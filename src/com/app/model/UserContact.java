package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
@Table(name = "USER_CONTACT")
public class UserContact implements Serializable{

	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	private int contactId;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name = "profile_Pic")
	private String profilePic;
	
	@Column(name = "ISBLOCKED")
	private boolean isBlocked;

	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATE_DATE", nullable = true, length = 200)
	private String createDate;
	
	/*
	 * @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) private
	 * List<GroupProfile> groupList = new ArrayList<>();
	 */
	
	//for joing the tables (many-to-many)
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "group_profile_group_member",
	joinColumns = {
	@JoinColumn(name="contact_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="group_id")
	}
	)
	private Set<GroupProfile> groupList;
	
	public UserContact() {
		super();
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Set<GroupProfile> getGroupList() {
		return groupList;
	}

	public void setGroupList(Set<GroupProfile> groupList) {
		this.groupList = groupList;
	}

	@Override
	public String toString() {
		return "UserContact [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber="
				+ contactNumber + ", profilePic=" + profilePic + ", isBlocked=" + isBlocked + ", isActive=" + isActive
				+ ", createDate=" + createDate + ", groupList=" + groupList + "]";
	}

	

}
