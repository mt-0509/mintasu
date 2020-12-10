package model;

import java.util.List;

import dao.UserFindCommentDAO;

public class FindCommentLogic {
	public List<UserBeans> executeFindComment() {
		UserFindCommentDAO fcdao = new UserFindCommentDAO();
		List<UserBeans> list = fcdao.findcomment();
		return list;
	}

}
