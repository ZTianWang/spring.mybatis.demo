package com.gwang.spring.mybatis.demo.test.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController {

	@RequestMapping("/upload")
	public String uploadView() {
		return "upload";
	}
	
	@RequestMapping("/uploadProcessing")
	/*必须加@RequestParam*/
	public String uploadProcrssing(@RequestParam("file")CommonsMultipartFile file) {
		System.out.println(file.getOriginalFilename());
		try {
			file.transferTo(new File("/Users/apple/Desktop/file test.txt"));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		return "uploadOK";
	}
}
