package com.app.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.dao.IAdminDao;
import com.app.model.AdminProfile;
import com.app.model.AdminRegister;
import com.app.model.CardCategory;
import com.app.model.MediaFiles;
import com.app.model.UserRegister;
import com.app.util.UploadFileResponse;

@Controller
public class AdminController {

	
	@Autowired
	private IAdminDao adminDao;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/users")
	public String getAllUsers(Model model) {
		
		
		List<UserRegister> userList = adminDao.getUserList();
		List<UserRegister> userLists = adminDao.getUserList(String.valueOf(new Date()));
		model.addAttribute("usernote", userLists);
		model.addAttribute("userList", userList);
		
		return "tables";
	}
	
	@RequestMapping("/dash")
	public String getDashboard(Model model) {
		
		return "index";
	}
	
	@RequestMapping("/login")
	public String getLogin(Model model) {
		
		return "login";
	}

	@RequestMapping("/card")
	public String saveCard(Model model) {
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String getRegister(Model model) {
		
		return "register";
	}
	
	@RequestMapping(value="/registerAdmin", method=RequestMethod.POST)
	public String registerAdmin(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("password") String password)
	{
		

		Serializable register=adminDao.saveAdmin(firstName,lastName,email,password) ;
		return "login";

		
	}
	
	
		@RequestMapping(value="/adminLogin", method=RequestMethod.POST)
		public String adminLogin(@RequestParam("email") String email,@RequestParam("password") String password, HttpServletRequest request)
		{
			List<AdminRegister> register=adminDao.adminLogin(email,password) ;
			
			if(register!=null) {
				
				if(register.get(0).getMailId().equals(email) &&register.get(0).getPassword().equals(password) && register.get(0).getIsActive()==true)
				{
					session = request.getSession();
					session.setAttribute("loggeduser", register);
					
					return "redirect:dash";
				}
				else {
					
					return "login";
				}
				
			}else{
				
				return "login";
			}
			
		}
		
		@RequestMapping(value="/logout", method=RequestMethod.POST)
		public String adminLogout( HttpServletRequest request)
		{
			session = request.getSession();
			session.removeAttribute("loggeduser");
			
			return "redirect:login";
			
		}
	
		@RequestMapping("/forgot")
		public String getForgot(Model model) {
			
			return "forgot-password";
		}
		
		@RequestMapping("/404")
		public String get404(Model model) {
			
			return "404";
		}
	
		@SuppressWarnings("unused")
		@RequestMapping("/delete")
		public String deleteUserById(@RequestParam("userId") Integer userId, Model map) {
			
			Integer useriD=adminDao.deleteUser(userId);
			
			map.addAttribute("msg", "user deleted successfully"+userId);
			
			return "redirect:users";
		
		}
		
		@RequestMapping("/getUsers")
		public String getNotification( Model map) {
			
			List<UserRegister> userList = adminDao.getUserList(String.valueOf(new Date()));
			map.addAttribute("usernote", userList);
		
		return "tables";
		
		}
		
		@RequestMapping("/getAllnotes")
		public String getAllNotification( Model map) {
			
			List<UserRegister> userList = adminDao.getUserAllList();
			System.out.println(userList);
			map.addAttribute("usernote", userList);
		
		return "tables";
		
		}
/*		@RequestMapping(value = "/saveCards",method = RequestMethod.POST)
		public String saveCards(@RequestParam("file") CommonsMultipartFile file , Model map) {
			
			System.out.println("------------------------------------");
			
	    	MediaFiles fileName = adminDao.storeFile(file);
	    	Object obj = new UploadFileResponse(fileName.getFilePath(),
						fileName.getFilePath(), file.getContentType(), file.getSize());
	    	
	    	map.addAttribute("msg", obj);
	        return "upload-gallery";
		}
	*/		
		@RequestMapping("/save")
		public String storeCards() {
			
			
	        return "upload-gallery";
		}
	
		   @SuppressWarnings("unused")
			@RequestMapping(value="/uploadCard", method=RequestMethod.POST)
		    public String uploadCards(@RequestParam(value="file", required=false) MultipartFile file,
		    		@RequestParam(value = "categoryId", required=false) Integer  categoryId,
		    		@RequestParam(value = "editable", required=false) Character  editable,
		    		@RequestParam(value = "cardText", required=false) String cardText,
		    		Model map) {
		     
		    	if(file == null) {
		    		map.addAttribute("msg", "'file' is empty or null please check");
					return "404";
					
				}
		    	else if(editable == null) {
		    		map.addAttribute("msg", "'editable' is empty or null please check");
					return "404";
					
				}else if(categoryId == null) {
					map.addAttribute("msg", "'categoryId' is empty or null please check");
					return "404";
					
				}else {
					
		    	CardCategory cardCategory = adminDao.storeCards(file,categoryId,cardText, editable);
		     
		        if (cardCategory != null) {
					Object obj = new UploadFileResponse(cardCategory.getCards().get(cardCategory.getCards().size()-1).getFilePath(),
							cardCategory.getCards().get(cardCategory.getCards().size()-1).getFilePath(), file.getContentType(), file.getSize());
					if (!file.isEmpty() || categoryId != null) {
						map.addAttribute("msg", "your File is uploaded successfully");

						return "404";
					} else {
						map.addAttribute("msg", "your File is not uploaded");

						return "404";
					} 
				}else {
					map.addAttribute("msg", "Category does not exist please add first");

					return "404";
				}
			  }
		    }
		    
		    @SuppressWarnings("unused")
			@RequestMapping(value="/addCategory" ,method = RequestMethod.POST)
		    public String uploadCategory(@RequestParam(value="file", required=false) MultipartFile file,
		    		@RequestParam(value="categoryName", required=false)String categoryName,
		    		@RequestParam(value="adminId", required=false)Integer adminId,
		    		@RequestParam(value = "categoryType", required=false) String  categoryType,
		    		Model map) {
		     
		    	if(file == null) {
		    		map.addAttribute("msg",  "'file' is empty or null please check");
					return "404";
				}
				else if(categoryName == null) {
					map.addAttribute("msg",  "'categoryName' is empty or null please check");
					return "404";
					
				}else if(categoryType == null) {
					map.addAttribute("msg",  "'categoryType' is empty or null please check");
					return "404";
					
				}else if(adminId == null) {
					map.addAttribute("msg",  "'adminId' is empty or null please check");
					return "404";
					
				}else {
					
		    	AdminProfile adminProfile = adminDao.storeCards(file, adminId,categoryName,categoryType);
		    	
		    	List<CardCategory> cardCategoryList = adminProfile.getCardCategories();
		     
		        if (adminProfile != null) {
		        	
		        	Object obj=new UploadFileResponse(cardCategoryList.get(cardCategoryList.size()-1).getFilePath(),
		        			cardCategoryList.get(cardCategoryList.size()-1).getFilePath(), file.getContentType(), file.getSize());
					
					if (!file.isEmpty() || adminId != null) {
						map.addAttribute("msg", "your File is uploaded successfully");

						return "404";

					} else {
						map.addAttribute("msg", "your File is not uploaded");

						return "404";
					} 
				}else {
					map.addAttribute("msg", "User does not exist please register first");
					return "404";
				}
			  }
		    }
}
