package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.UserBeans;


/**
 * Servlet implementation class CO_LoginCheck
 */
@WebServlet("/CO_LoginCheck")
public class CO_LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CO_LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		// login.jspから受け取ったnameとpassをビーンズにセットする
		UserBeans ub = new UserBeans();
		ub.setName(name);
		ub.setPass(pass);

		// アカウントの有無を検索する
		// 検索したアカウント情報を取得
		UserDAO ad = new UserDAO();
		UserBeans returnAb = ad.findAccount(ub);

		if (returnAb != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", returnAb);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp");
			rd.forward(request, response);
			System.out.println("画面遷移成功");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp");
			rd.forward(request, response);
			System.out.println("画面遷移失敗");
		}









	}

}
