package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GroupAdmin")
public class GroupAdmin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Admin_ID")
	private Integer adminId;

	@Column(name = "Contact_Id")
	private Integer ContactId;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getContactId() {
		return ContactId;
	}

	public void setContactId(Integer contactId) {
		ContactId = contactId;
	}

	@Override
	public String toString() {
		return "GroupAdmin [adminId=" + adminId + ", ContactId=" + ContactId + "]";
	}




	
}
