package PersonalProject;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

// View는 사용자에게 어떻게 보여줄지를 담당함, 추후 JSP로 작성할 예정
public class MsrView {

	public static void print(List<MsrDTO> msrlist, String title) {
		System.out.println("=======" + title + "=======");
		if (msrlist.size()==0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
			return;
		}
		else {
			msrlist.stream().forEach(msr->System.out.println(msr));
		}
		
	}
	
	public static void print(MsrDTO msr, String title) {
		System.out.println("=======" + title + "=======");
		if (msr==null) {
			System.out.println("존재하지 않는 작품입니다.");
		}
		else {
			System.out.println("아이디: " + msr.getUser_id());
			System.out.println("미디어 종류: " + msr.getTypes());
			System.out.println("제목: " + msr.getName());
			System.out.println("점수(0~5): " + msr.getScore());
			System.out.println("코멘트: " + msr.getComments());
			System.out.println("저장 날짜: " + msr.getSave());
		}
	}
	
	
	public static void print(String message) {
		System.out.println(message);
	}
	
	public static void print(Map<String, Object> msr) {
		for(String key:msr.keySet()) {
			System.out.println(key + " ==>" + msr);
		}
	}
	
	public static void joinMemberIDprint(List<MsrDTO> msrlist) {
		boolean idvalid = false;
		boolean pwvalid = false;
		boolean isStop = true;
		System.out.println("======= 회원가입 =======");
		while(isStop == true) {
			System.out.println("======= 새로 생성할 아이디를 입력하세요. (20자 이하). =======");
			Scanner scanner = new Scanner(System.in);
			String newid = scanner.nextLine();
			if (newid.length()<=3 && newid.length()<=20) {
				System.out.println("아이디를 4자 이상, 20자 이하로 입력해주세요.");
				continue;
			}
			else if (newid.contains(" ")) {
				System.out.println("아이디에 공백이 포함되어선 안됩니다.");
				continue;
			}
			for (char c : newid.toCharArray()) {
		        if (!(Character.isDigit(c) || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
		        	idvalid = true;
		        }
		    }
			if (idvalid == true) {
				System.out.println("아이디는 영문 소,대문자와 숫자만 가능합니다.");
				continue;
			}

			System.out.println("======= 새로 생성할 비밀번호를 입력하세요. (20자 이하). =======");

			String newpass = scanner.nextLine();
			if (newpass.length()<=3 && newpass.length()<=20) {
				System.out.println("비밀번호를 4자 이상, 20자 이하로 입력해주세요.");
				continue;
			}
			else if (newpass.contains(" ")) {
				System.out.println("비밀번호에 공백이 포함되어선 안됩니다.");
				continue;
			}
			for (char c : newpass.toCharArray()) {
		        if (!(Character.isDigit(c) || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
		        	pwvalid = true;
		        }
		    }
			if (pwvalid == true) {
				System.out.println("아이디는 영문 소,대문자와 숫자만 가능합니다.");
				continue;
			}
			
			System.out.println(newid + "아이디가 생성되었습니다.");
			scanner.close();
		}
		
	}
}