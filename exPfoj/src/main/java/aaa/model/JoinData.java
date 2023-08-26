package aaa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinData {
	
	ArrayList<String> neverID = new ArrayList<>(Arrays.asList("aaa","bbb","ccc","ddd"))  ;
	
	@NotEmpty(message = "아이디가 없쪙")
	@Size(min = 3, max = 10) // message 안적으면 내장 메세지 출력!
	String pid;
	
	@Pattern( regexp = "[가-힣]{2,5}",message = "한글 2-5")
	@Size(min = 2, max = 5)
	String pname;
	
	@NotEmpty(message = "비밀번호가 없쪙")
	String pw1, pw2;

	@Email(message = "이메일 형식")
	String email;
	
	//@Past(message = "오늘 이전만 입력")
	
	
	String birth;

	@Positive(message = "양수만 가능")
	int ban;
	
	@Positive(message = "양수만 가능")
	@Min(value = 0)
	@Max(value = 100)
	int kor, eng, math;
	
	
}
