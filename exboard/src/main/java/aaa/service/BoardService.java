package aaa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aaa.model.BoardDAO;
import aaa.model.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;

	
	 public List<BoardDTO> getBoardList() {
        return boardDAO.list();
    }
	 
	    
    public BoardDTO getBoardDetail(int id) {
        return boardDAO.detail(id);
    }
    
    public void addCount(int id) {
		boardDAO.addCount(id);
	}
    
    public void write(BoardDTO boardDTO) {
		boardDAO.write(boardDTO);
	}
    public BoardDTO idPwCheck(int id, String pw) {
        BoardDTO dto = new BoardDTO();
        dto.setId(id);
        dto.setPw(pw);
        
        return boardDAO.idPwCheck(dto);
    }
    public void delete(BoardDTO boardDTO) {
		boardDAO.delete(boardDTO);
	}
    
	
	 // 이벤트 제어 테스트 해볼 목록 특정페이지 이벤트
	 // 일단 다만들고 생각
	 // 
	 
}
