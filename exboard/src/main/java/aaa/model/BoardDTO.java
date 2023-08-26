package aaa.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {
	String title,pname,upfile,pw,content;
	Date reg_date;
	int id, cnt,seq, lev, gid;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");

	public String getReg_dateStr() {
		return sdf.format(reg_date);
	}
	
	public String getContent() {
		return content.replaceAll("\n", "<br/>");
	}


	
	
}
