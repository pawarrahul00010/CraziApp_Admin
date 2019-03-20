package com.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARD_CATEGORY")
public class CardCategory implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;

	@Column(name = "CATEGORY_NAME")
	private String CategoryName;
	
	@Column(name = "CATEGORY_TYPE")
	private String categoryType;

	@Column(name = "FILE_PATH")
	private String filePath;

	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="ADMIN_ID")
	private AdminProfile profile;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	private List<Cards> cards = new ArrayList<Cards>();

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime localDateTime) {
		this.createdDate = localDateTime;
	}

	public AdminProfile getProfile() {
		return profile;
	}

	public void setProfile(AdminProfile profile) {
		this.profile = profile;
	}

	public List<Cards> getCards() {
		return cards;
	}

	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "CardCategory [categoryId=" + categoryId + ", CategoryName=" + CategoryName + ", categoryType="
				+ categoryType + ", filePath=" + filePath + ", createdDate=" + createdDate + ", profile=" + profile
				+ ", cards=" + cards + "]";
	}


}
