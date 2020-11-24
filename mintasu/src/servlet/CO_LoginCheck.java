package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.UserBeans;
import model.otameshi;


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
		doGet(request, response);


		// アカウントDAOをインスタンス化してメソッドを使える
		// 仮引数を何にするのか不明

		// loginIdとpassをjspから受け取る必要がある
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		System.out.println(name);
		System.out.println(pass);

		// login.jspから受け取ったログインIDとpassをビーンズに
		UserBeans UB = new UserBeans();
		UB.setName(name);
		UB.setPass(pass);

		// アカウントの有無を検索
		// 検索したアカウント情報を取得
		AccountDAO ad = new AccountDAO();
		UserBeans returnAb = ad.findAccount(UB);

		otameshi ot = new otameshi();
		ot.ooo();

		if (returnAb != null) {
			// セッションにアカウントを情報を登録する
			HttpSession session = request.getSession();
			session.setAttribute("User", returnAb);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp");
			rd.forward(request, response);
			System.out.println("成功だよ");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp");
			rd.forward(request, response);
			System.out.println("失敗");
			System.out.println(returnAb);

		}



	}

}
