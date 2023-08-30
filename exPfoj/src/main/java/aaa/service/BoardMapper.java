package aaa.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aaa.model.BoardDTO;

@Mapper
public interface BoardMapper {
	List<BoardDTO> list();
	
	// 리스트 정렬버전
	List<BoardDTO> list2(int start, int limit);
	
	// 글 수정
	BoardDTO detail(int id);
	
	// 글 삽입
	int insseerr(BoardDTO dto);
	
	// 삭제
	int delettt(BoardDTO dto);
	
	// 수정
	int modifffy(BoardDTO dto);
	
	// idCheck
	int idCheck(BoardDTO dto);
	
	// 조회수
	int addCount(int id);
	
	// 총페이지 카운트
	int totalCnt();
	
	// gid id 같게해주기
	int maxI(BoardDTO dto);
	
	// 답글
	int reply(BoardDTO dto);
}
