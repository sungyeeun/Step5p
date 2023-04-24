package spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.Member;
import spring.dao.MemberDao;
import spring.exceptions.MemberNotFoundException;

public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;

	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);
		// 기존 객체의 패스워드만 변경되므로 아래 메소드를 호출하지 않아도
		// 변경된 내용은 반영된다.
		// memberDao.update(member);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
