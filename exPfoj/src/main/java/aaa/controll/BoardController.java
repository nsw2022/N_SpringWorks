package aaa.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Pattern;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import aaa.model.BoardDTO;

import aaa.model.PageData;
import aaa.service.BoardMapper;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource
	BoardMapper mapper;
	
	@Resource
	PageData pageData;
	
	static String path = "E:\\BackEnd_hakwon\\N_SpringWorks\\exPfoj\\src\\main\\webapp\\bup";
	
	@RequestMapping("list")
	String list(Model mm,PageData pd,HttpServletRequest request) {
		pageData.testPage(request);
		
		//System.out.println(mapper.totalCnt() + "토탈 카운트 확인");
		//System.out.println(pageData.getStart()+", "+pageData.getLimit() + "페이지 확인");
		List<BoardDTO> data = mapper.list2(pageData.getStart(),pageData.getLimit());
		//System.out.println( mapper.totalCnt() );
	
		
		//System.out.println(pageData.getPageStart() + ", " + pageData.getPageEnd());
		//pd.testPage(request);
		
		//System.out.println(data);
		mm.addAttribute("mainData",data);
		mm.addAttribute("pageData",pageData);
		return "board/list";
	}

	@RequestMapping("detail/{id}")
	String list(Model mm, @PathVariable int id,PageData pd) {
		mapper.addCount(id);
		mm.addAttribute("dto",mapper.detail(id));
		mm.addAttribute("pageData",pageData);
		return "board/detail";
	}
	
	@GetMapping("insert")
	String insert(BoardDTO dto,Model mm) {
		mm.addAttribute("pageData",pageData);
		return "board/insertForm";
	}
	
	@PostMapping("insert")
	String insertReg(BoardDTO dto, PageData pd, Model mm) {
		
		dto.setGid(mapper.maxI(dto)+1);
		fileSave(dto);// 파일 저장 먼저
		mapper.insseerr(dto); // 그후 데이터 저장
		System.out.println(dto);
		
		pd.setMsg("작성되었습니다");
		pd.setGoUrl("list");
		//System.out.println(dto);
		
		return "board/alert";
	}
		
	void fileSave(BoardDTO dto) {
		
		//System.out.println(dto.getMmff() + "이게왔다구?");
		if (dto.getMmff() != null) {

			MultipartFile uploadedFile = dto.getMmff(); // 업로드된 파일 데이터 가져오기

			// 확장자가 없으면 반응할 int 변수
			int dot = uploadedFile.getOriginalFilename().lastIndexOf(".");// 찾으면 -1
			// substring(beginIndex): 지정한 인덱스부터 문자열 끝까지를 추출
			// substring(beginIndex, endIndex): 시작 인덱스부터 종료 인덱스 바로 전까지의 문자열을 추출
			if (dot != -1) {
				String fDomain = uploadedFile.getOriginalFilename().substring(0, dot);
				String ext = uploadedFile.getOriginalFilename().substring(dot);
				// 고로 fDomain는 .앞까지 ext뒤에다 가져옴

				// 이미지인지 확인
				/*
				if (!Pattern.matches("[.](bmp|jpg|gif|png|jpeg)", ext.toLowerCase())) {

					return;
				}
				*/
				String ffName = fDomain + ext;
				File ff = new File(path + "\\" + ffName);
				int cnt = 1;
				while (ff.exists()) {
					ffName = fDomain + "_" + cnt + ext;
					ff = new File(path + "\\" + ffName);
					cnt++;
				}

				try {
					FileOutputStream fos = new FileOutputStream(ff);
					fos.write(uploadedFile.getBytes());
					dto.setMmff(uploadedFile);
					fos.close();
					dto.setUpfile(ffName); // 파일명을 dto의 upfile 필드에 설정
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	@RequestMapping("/bup/download/{filename}")
	void download(@PathVariable String filename,
				   HttpServletRequest request,
				   HttpServletResponse response) {
		System.out.println("이벤트체크=> 파일 다운로드");
		try {
			System.out.println(filename+", "+"파일님 오셧나요");
			FileInputStream fis = new FileInputStream(path + "\\"+filename);
			// 인코딩 설정
			String encFName = URLEncoder.encode(filename,"utf-8");
		
			response.setHeader("Content-Disposition", "attachment; filename=" + encFName);

			
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buf = new byte[1024];
			while (fis.available()>0) {
				int len = fis.read(buf); // 읽은후 buf에 저장
				// len = 넣은 길이
				sos.write(buf,0,len);// buf 0부터 len 만큼 
				
			}
			
			sos.close();
			fis.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	@RequestMapping("delete/{id}")
	String delete(BoardDTO dto,@PathVariable int id) {
		dto.setId(id);
		return "board/deleteForm";
	}
	
	@PostMapping("delete/{id}")
	String deleteReg(BoardDTO dto,PageData pd,@PathVariable int id) {
		pd.setMsg("삭제실패");
		pd.setGoUrl("/board/delete/"+id);
		BoardDTO ndto = mapper.detail(id);
		int cnt = mapper.delettt(dto);
		System.out.println("deleteReg:"+cnt);
		// 아이디 비번 확인후 파일 지우고 내용 지우고~~
		
		if (cnt > 0) {
			System.out.println(ndto);
			if (ndto.getUpfile() != null) {
				System.out.println("삭제 오긴함?");
				
				new File(path+"\\"+ndto.getUpfile()).delete();
			}
			pd.setMsg("삭제되었습니다.");
			pd.setGoUrl("/board/list");
		}
		
		return "board/alert";
	}
	
	@GetMapping("modify/{id}")
	String modify(@PathVariable int id,Model mm) {
		mm.addAttribute("dto",mapper.detail(id));
		return "board/modifyForm";
	}
	
	@PostMapping("modify/{id}")
	String modifyReg(BoardDTO dto,PageData pd,@PathVariable int id, HttpServletRequest request) {
		System.out.println("이벤트 체크 modifyReg");
		pd.setMsg("수정실패");
		pd.setGoUrl("/board/modify/"+id);
		System.out.println(dto);
		//어차피받아오는거라 비번가져오는게같냐이런건 의미 X
		//String pw = request.getParameter("pw");
		//System.out.println(pw+" <=원하는 거"+dto.getPw().equals(null));
		//BoardDTO ndto = mapper.detail(id); detail id를 가져와도 되지만 굳이 할필요없음
		//System.out.println(mapper.idCheck(dto)+", 보고싶다 너란녀석");
		
		if (mapper.idCheck(dto)>0) {
			
			new File(path+"\\"+dto.getUpfile()).delete();
			System.out.println(dto.getUpfile()+"가져온 이미지 이름");
			dto.setUpfile(dto.getMmff().getOriginalFilename());
			System.out.println(dto.getUpfile()+" 이름가온나 ");
			fileSave(dto);
			System.out.println();
			System.out.println("dto 되긴함?" + dto);
			
		}
		int cnt = mapper.modifffy(dto);
		System.out.println("modifyReg:"+cnt);
		
		if (cnt > 0) {
			System.out.println(dto+"dto 수정있다! 찾아라!!!!");
	
			pd.setMsg("수정되었습니다.");
			pd.setGoUrl("/board/detail/"+dto.getId());
			//System.out.println( dto.getMmff().toString()+"d이미지 오긴함?" );
			
		}
		
		return "board/alert";
	}
	
	
	

	
	@GetMapping("reply/{id}")
	String reply(BoardDTO dto,@PathVariable int id,Model mm) {
		mm.addAttribute("dto",mapper.reply(dto));
		
		return "board/replyForm";
	}
	
}
