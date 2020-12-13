package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentDeleteLogic;
import model.FindCommentLogic;
import model.UserBeans;

/**
 * Servlet implementation class CO_CommentDelete
 */
@WebServlet("/CO_CommentDelete")
public class CO_CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CO_CommentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CommentDeleteLogic cdl = new CommentDeleteLogic();
		cdl.executeCommentDelete();

		// 既存のコメントを確認
		FindCommentLogic fcl = new FindCommentLogic();
		List<UserBeans> list = fcl.executeFindComment();

		// セッションスコープにコメントリストを保存
		HttpSession session = request.getSession();
		session.setAttribute("listAttribute", list);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Post.jsp");
		rd.forward(request, response);

	}

}
