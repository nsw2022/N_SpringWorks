package aaa.controll;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import aaa.model.UploadData;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	String fileForm() {

		return "file/uploadForm";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	String fileReg(Model mm, @ModelAttribute("id") String id, @ModelAttribute("age") int age, MultipartFile ff1,
			MultipartFile ff2) {

		System.out.println("ff1" + ff1);
		System.out.println("ff2" + ff2);
		System.out.println("ff1 getOriginalFilename=> " + ff1.getOriginalFilename());
		System.out.println("ff1 getName=> " + ff1.getName());
		System.out.println("ff1 getContentType=> " + ff1.getContentType());
		System.out.println("ff1 getSize=> " + ff1.getSize());
		System.out.println("ff1 isEmpty=> " + ff1.isEmpty());

		mm.addAttribute("ff1", ff1.getOriginalFilename());
		mm.addAttribute("ff2", ff2.getOriginalFilename());

		return "file/uploadReg";
	}

	@RequestMapping(value = "upload2")
	String fileReg2(Model mm, MultipartHttpServletRequest mr) {
		MultipartFile ff1 = mr.getFile("ff1");
		MultipartFile ff2 = mr.getFile("ff2");

		System.out.println("ff1" + ff1);
		System.out.println("ff2" + ff2);
		System.out.println("ff1 getOriginalFilename=> " + ff1.getOriginalFilename());
		System.out.println("ff1 getName=> " + ff1.getName());
		System.out.println("ff1 getContentType=> " + ff1.getContentType());
		System.out.println("ff1 getSize=> " + ff1.getSize());
		System.out.println("ff1 isEmpty=> " + ff1.isEmpty());

		mm.addAttribute("id", mr.getParameter("id"));
		mm.addAttribute("age", mr.getParameter("age"));
		mm.addAttribute("ff1", ff1.getOriginalFilename());

		return "file/uploadReg";
	}

	@RequestMapping(value = "upload3")
	String fileReg3(UploadData ud,Model mm) {

		System.out.println("up" + ud);
		/*
		 * System.out.println("ud getOriginalFilename=> "+ud.getFf1().
		 * getOriginalFilename());
		 * System.out.println("ud getName=> "+ud.getFf1().getName());
		 * System.out.println("ud getContentType=> "+ud.getFf1().getContentType());
		 * System.out.println("ud getSize=> "+ud.getFf1().getSize());
		 * System.out.println("ud isEmpty=> "+ud.getFf1().isEmpty());
		 */
		System.out.println("ud getOriginalFilename=> " + ud.getFf2().getOriginalFilename());
		System.out.println("ud getName=> " + ud.getFf2().getName());
		System.out.println("ud getContentType=> " + ud.getFf2().getContentType());
		System.out.println("ud getSize=> " + ud.getFf2().getSize());
		System.out.println("ud isEmpty=> " + ud.getFf2().isEmpty());

		fileSave(ud.getFf1());
		fileSave2(ud.getFf2());
		mm.addAttribute("notImgFile","이미지 파일이 아닙니다.");
		return "file/uploadReg3";
	}

	void fileSave(MultipartFile mf) {
		// String path = "E:\\NSW\\SpringWorks\\stsMvcProj\\src\\main\\webapp\\up";
		String path = "E:\\BackEnd_hakwon\\gitSpring\\stsMvcProj\\src\\main\\webapp\\up";

		File ff = new File(path + "\\" + mf.getOriginalFilename());

		try {
			FileOutputStream fos = new FileOutputStream(ff);

			fos.write(mf.getBytes());

			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void fileSave2(MultipartFile mf) {

		// 저장 경로 설정
		// String path = "E:\\NSW\\SpringWorks\\stsMvcProj\\src\\main\\webapp\\up";
		String path = "E:\\BackEnd_hakwon\\gitSpring\\stsMvcProj\\src\\main\\webapp\\up";
		// 업로드된 파일의 원래 파일 이름 획득
		String originalFileName = mf.getOriginalFilename();
		// 새파일 이름 생성
		String newFileName = originalFileName;
		System.out.println(originalFileName);
		File ff = new File(path + "\\" + newFileName);

		// 중복 파일 처리를 위한 숫자 카운트 초기화
		int count = 1;
		// 중복된 파일이 이미 존재하는지 확인하고 처리
		while (ff.exists()) { // 해당경로에 실제 있는지 검사
			// 파일 확장자 추출 할 변수
			String extension = "";
			int dotIndex = originalFileName.lastIndexOf("."); // 못찾으면 -1 리턴함

			// input accept="image/* 속성은 오답이겠죠..
			if (dotIndex != -1) {// 확장자있으면 걸림
				extension = originalFileName.substring(dotIndex);// 확장자 추출
				System.out.println("이미 있는 파일의 확장자여 " + extension);

			}
			// 근데 이방식으로하면 파일 엄청~ 많으면 작업이 길어질꺼같아서
			// 파일을 얻어올때 작업해야하나 고민되네요.. 현업에서는 어떻게 할지 궁금하네요
			// 그날의 날짜별로 폴더생성 해서 저장하는게 관리할때 편할꺼같기도하고..

			// 새 파일 이름을 생성하여 중복을 피함
			newFileName = originalFileName.substring(0, dotIndex) + "_" + count + extension;
			ff = new File(path + "\\" + newFileName);
			count++;
		}//중복 검수 종료

		boolean isImg = Pattern.matches(".*[.](jpg||bmp||png||gif)", originalFileName);

		if (isImg) {
			try {
				FileOutputStream fos = new FileOutputStream(ff);

				fos.write(mf.getBytes());

				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else {
			System.out.println("이미지 파일이 아닙니다.");
		}

	}

}
