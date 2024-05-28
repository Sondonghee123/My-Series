package PersonalProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.*;

//DAO(Data를 Access하는 비즈니스 로직을 작성하는 오브젝트)
public class MsrDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst; // Statement를 상속받음, 바인딩 변수 (?) 를 지원함
	ResultSet rs;
	
	// 8. 웹에서 삭제(Delete)
		public int msrDelete(String name) {
			int result = 0;
			String sql = "delete from archives "
					+ "where name = ?";
			conn = DBUtil.dbConnection();
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				result = pst.executeUpdate(); // DML문장은 executeUpdate, Select문은 executeQuery
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return result;
		}
	
	// 7. 수정(Update)
	public int msrUpdate1(MsrDTO msr,String originalName) {
		int result = 0;
		String sql = "update archives set  "
				+ "types = ?, "
				+ "name = ?, "
				+ "score = ?, "
				+ "comments = ? "
				+ "where user_id = ? and user_pw = ? and name = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, msr.getTypes());
			pst.setString(2, msr.getName());
			pst.setString(3, msr.getScore());
			pst.setString(4, msr.getComments());
			pst.setString(5, msr.getUser_id());
			pst.setString(6, msr.getUser_pw());
			pst.setString(7, originalName);
			result = pst.executeUpdate(); // DML문장은 executeUpdate, Select문은 executeQuery
		} catch (SQLException e) {
			System.out.println("기존 값이 다르거나, 바꿀 값의 데이터 형식이 다릅니다.");
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 7. 웹 전용 수정
	public int msrUpdate(MsrDTO msr,String originalName) {
		int result = 0;
		String sql = "update archives set "
				+ " images=?, "
				+ " types=?, "
				+ " name=?, "
				+ " score=?, "
				+ " comments=?"
				+ "	where name=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, msr.getImages());
			pst.setString(2, msr.getTypes());
			pst.setString(3, msr.getName());
			pst.setString(4, msr.getScore());
			pst.setString(5, msr.getComments());
			pst.setString(6, originalName);
			result = pst.executeUpdate(); // DML문장은 executeUpdate, Select문은 executeQuery
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("기존 값이 다르거나, 바꿀 값의 데이터 형식이 다릅니다.");
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 6. 입력(Insert)
	public int msrInsert(MsrDTO msr) {
		int result = 0;
		String sql = "insert into archives "
				+ "( seq, user_id, user_pw, images, types, name, score, comments)"
				+ " values(archives_seq.nextval,?,?,?,?,?,?,?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, msr.getUser_id());
			pst.setString(2, msr.getUser_pw());
			pst.setString(3, msr.getImages());
			pst.setString(4, msr.getTypes());
			pst.setString(5, msr.getName());
			pst.setString(6, msr.getScore());
			pst.setString(7, msr.getComments());
			
			result = pst.executeUpdate(); // DML문장은 executeUpdate, Select문은 executeQuery
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("점수는 0~5만 입력 가능합니다.");
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 5. 점수로 조회하기
	public List<MsrDTO> selectByscore(String score) {
		List<MsrDTO> msrlist = new ArrayList<MsrDTO>();
		String sql = "SELECT SEQ, USER_ID, USER_PW, IMAGES, TYPES, NAME, SCORE, CASE WHEN LENGTH(COMMENTS) BETWEEN 1 AND 15 THEN COMMENTS ELSE SUBSTR(COMMENTS,1,15)||'...' END COMMENTS, SAVE"
				+ " FROM archives"
				+ " where score = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, score); // 첫번째 ?에 score를 넣어라
			rs = pst.executeQuery();
			while(rs.next()) {
				MsrDTO msr = makeMsr(rs);
				msrlist.add(msr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return msrlist;
	}
	
	// 4. 특정 아이디로 조회 (여러개)
	public List<MsrDTO> selectByuserid(String user_id) {
	    List<MsrDTO> msrlist = new ArrayList<MsrDTO>();
	    String sql = "SELECT SEQ, USER_ID, USER_PW, IMAGES, TYPES, NAME, SCORE, CASE WHEN LENGTH(COMMENTS) BETWEEN 1 AND 15 THEN COMMENTS ELSE SUBSTR(COMMENTS,1,15)||'...' END COMMENTS, SAVE"
	    		+ "  FROM archives"
	    		+ " where user_id = ?";
	    conn = DBUtil.dbConnection();
	    try {
	        pst = conn.prepareStatement(sql);
	        pst.setString(1, user_id);
	        rs = pst.executeQuery();
	        while(rs.next()) {
	            MsrDTO msr = makeMsr(rs);
	            msrlist.add(msr);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.dbDisconnect(conn, pst, rs);
	    }
	    return msrlist;
	}

	
	// 3. 특정 미디어 종류로 조회
	public List<MsrDTO> selectBytypes(String types) {
	    List<MsrDTO> msrlist = new ArrayList<MsrDTO>();
	    String sql = "SELECT SEQ, USER_ID, USER_PW, IMAGES, TYPES, NAME, SCORE, CASE WHEN LENGTH(COMMENTS) BETWEEN 1 AND 15 THEN COMMENTS ELSE SUBSTR(COMMENTS,1,15)||'...' END COMMENTS, SAVE"
	    		+ " FROM archives"
	    		+ " where types = ?";
	    conn = DBUtil.dbConnection();
	    try {
	        pst = conn.prepareStatement(sql);
	        pst.setString(1, types); // 첫번째 ?에 types를 넣어라
	        rs = pst.executeQuery();
	        while(rs.next()) {
	            MsrDTO msr = makeMsr(rs);
	            msrlist.add(msr);
	        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        DBUtil.dbDisconnect(conn, pst, rs);
	    }
	    return msrlist;
	}

	
	// 2. 제목으로 조회 (특정 문자로 시작)
	public List<MsrDTO> selectByname(String name) {
		List<MsrDTO> msrlist = new ArrayList<MsrDTO>();
		String sql = "SELECT SEQ, USER_ID, USER_PW, IMAGES, TYPES, NAME, SCORE, CASE WHEN LENGTH(COMMENTS) BETWEEN 1 AND 15 THEN COMMENTS ELSE SUBSTR(COMMENTS,1,15)||'...' END COMMENTS, SAVE"
				+ " FROM archives"
				+ " where name like '%'||?||'%' ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name); // 첫번째 ?에 name를 넣어라
			rs = pst.executeQuery();
			while(rs.next()) {
				MsrDTO msr = makeMsr(rs);
				msrlist.add(msr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return msrlist;
	}
	
	
	// 1. 모든 작품 조회 (여러개)
	public List<MsrDTO> selectAll() {
		List<MsrDTO> msrlist = new ArrayList<MsrDTO>();
		String sql = "SELECT SEQ, USER_ID, USER_PW, IMAGES, TYPES, NAME, SCORE, CASE WHEN LENGTH(COMMENTS) BETWEEN 1 AND 15 THEN COMMENTS ELSE SUBSTR(COMMENTS,1,15)||'...' END COMMENTS, SAVE"
				+ "  FROM archives";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				MsrDTO msr = makeMsr(rs);
				msrlist.add(msr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return msrlist;
		
		
	}
	// 특정 작품 조회
	private MsrDTO makeMsr(ResultSet rs) throws SQLException {
		MsrDTO msr = new MsrDTO();
		
		msr.setSeq(rs.getInt("seq"));
		msr.setUser_id(rs.getString("user_id"));
		msr.setTypes(rs.getString("types"));
		msr.setName(rs.getString("name"));
		msr.setScore(rs.getString("score"));
		msr.setComments(rs.getString("comments"));
		msr.setSave(rs.getDate("save"));
		msr.setImages(rs.getString("images"));
		return msr;
	}
	
	public int IDinsert(UserDTO user) {
		int result = 0;
		String sql = "insert into users "
				+ "values(?,?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getUser_pw());
			result = pst.executeUpdate(); // DML문장은 executeUpdate, Select문은 executeQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	public int IDdelete(UserDTO user) {
		int result = 0;
		String sql = "delete from users where user_id=? and password=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getUser_pw());
			result = pst.executeUpdate(); // DML문장은 executeUpdate, Select문은 executeQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// users 테이블에 로그인한 아이디가 있는지 확인하는 기능
	public int signUp(UserDTO user) {
		int result =0 ;
		String sql = "select count(user_id) from users "
				+ "where user_id = ? "
				+ "and password = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getUser_pw());
			rs = pst.executeQuery(); // DML문장은 executeUpdate, Select문은 executeQuery
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("제대로 입력해주세요.");
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
}