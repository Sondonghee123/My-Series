package PersonalProject;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// VO (Value Object)
// DTO (Data Transfer Object)

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MsrDTO {
	 @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("★ ");
		builder.append("올린사람: ");
		builder.append(String.format("%-8s", user_id));
		builder.append(", 포스터: ");
		builder.append(String.format("%-8s", images));
		builder.append(", 미디어종류: ");
		builder.append(String.format("%-5s", types));
		builder.append(", 제목: ");
		builder.append(String.format("%-8s", name));
		builder.append(", 점수: ");
		builder.append(String.format("%-2s", score));
		builder.append(", 코멘트: ");
		builder.append(String.format("%-6s", comments));
		builder.append(" ★");
		return builder.toString();
	}
	 private int seq;
	 private String user_id;
	 private String user_pw;
	 private String images;
	 private String types;
	 private String name;
	 private String score;
	 private String comments;
	 private Date save;
}