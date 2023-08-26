package aaa.controll;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import aaa.model.BoardDAO;
import aaa.model.BoardDTO;
import aaa.service.BoardService;
import aaa.service.FileService;

/* 

localhost/board/notice/list/1
localhost/board/fnq/list/3
localhost/board/qna/list/2

cate랑 pno만 바꿔서 게시판별 다르게 반응하는걸 Controller하나로도 가능할꺼같다는 생각(이게더별로일려나)

/아무단어/{cate}/list/{pNo}
{notice}/list/1
{communtiy}/list/1

-------일단 테스트---------
/board/list/

/board/detail/{name}

*/

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// Autowired 
	// 1. 멤버변수에 쓰기(자주씀) 
	// 2. 생성자에 땡길거 파라미터에 받고쓰기 
	// 3. set할때에 쓰기
	
	BoardService boardService;
	FileService fileService;
	
    @Autowired
    public BoardController(BoardService boardService, FileService fileService) {
    	System.out.println("보드서비스 커밍");
        this.boardService = boardService;
        this.fileService = fileService;
    }
	
    @RequestMapping("/list")
    public String showBoardList(Model model) {
        List<BoardDTO> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }
    
    @RequestMapping("/detail/{id}")
    public String showBoardDetail(@PathVariable int id, Model model) {
    	
    	boardService.addCount(id);
    	System.out.println(id+", "+"detail 테스트"+boardService);
    	
        BoardDTO boardDetail = boardService.getBoardDetail(id);
        model.addAttribute("boardDetail", boardDetail);
        return "board/detail";
    }
    
    @RequestMapping("/BWrite")
    public String writeBoardForm() {
        
        return "board/BWriteForm";
    }

    @RequestMapping(value = "/BWriteReg", method = RequestMethod.POST)
    public String writeBoard(@RequestParam("upfile") MultipartFile upfile,
                             @RequestParam("title") String title,
                             @RequestParam("pname") String pname,
                             @RequestParam("pw") String pw,
                             @RequestParam("content") String content) {
        BoardDTO boardDTO = new BoardDTO();
        if (!upfile.isEmpty()) {
            String savedFileName = fileService.fileSave(upfile);
            
            boardDTO.setUpfile(savedFileName);
        }

        // 나머지 필드들 설정
        boardDTO.setTitle(title);
        boardDTO.setPname(pname);
        boardDTO.setPw(pw);
        boardDTO.setContent(content);

        boardService.write(boardDTO); // write 메서드를 호출하여 게시글 작성 처리

        return "redirect:/board/list";
    }
    
    @RequestMapping("/BDeleteForm")
    public String deleteForm() {
    	return "board/BDeleteForm";
    }
  
    @RequestMapping(value = "/BDeleteReg", method = RequestMethod.POST)
    public String deleteBoard(@ModelAttribute BoardDTO boardDTO) {
        System.out.println("오긴하나요 그대");
        BoardDAO boardDAO = new BoardDAO();
        BoardDTO deletedBoard = boardDAO.idPwCheck(boardDTO); // idPwCheck 결과를 받아옴
        System.out.println(boardDTO.getId()+", "+boardDTO.getPw());
        System.out.println(deletedBoard);
        if (deletedBoard != null) {
            // 비밀번호 일치하는 경우 삭제 로직 수행
            // 파일 삭제 수행할 계획.. 아무리봐도 같은데 null로 오네요..
            boardDAO.delete(boardDTO); 
            return "redirect:/board/list"; 
        } else {
            // 비밀번호 불일치 시 처리
            // 메시지를 설정하여 화면에 띄울 수 있음
            return "board/BDeleteForm"; // 삭제 폼으로 다시 이동
        }
    }
    @RequestMapping("/BModifyForm")
    public String modifyBoardForm(@RequestParam("id") int id, Model model) {
        BoardDTO boardDetail = boardService.getBoardDetail(id);
        model.addAttribute("boardDetail", boardDetail);
        return "board/BModifyForm";
    }
    
    /*
    <a th:href="@{/board/BModifyForm(id=${boardDetail.id})}">수정</a>
    @RequestMapping("/BModifyForm/{id}")
    public String modifyBoardForm(@PathVariable int id, Model model) {
        BoardDTO boardDetail = boardService.getBoardDetail(id);
        model.addAttribute("boardDetail", boardDetail);
        return "board/BModifyForm";
    }
    */
    
	
}
