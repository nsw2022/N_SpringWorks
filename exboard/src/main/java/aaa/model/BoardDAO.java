package aaa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDAO {


    Connection con;
    PreparedStatement ptmt;
    ResultSet rs;
    String sql;

    // 전의 방식은 context.xml을 만들어 DataSource 에 우리가 설정한것을 보여주는 방식이였다면
    //  @Autowired 자동으로 사용가능한 곳에 의존성 주입을 해줌
    @Autowired
    DataSource dataSource;

	public void close() {
		if(rs!=null) try { rs.close();	} catch (Exception e) {}
		if(ptmt!=null) try { ptmt.close();	} catch (Exception e) {}
		if(con!=null) try { con.close();	} catch (Exception e) {}
	}

	public List<BoardDTO> list() {
		sql = "select * from board order by id desc";
		List<BoardDTO> bList = new ArrayList<>();

		try {
			con = dataSource.getConnection();
			//System.out.println("conn 님 제발요.. 와주세요");
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setGid(rs.getInt("gid"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setSeq(rs.getInt("seq"));
				dto.setLev(rs.getInt("lev"));
				dto.setPname(rs.getString("pname"));
				dto.setPw(rs.getString("pw"));
				dto.setTitle(rs.getString("title"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setContent(rs.getString("content"));
				dto.setReg_date(rs.getTimestamp("reg_date"));

				bList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return bList;
	}//list
	
	public BoardDTO detail(int id) {
		sql = "select * from board where id = ? ";
		BoardDTO dto = null;
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setGid(rs.getInt("gid"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setSeq(rs.getInt("seq"));
				dto.setLev(rs.getInt("lev"));
				dto.setPname(rs.getString("pname"));
				dto.setPw(rs.getString("pw"));
				dto.setTitle(rs.getString("title"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setContent(rs.getString("content"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}//detail
	
	public void addCount(int id) {
	    sql = "update board set cnt = cnt + 1 where id = ?";
	    // 이방법이 아니면 에러나네요.. finally과 다르지 않은데 어째서.. 절대안닫아지네요 con친구가
	    try (Connection con = dataSource.getConnection();
	         PreparedStatement ptmt = con.prepareStatement(sql)) {
	        
	        ptmt.setInt(1, id);
	        ptmt.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}//addCount
	
	public void write(BoardDTO dto) {
		String sql = "insert into board (title, pname, pw, upfile, content, seq, lev, gid, cnt, reg_date) "
				+ "values (?, ?, ?, ?, ?, 0, 0, 0, -1, sysdate() )";

		try (Connection con = dataSource.getConnection(); PreparedStatement ptmt = con.prepareStatement(sql)) {
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getPname());
			ptmt.setString(3, dto.getPw());
			ptmt.setString(4, dto.getUpfile());
			ptmt.setString(5, dto.getContent());
			ptmt.executeUpdate();

			
			String selectMaxIdSql = "select max(id) from board";
			try (PreparedStatement selectMaxIdStmt = con.prepareStatement(selectMaxIdSql);
					ResultSet rs = selectMaxIdStmt.executeQuery()) {
				if (rs.next()) {
					dto.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int delete(BoardDTO dto) {
		String sql = "delete from board where id = ? and pw = ?";
		int res = 0;
		try (Connection con = dataSource.getConnection(); PreparedStatement ptmt = con.prepareStatement(sql);){
			
			
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			
			res = ptmt.executeUpdate();
		} catch (Exception e) {
			
		}
		return res;
				
	}
	
	public BoardDTO idPwCheck(BoardDTO dto) {
		
		String sql = "select * from board where id = ? and pw = ?";
		BoardDTO res = null;
		
		try (Connection con = dataSource.getConnection(); PreparedStatement ptmt = con.prepareStatement(sql);){
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			
			ResultSet rs = ptmt.executeQuery();
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new BoardDTO();
				res.setId(rs.getInt("id"));
				res.setUpfile(rs.getString("upfile"));
			}
			
		} catch (Exception e) {
			
		}
		return res;
		
	}
	
	public BoardDTO idPwCheck(int id, String pw) {
	    String sql = "select * from board where id = ? and pw = ?";
	    BoardDTO res = null;

	    try (Connection con = dataSource.getConnection(); 
	         PreparedStatement ptmt = con.prepareStatement(sql);) {
	        
	        ptmt.setInt(1, id);
	        ptmt.setString(2, pw);
	        
	        ResultSet rs = ptmt.executeQuery();
	        
	        if (rs.next()) {
	            res = new BoardDTO();
	            res.setId(rs.getInt("id"));
	            res.setUpfile(rs.getString("upfile"));
	        }

	    } catch (Exception e) {
	       
	    }
	    
	    return res;
	}
	
	public int moidfy(BoardDTO dto){

		sql = " update board set title = ?, pname=?, upfile=?, content=? "
			+ " where id=? and pw=?";
		int res = 0;

		try (Connection con = dataSource.getConnection(); 
		         PreparedStatement ptmt = con.prepareStatement(sql);){
			
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getPname());
			ptmt.setString(3, dto.getUpfile());
			ptmt.setString(4, dto.getContent());
			ptmt.setInt(5, dto.getId());
			ptmt.setString(6, dto.getPw());

			res = ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	

}
