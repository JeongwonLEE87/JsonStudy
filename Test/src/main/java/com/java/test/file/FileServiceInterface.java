package com.java.test.file;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceInterface {
	
	public HashMap<String, Object> fileUpload(MultipartFile[] files, String menu);

}
