package aaa.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadData {
	
	String id, ff1Name, ff2Name;
	int age;
	MultipartFile ff1, ff2;

	public String getFf1Name() {
		return ff1.getOriginalFilename();
	}
	
	public String getFf2Name() {
		
		return ff2.getOriginalFilename();
	}
	
}
