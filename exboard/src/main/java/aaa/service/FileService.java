package aaa.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	
	  public String fileSave(MultipartFile mf) {
	        String resultMessage = "";
	        System.out.println("이벤트체크 파일 세이브");
	        // 저장 경로 설정
	        String path = "E:\\BackEnd_hakwon\\N_SpringWorks\\exboard\\src\\main\\webapp\\up";

	        // 업로드된 파일의 원래 파일 이름 획득
	        String originalFileName = mf.getOriginalFilename();
	        // 새파일 이름 생성
	        String newFileName = originalFileName;
	        File ff = new File(path + File.separator + newFileName);

	        // 중복 파일 처리를 위한 숫자 카운트 초기화
	        int count = 1;
	        // 중복된 파일이 이미 존재하는지 확인하고 처리
	        while (ff.exists()) {
	            // 파일 확장자 추출 할 변수
	            String extension = "";
	            int dotIndex = originalFileName.lastIndexOf(".");
	            
	            if (dotIndex != -1) {
	                extension = originalFileName.substring(dotIndex);
	            }
	            
	            // 새 파일 이름을 생성하여 중복을 피함
	            newFileName = originalFileName.substring(0, dotIndex) + "_" + count + extension;
	            ff = new File(path + File.separator + newFileName);
	            count++;
	        }

	        boolean isImg = Pattern.matches(".*[.](jpg||bmp||png||gif)", originalFileName);

	        if (isImg) {
	            try {
	                FileOutputStream fos = new FileOutputStream(ff);
	                fos.write(mf.getBytes());
	                fos.close();
	                resultMessage = mf.getOriginalFilename();
	            } catch (Exception e) {
	                e.printStackTrace();
	                resultMessage = "파일 저장 중 오류가 발생했습니다.";
	            }
	        } else {
	            resultMessage = "이미지 파일이 아닙니다.";
	        }

	        return resultMessage;
	    }
	

}
