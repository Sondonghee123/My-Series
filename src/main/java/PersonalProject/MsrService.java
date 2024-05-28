package PersonalProject;

import java.util.List;

// Controller->Service->DAO
//			 <-		   <-
// Service: 비즈니스 로직을 수행함
public class MsrService {
	MsrDAO msrDAO = new MsrDAO();
	
	// 8. 삭제(Delete)
		public int msrDelete(String name) {
			return msrDAO.msrDelete(name);
		}
	
	// 7. 수정(Update)
		public int msrUpdate(MsrDTO msr, String originalName) {
			return msrDAO.msrUpdate(msr,originalName);
		}
	
	// 6. 입력(Insert)
		public int msrInsert(MsrDTO msr) {
			return msrDAO.msrInsert(msr);
		}
	
	// 5. 점수로 조회하기
		public List<MsrDTO> selectByscore(String score) {
			return msrDAO.selectByscore(score);
	}
	
	// 4. 아이디로 조회 (여러개)
	public List<MsrDTO> selectByuserid(String user_id) {
		return msrDAO.selectByuserid(user_id);
	}
	
	// 3. 특정 미디어 종류로 조회 (여러개)
	public List<MsrDTO> selectBytypes(String types) {
		return msrDAO.selectBytypes(types);
	}
	
	// 2. 제목으로 조회 (여러개)
	public List<MsrDTO> selectByname(String name) {
		return msrDAO.selectByname(name);
	}
	
	// 1. 모든 작품 조회 (여러명)
	public List<MsrDTO> selectAll() {
		
		return msrDAO.selectAll();
	}
	// 아이디 만들기
	public int IDinsert(UserDTO user) {
		
		return msrDAO.IDinsert(user);
	}
	
	// 아이디 삭제하기
	public int IDdelete(UserDTO user) {
		
		return msrDAO.IDdelete(user);
	}

	// 로그인하기
	public int signUp(UserDTO user) {
		return msrDAO.signUp(user);
	}
	
}