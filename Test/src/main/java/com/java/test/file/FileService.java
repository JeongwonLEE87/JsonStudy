package com.java.test.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService implements FileServiceInterface {

	@Override
	public HashMap<String, Object> fileUpload(MultipartFile[] files, String menu) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		for(int i = 0; i < files.length; i++) {
			HashMap<String, Object> fileMap = new HashMap<String, Object>();
			String fileNm = files[i].getOriginalFilename();
			
			try {
				byte[] bytes = files[i].getBytes();
				String path = "C:/Users/goodee/git/JsonStudy/Test/src/main/webapp/resources/upload/" + menu + "/";
				
				File dir = new File(path);
				
				if(!dir.exists()) {
					dir.mkdirs();
				}
				
				File f = new File(path + fileNm);
				OutputStream out = new FileOutputStream(f);
				out.write(bytes);
				out.close();
				
				fileMap.put("fileName", fileNm);
				fileMap.put("filePath", path);
				fileMap.put("fileUrl", "/test/resources/upload/" + menu + "/" + fileNm);
				list.add(fileMap);				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		map.put("upload", list);
		
		return map;
	}

}
