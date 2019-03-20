package com.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Media_Files")
public class MediaFiles implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_Id")
	private Integer fileId;
	
	@Column(name = "File_Path")
	private String filePath;
	
	
	
	@Column(name = "File_Create_Date")
	private String createDate;
	
	@Column(name = "File_Last_Modified_Date")
	private String lastModifiedDate;
	
	@Column(name = "Total_Likes")
	private Long likes;
	
	@Column(name = "Total_viewer")
	private Long viewer;
	
	@Column(name = "Total_Rating")
	private Float rating;
	
	@Column(name = "File_Type")
	private String fileType;
	
	@Column(name = "Text")
	private String Text;
	
	@Column(name = "Bookmarked_Status")
	private Boolean isBookMarked;
	
	@Column(name = "Shared_Status")
	private Boolean isShared;
	
	
	@Column(name = "is_Liked")
	private Boolean isLiked;

	@Column(name = "theam_name")
	private String theamName;
	
	@Column(name = "is_Rated")
	private Boolean isRated;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="USR_DET_ID")
	private UserProfile profile;


	public Integer getFileId() {
		return fileId;
	}


	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public Long getLikes() {
		return likes;
	}


	public void setLikes(Long likes) {
		this.likes = likes;
	}


	public Long getViewer() {
		return viewer;
	}


	public void setViewer(Long viewer) {
		this.viewer = viewer;
	}


	public Float getRating() {
		return rating;
	}


	public void setRating(Float rating) {
		this.rating = rating;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getText() {
		return Text;
	}


	public void setText(String text) {
		Text = text;
	}


	public Boolean getIsBookMarked() {
		return isBookMarked;
	}


	public void setIsBookMarked(Boolean isBookMarked) {
		this.isBookMarked = isBookMarked;
	}


	public Boolean getIsShared() {
		return isShared;
	}


	public void setIsShared(Boolean isShared) {
		this.isShared = isShared;
	}


	public Boolean getIsLiked() {
		return isLiked;
	}


	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}


	public String getTheamName() {
		return theamName;
	}


	public void setTheamName(String theamName) {
		this.theamName = theamName;
	}


	public Boolean getIsRated() {
		return isRated;
	}


	public void setIsRated(Boolean isRated) {
		this.isRated = isRated;
	}


	public UserProfile getProfile() {
		return profile;
	}


	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	
	
}
