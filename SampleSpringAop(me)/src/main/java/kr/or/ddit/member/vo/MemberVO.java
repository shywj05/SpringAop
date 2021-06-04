package kr.or.ddit.member.vo;

import java.sql.Date;

public class MemberVO {

	private String memberId;
	private String password;
	private String name;
	private String email;
	private Date regDate;

	public MemberVO() {

	}

	public MemberVO(String memberId, String password, String name, String email, Date regDate) {
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.regDate = regDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + "]";
	}

}
