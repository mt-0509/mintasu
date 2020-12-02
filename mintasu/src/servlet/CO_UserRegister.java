package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserRegisterDAO;
import model.UserBeans;

/**
 * Servlet implementation class CO_UserRegister
 */
@WebServlet("/CO_UserRegister")
public class CO_UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CO_UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");

		// Register.jspから受け取った値をビーンズにセット
		UserBeans ub = new UserBeans();
		ub.setPass(pass);
		ub.setName(name);

		// アカウントをDBに登録
		UserRegisterDAO urd = new UserRegisterDAO(ub);

		// セッションにユーザー情報を保存
		HttpSession session = request.getSession();
		session.setAttribute("User", ub);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/RegisterSuccess.jsp");
		rd.forward(request, response);
	}

}
