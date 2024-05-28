package PersonalProject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 사용자가 요청 -> Controller -> Service
// 사용자display<- View  	    <- Controller
public class MsrController {
	static Scanner scanner = new Scanner(System.in);
	static String log_id;
	static String log_pw;
	public static void main(String[] args) {
		boolean isStop = false;
		boolean login_suc = false;
		MsrService msrService = new MsrService();
		while (!isStop) {
			String selectJob = StartDisplay();
			switch(selectJob) {
			case "0" -> {
				System.out.println("----------프로그램 종료----------");
				isStop = true;
			}
			case "1" -> {
				UserDTO user = newidmenu();
				int result = msrService.IDinsert(user);
				MsrView.print(result>0?"아이디 생성 성공":"아이디 생성 실패(이미 존재하는 아이디입니다.)");
			}
			case "2" -> {
				UserDTO user = signupmenu();
				int result1 = msrService.signUp(user);
				MsrView.print(result1>0?"로그인 성공":"로그인 실패(아이디 또는 비밀번호가 틀립니다.)");
				if (result1 == 1) {
					login_suc = true;
				}
				
				if (login_suc == true) {
					while (!isStop) {
						selectJob = ArchiveDisplay();
						switch(selectJob) {
						case "0" -> {
							System.out.println("----------프로그램 종료----------");
							isStop = true;
						}
						case "1" -> {
							List<MsrDTO> msrlist = msrService.selectAll();
							MsrView.print(msrlist, "모든 작품 조회");
						}
						case "2" -> {
							System.out.print("조회할 작품의 제목 (앞글자만으로도 가능) >> ");
							String name = scanner.nextLine();
							MsrView.print(msrService.selectByname(name), "제목으로 조회");
						}
						case "3" -> {
							System.out.print("조회할 작품의 미디어 종류 >> ");
							String types = scanner.nextLine();
							MsrView.print(msrService.selectBytypes(types), "미디어 종류로 조회");
						}
						case "4" -> {
							System.out.print("조회할 아이디 >> ");
							String user_id = scanner.nextLine();
							MsrView.print(msrService.selectByuserid(user_id), "아이디 조회");
						}
						case "5" -> {
							System.out.print("조회할 작품의 점수(0~5) >> ");
							String score = scanner.nextLine();
							MsrView.print(msrService.selectByscore(score), "점수로 조회");
						}
						case "6" -> {
							System.out.println("====== 작품 추가하기 ======");
							MsrDTO msr = insertMenu();
							int result = msrService.msrInsert(msr);
							MsrView.print(result>0?"추가 성공":"추가 실패");
						}
						case "7" -> {
							Map<String,Object> info = UpdateMenu();
							int result = msrService.msrUpdate((MsrDTO)info.get("updateInfo"), (String)info.get("originalName"));
							MsrView.print(result>0?"수정 성공":"수정 실패(수정하려는 값에 적용된 아이디와 비밀번호 또는 기존 값을 다시 확인하세요.)");
						}
						case "8" -> {
							System.out.println("본인의 기록물만 삭제 할 수 있습니다.");
							System.out.print("삭제할 작품의 제목 >> ");
							String name = scanner.nextLine();
							System.out.print("본인의 아이디 >> ");
							String user_id = scanner.nextLine();
							System.out.print("비밀번호 >> ");
							String user_pw = scanner.nextLine();
							int result = msrService.msrDelete(name);
							MsrView.print(result>0?"삭제 성공":"삭제 실패(아이디 또는 비밀번호를 다시 확인하세요.)");
						}
						default -> {
							System.out.println("------ 제대로 입력해주세요. ------");
							continue;
						}
						}
					}
				}
				
			}
			default -> {
				System.out.println("------ 제대로 입력해주세요. ------");
				continue;
			}
		}
	}
}

	

	private static MsrDTO insertMenu() {
		System.out.println("점수를 제외한 모든 항목은 문자입니다.");
		 
		System.out.print("미디어 종류 >> ");
		String types = scanner.nextLine();
		System.out.print("제목 >> ");
		String name = scanner.nextLine();
		System.out.print("장르 >> ");
		String genre = scanner.nextLine();
		System.out.print("만든이 >> ");
		String producer = scanner.nextLine();
		System.out.print("점수(0~5) >> ");
		String score = scanner.nextLine();
		System.out.print("코멘트 >> ");
		String comments = scanner.nextLine();
		
		MsrDTO msr = new MsrDTO();
		msr.setUser_id(log_id);
		msr.setUser_pw(log_pw);
		msr.setTypes(types);
		msr.setName(name);
		msr.setScore(score);
		msr.setComments(comments);
		
		return msr;
	}
	
	private static Map<String,Object> UpdateMenu() {
		System.out.println("본인의 기록물만 수정 할 수 있습니다.");
		System.out.println("점수를 제외한 모든 항목은 문자입니다.");
		
		System.out.print("수정하는 사람의 ID >> ");
		String user_id = scanner.nextLine();
		System.out.print("비밀번호 >> ");
		String user_pw = scanner.nextLine();
		System.out.print("어떤 제목의 정보를 수정하시겠어요? (제목 입력) >> ");
		String name1 = scanner.nextLine();
		System.out.print("수정된 미디어 종류 >> ");
		String types = scanner.nextLine();
		System.out.print("수정된 제목 >> ");
		String name = scanner.nextLine();
		System.out.print("수정된 장르 >> ");
		String genre = scanner.nextLine();
		System.out.print("수정된 만든이 >> ");
		String producer = scanner.nextLine();
		System.out.print("수정된 점수(0~5) >> ");
		String score = scanner.nextLine();
		System.out.print("수정된 코멘트 >> ");
		String comments = scanner.nextLine();
		
		MsrDTO msr = new MsrDTO();
		msr.setUser_id(log_id);
		msr.setUser_id(user_id);
		msr.setUser_pw(log_pw);
		msr.setUser_pw(user_pw);
		msr.setName(name1);
		msr.setTypes(types);
		msr.setName(name);
		msr.setScore(score);
		msr.setComments(comments);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("originalName", name1);
		resultMap.put("updateInfo", msr);
		return resultMap;
	}
	
	private static UserDTO newidmenu() {
	    System.out.println("=========== 회원가입 ===========");
	    boolean memberOn = true;
	    
	    String user_id = new String();
	    String user_pw = new String();
	    while (memberOn) {
	        System.out.println("======= 새로 생성할 아이디를 입력하세요. (20자 이하). =======");
	        user_id = scanner.nextLine();
	        if (user_id.length() <= 3 || user_id.length() >= 20) {
	            System.out.println("아이디를 4자 이상, 20자 이하로 입력해주세요.");
	            continue;
	        } else if (user_id.contains(" ")) {
	            System.out.println("아이디에 공백이 포함되어선 안됩니다.");
	            continue;
	        }
	        boolean validUserId = true;
	        for (char c : user_id.toCharArray()) {
	            if (!(Character.isDigit(c) || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	                validUserId = false;
	                break;
	            }
	        }
	        if (!validUserId) {
	            System.out.println("아이디는 영문자 또는 숫자로만 구성되어야 합니다.");
	            continue;
	        }
	        System.out.println("======= 새로 생성할 비밀번호를 입력하세요. (20자 이하). =======");
	        user_pw = scanner.nextLine();
	        if (user_pw.length() <= 3 || user_pw.length() >= 20) {
	            System.out.println("비밀번호를 4자 이상, 20자 이하로 입력해주세요.");
	            continue;
	        } else if (user_pw.contains(" ")) {
	            System.out.println("비밀번호에 공백이 포함되어선 안됩니다.");
	            continue;
	        }
	        boolean validUserPw = true;
	        for (char c : user_pw.toCharArray()) {
	            if (!(Character.isDigit(c) || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	                validUserPw = false;
	                break;
	            }
	        }
	        if (!validUserPw) {
	            System.out.println("비밀번호는 영문자 또는 숫자로만 구성되어야 합니다.");
	            continue;
	        }
	        memberOn = false;
	    }
	    
	    UserDTO user = new UserDTO();
	    user.setUser_id(user_id);
	    user.setUser_pw(user_pw);
	    return user;
	}


	
	private static UserDTO signupmenu() {
		System.out.println("============ 로그인 ============");
		System.out.println("======= 로그인할 아이디를 입력하세요. =======");
		
		log_id = scanner.nextLine();
		
		System.out.println("======= 로그인할 비밀번호를 입력하세요. =======");
		
		log_pw = scanner.nextLine();
		
		UserDTO user = new UserDTO();
		user.setUser_id(log_id);
		user.setUser_pw(log_pw);
		return user;
	}

	private static String ArchiveDisplay() {
		System.out.println("------------------------------");
		System.out.println("1. 모든 작품 조회");
		System.out.println("2. 제목 조회");
		System.out.println("3. 특정 미디어 종류 조회");
		System.out.println("4. 아이디 조회");
		System.out.println("5. 점수 조회");
		System.out.println("6. 작품 입력");
		System.out.println("7. 작품 수정");
		System.out.println("8. 작품 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("숫자로 작업을 선택하세요. >> ");
		String job = scanner.nextLine();
		System.out.println("------------------------------");
		
		return job;
	}
	
	private static String StartDisplay() {
		System.out.println("------------------------------");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("숫자로 작업을 선택하세요. >> ");
		String job = scanner.nextLine();
		System.out.println("------------------------------");
		
		return job;
	}
}