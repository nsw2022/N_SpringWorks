package aaa.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class BoardFile {
	
	String id, ffName, msg;
	MultipartFile ff;

	public String getFfName() {
		return ff.getOriginalFilename();
	}


	

}
