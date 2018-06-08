package com.java.test.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.test.util.HttpUtil;

@Controller
public class FileController {
	
	@Autowired
	FileServiceInterface fsi;
	
	@RequestMapping("/file/{menu}")
	public void file(@RequestParam("file") MultipartFile[] files, 
			                  @PathVariable("menu") String menu, HttpServletResponse res) {
		HashMap<String, Object> resultMap =  fsi.fileUpload(files, menu);
		HttpUtil.makeJsonWriter(res, resultMap);
	}
	
}
