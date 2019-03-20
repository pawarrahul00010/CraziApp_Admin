package com.app.model;

import java.util.Date;

public class GetImage {


private String user;
private Integer fileId;
private Date createDate;
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public Integer getFileId() {
	return fileId;
}
public void setFileId(Integer fileId) {
	this.fileId = fileId;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
@Override
public String toString() {
	return "GetImage [user=" + user + ", fileId=" + fileId + ", createDate=" + createDate + "]";
}


}
