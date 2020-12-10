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

import model.AddCommentLogic;
import model.FindCommentLogic;
import model.UserBeans;

/**
 * Servlet implementation class CO_Post
 */
@WebServlet("/CO_Post")
public class CO_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CO_Post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8"); //この部分はいらないかも？

		// 既存のコメントを確認
		FindCommentLogic fcl = new FindCommentLogic();
		List<UserBeans> list = fcl.executeFindComment();

		// セッションスコープにコメントリストを保存
		HttpSession session = request.getSession();
		session.setAttribute("listAttribute", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Post.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		// 入力された値を取得
		String name = request.getParameter("name"); // nameは入力するのではなく、勝手にログインした名前で入力されるようにしたい
		String comment = request.getParameter("comment");

		// JavaBeansに格納
		UserBeans ub = new UserBeans();
		ub.setName(name);
		ub.setComment(comment);

		// mysqlに格納
		AddCommentLogic acl = new AddCommentLogic();
		acl.executeAddComment(ub);

		// 今入力されたコメントと既存のコメントをmysqlから取得
		FindCommentLogic fcl = new FindCommentLogic();
		List<UserBeans> list = fcl.executeFindComment();

		// セッションスコープ にコメントリストを保存
		HttpSession session = request.getSession();
		session.setAttribute("listAttribute", list);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Post.jsp");
		rd.forward(request, response);

	}

}
