package net.kzn.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH="D:\\Projects\\Spring\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH="";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest requesst, MultipartFile file, String code) {
		
		//get the real path
		REAL_PATH = requesst.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		//to make sure all the directory exist
		//please create the directory
		
		if(!new File(ABS_PATH).exists()) {
			//create the directory
			
			new File(ABS_PATH).mkdir();
		}
		
		if(!new File(REAL_PATH).exists()) {
			//create the directory
			
			new File(REAL_PATH).mkdir();
		}
		
		try {
			//server Upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//project directory upload
			file.transferTo(new File(ABS_PATH+code+".jpg"));
		} 
		catch (IOException ex) {
			
		}
		
	}
}
