package com.app.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.AdminProfile;
import com.app.model.AdminRegister;
import com.app.model.CardCategory;
import com.app.model.MediaFiles;
import com.app.model.UserRegister;

public interface IAdminDao {

	//public List<UserRegister> getUserList(Date date);
	public List<UserRegister> getUserList();
	
	public int deleteUser(int userId);
	public List<UserRegister> getUserList(String valueOf);

	public List<UserRegister> getUserAllList();

	public Serializable saveAdmin(String firstName, String lastName, String email, String password);

	public List<AdminRegister> adminLogin(String email, String password);

	//public MediaFiles storeFile(CommonsMultipartFile file);

	public CardCategory storeCards(MultipartFile file, Integer categoryId, String cardText, Character editable);

	public AdminProfile storeCards(MultipartFile file, Integer adminId, String categoryName, String categoryType);
	
	
}
