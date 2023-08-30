package aaa.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;

@Alias("bDTO")
@Data
public class BoardDTO {
	
	MultipartFile mmff;
	
	int id, cnt, lev, gid, seq;
	String title, pname, pw, upfile, content;
	Date regDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	
	public String getRegDate() {
		return sdf.format(regDate);
	}
	
	
	
}
