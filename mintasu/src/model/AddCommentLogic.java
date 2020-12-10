package model;

import dao.UserAddCommentDAO;

public class AddCommentLogic {
	public void executeAddComment(UserBeans ub) {
		UserAddCommentDAO acdao = new UserAddCommentDAO(ub);
	}
}
