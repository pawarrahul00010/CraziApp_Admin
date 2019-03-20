package com.app.dao.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.dao.IAdminDao;
import com.app.exception.FileStorageException;
import com.app.model.AdminProfile;
import com.app.model.AdminRegister;
import com.app.model.CardCategory;
import com.app.model.Cards;
import com.app.model.UserRegister;
import com.app.util.DateUtil;
@Transactional
@Repository
public class AdminProfileDaoImpl implements IAdminDao {
	private static final String UPLOAD_DIRECTORY = "upload";
	Date currentDate = GregorianCalendar.getInstance().getTime();
	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String sDate = formatter.format(currentDate);
	
	@Autowired
	private HibernateTemplate ht;
	@Autowired
	private DateUtil dateUtil;
	
	
	org.hibernate.Transaction tx=null;
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRegister> getUserList() {
		/*
		 * Session session= HibernateUtil.getSessionFactory().openSession(); try {
		 * 
		 * tx=session.beginTransaction(); List<UserRegister> userRegisters=
		 * session.createQuery("from UserRegister").list(); tx.commit();
		 * session.close(); return userRegisters; } catch (HibernateException e) {
		 * if(tx!=null) { tx.rollback(); }
		 * 
		 * e.printStackTrace(); } return null;
		 */
		
		return ht.getSessionFactory().getCurrentSession().createQuery("from UserRegister").list();
	}

	@Transactional
	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		UserRegister user = new UserRegister();
		user.setUserId(userId);
		ht.getSessionFactory().getCurrentSession().createQuery("delete from UserRegister where userId=:userId")
		.setParameter("userId", userId).executeUpdate();
		
		 return userId;
	}

	@Override
	public List<UserRegister> getUserList(String date) {
		// 

		@SuppressWarnings("unchecked")
		List<UserRegister> userList=
		 (List<UserRegister>)
				ht.getSessionFactory().getCurrentSession()
				.createSQLQuery("SELECT * FROM user_register ORDER BY userid DESC LIMIT 10").addEntity(UserRegister.class)
				.list();
		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRegister> getUserAllList() {
		// TODO Auto-generated method stub
		return (List<UserRegister>)
				ht.getSessionFactory().getCurrentSession()
				.createSQLQuery("SELECT * FROM user_register ORDER BY userid DESC LIMIT 50").addEntity(UserRegister.class)
				.list();
	}
	Date date = Calendar.getInstance().getTime();
	@Override
	public Serializable saveAdmin(String firstName, String lastName, String email, String password) {
		AdminRegister adminRegister =new AdminRegister();
		adminRegister.setFirstName(firstName);
		adminRegister.setLastName(lastName);
		adminRegister.setMailId(email);
		adminRegister.setPassword(password);
		adminRegister.setIsActive(true);
		adminRegister.setCreateDate(date);
		
		adminRegister.setLastModifiedDate(date);
		adminRegister.setSourceFrom("Laptop");
		return ht.save(adminRegister);
	}

	@Override
	public List<AdminRegister> adminLogin(String email, String password) {
		List<AdminRegister> adminRegister=null;
		try {
		List<AdminRegister> reg=	  ht.getSessionFactory().getCurrentSession().createQuery("SELECT a FROM AdminRegister a WHERE a.mailId=:email").setParameter("email", email).list();
	
		if(!reg.isEmpty()) {
		return reg;
	}
	else {
		return adminRegister;
	}

	}catch (Exception e) {
		return adminRegister;
	}
		}
	
	
	/*
	 * @Transactional
	 * 
	 * @Override public CardCategory storeFile(CommonsMultipartFile file) {
	 * 
	 * String fileName = StringUtils .cleanPath( + System.currentTimeMillis() +
	 * getFileExtension(file));
	 * 
	 * String fileDownloadUri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
	 * .path(String.valueOf(fileName)).build().toUri().toString(); try { if
	 * (fileName.contains("..")) { }
	 * 
	 * MediaFiles mediaFile = new MediaFiles();
	 * 
	 * mediaFile.setFilePath(fileDownloadUri); mediaFile.setCreateDate(sDate);
	 * mediaFile.setLastModifiedDate(sDate);
	 * 
	 * long length = file.getSize();
	 * 
	 * 
	 * String uploadPath = "C:"+ File.separator + UPLOAD_DIRECTORY;
	 * 
	 * // creates the directory if it does not exist File uploadDir = new
	 * File(uploadPath); if (!uploadDir.exists()) { uploadDir.mkdir(); }
	 * 
	 * String filePath = uploadPath + File.separator + fileName; File storeFile =
	 * new File(filePath);
	 * 
	 * Files.copy(file.getInputStream(), storeFile.toPath(),
	 * StandardCopyOption.REPLACE_EXISTING);
	 * 
	 * 
	 * 
	 * 
	 * ht.getSessionFactory().getCurrentSession().save(mediaFile); return mediaFile;
	 * 
	 * } catch (Exception ex) {
	 * 
	 * ex.printStackTrace(); } return null; }
	 */
		private String getFileExtension(MultipartFile file) {
			String name = file.getOriginalFilename();
			int lastIndexOf = name.lastIndexOf(".");
			if (lastIndexOf == -1) {
				return ""; // empty extension
			}
			return name.substring(lastIndexOf);

	}

				@Override
				public CardCategory storeCards(MultipartFile file, Integer categoryId, String cardText, Character editable) {
					// TODO Auto-generated method stub
					
					CardCategory cardCategoryList = (CardCategory) ht.getSessionFactory().getCurrentSession().get(CardCategory.class, categoryId);
					
					Cards cards = new Cards();
					
					String fileName = StringUtils
							.cleanPath( + System.currentTimeMillis() + getFileExtension(file));
		
							String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
							.path(String.valueOf(fileName)).build().toUri().toString();
							try {
							if (fileName.contains("..")) {
							}
		
							
								
								cards.setFilePath(fileDownloadUri);
								cards.setCreateDate(dateUtil.getDate());
								cards.setEditable(editable);
								cards.setCardCategory(cardCategoryList);
								cards.setCardText(cardText);
								
								cardCategoryList.getCards().add(cards);
		
							long length = file.getSize();
		
		
							String uploadPath = "C:"+ File.separator + UPLOAD_DIRECTORY;
		
							// creates the directory if it does not exist
							File uploadDir = new File(uploadPath);
							if (!uploadDir.exists()) {
							uploadDir.mkdir();
							}
							
							String filePath = uploadPath + File.separator + fileName;
							File storeFile = new File(filePath);
		
							Files.copy(file.getInputStream(), storeFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
							ht.getSessionFactory().getCurrentSession().save(cardCategoryList);
							return cardCategoryList;
		
							}catch(Exception ex){
								ex.printStackTrace();
								System.out.println(ex.getMessage());
								return null;
				}
			}
		
					
	/*
	 * public CardCategory storeCards(MultipartFile file, Integer categoryId,String
	 * cardText, Character editable) {
	 * 
	 * List<CardCategory> cardCategoryList =
	 * cardCategoryRepository.getById(categoryId);
	 * 
	 * Cards cards = new Cards(); String fileName = StringUtils
	 * .cleanPath(String.valueOf(categoryId) + System.currentTimeMillis() +
	 * getFileExtension(file)); String fileDownloadUri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath() .path("/downloadFile/")
	 * .path(String.valueOf(fileName)) .toUriString();
	 * 
	 * try { if (fileName.contains("..")) { throw new
	 * FileStorageException("Sorry! Filename contains invalid path sequence " +
	 * file); }
	 * 
	 * 
	 * if (!cardCategoryList.isEmpty()) {
	 * 
	 * cards.setFilePath(fileDownloadUri); cards.setCreateDate(dateUtil.getDate());
	 * cards.setEditable(editable); cards.setCardCategory(cardCategoryList.get(0));
	 * cards.setCardText(cardText);
	 * 
	 * cardCategoryList.get(0).getCards().add(cards);
	 * 
	 * Path targetLocation = this.fileStorageLocation.resolve(fileName);
	 * Files.copy(file.getInputStream(), targetLocation,
	 * StandardCopyOption.REPLACE_EXISTING); return
	 * ht.getSessionFactory().getCurrentSession().save(cardCategoryList.get(0));
	 * 
	 * }else {
	 * 
	 * return null; }
	 * 
	 * } catch (IOException ex) {
	 * 
	 * throw new FileStorageException("Could not store file " + fileName +
	 * ". Please try again!", ex);
	 * 
	 * } }
	 */
		
			@SuppressWarnings("unchecked")
			public AdminProfile storeCards(MultipartFile file, Integer adminId, String categoryName, String categoryType) {
			
			List<AdminProfile> userprofile = null;
			int adminid =adminId;
			
			userprofile = (List<AdminProfile>) ht.getSessionFactory().getCurrentSession().get(AdminProfile.class, adminId);
			
			
			CardCategory cardCategory= new CardCategory();
			String fileName = StringUtils
					.cleanPath(String.valueOf(adminId) + System.currentTimeMillis() + getFileExtension(file));
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/downloadFile/")
					.path(String.valueOf(fileName))
					.toString();
			
			try {
				if (fileName.contains("..")) {
					throw new FileStorageException("Sorry! Filename contains invalid path sequence " + file);
				}
				
				
						if (!userprofile.isEmpty()) {
							
							if (!userprofile.isEmpty()) {
								cardCategory.setCategoryName(categoryName);
								cardCategory.setCreatedDate(dateUtil.getDate());
								cardCategory.setCategoryType(categoryType);			
								cardCategory.setFilePath(fileDownloadUri);
								cardCategory.setProfile(userprofile.get(0));
								userprofile.get(0).getCardCategories().add(cardCategory);
								

								String uploadPath = "C:"+ File.separator + UPLOAD_DIRECTORY;
			
								// creates the directory if it does not exist
								File uploadDir = new File(uploadPath);
								if (!uploadDir.exists()) {
								uploadDir.mkdir();
								}
								
								String filePath = uploadPath + File.separator + fileName;
								File storeFile = new File(filePath);
			
								Files.copy(file.getInputStream(), storeFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
								 ht.getSessionFactory().getCurrentSession().save(userprofile.get(0));
								return userprofile.get(0);
							}else {
								
								return null;
							}
							
						}else {
						
						return null;
						
						}
					} catch (IOException ex) {
					
						throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
				
					}
			}
			
			@SuppressWarnings("unchecked")
			public List<CardCategory> getAllGreetinsByCategoryId(Integer categoryId) {
			return ht.getSessionFactory().getCurrentSession().createQuery("from CardCategory where categoryId=:categoryId")
					.setParameter("categoryId", categoryId).setEntity("CardCategory", CardCategory.class).list();
			
			}
}