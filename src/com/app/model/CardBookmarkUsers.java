package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARD_BOOKMARK_USERS")
public class CardBookmarkUsers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKMARK_ID")
	private Integer bookmarkId;
	
	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "CARD_TYPE")
	private String cardType;

	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "CREATE_DATE")
	private String createDate;

	public Integer getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(Integer bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "CardBookmarkUsers [bookmarkId=" + bookmarkId + ", userName=" + userName + ", cardType=" + cardType
				+ ", userId=" + userId + ", createDate=" + createDate + "]";
	}


}
