package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBeans;

public class UserDAO {
	// データベース接続に使用する情報
	String jdbcUrl = "jdbc:mysql://localhost:3306/mintasudb";
	String jdbcId = "root"; // 上に同じ
	String jdbcPass = "mtmt0509"; // 上に同じ


	// ログインアカウントを探す
	public UserBeans findAccount(UserBeans ub) {

		// 戻り値の用意
		UserBeans returnAb = new UserBeans();


		// classfornameがいるかも？ネットに書いてあった情報にようといらないみたいな感じになっていたがバージョンなどによっているのかもしれない
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}



		// データベースへ接続
		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {


			String sql = "SELECT pass,name FROM user WHERE pass = ? AND name = ? "; // とりあえずサイトに乗っているコードを丸パクリして書いている。後からSQLを勉強して書き直す
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, ub.getPass());
			ps.setString(2, ub.getName());

			ResultSet rs = ps.executeQuery();

			System.out.println("DB接続成功！");


			if (rs.next()) {
				// 見つかったアカウント情報を戻り値にリセット
				returnAb.setPass(rs.getString("pass"));
				returnAb.setName(rs.getString("name"));
				System.out.println("アカウントOK!");

			} else {
				// アカウントがなければnullを返す
				System.out.println("アカウントNG");
				return null;
			}




		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLのとこ");
			return null;
		}
		return returnAb;
	}

}
