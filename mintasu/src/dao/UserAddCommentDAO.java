package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserBeans;

public class UserAddCommentDAO {
	public UserAddCommentDAO(UserBeans ub) {

		final String jdbcId = "root";
		final String jdbcPass = "mtmt0509";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/mintasudb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO user (comment) VALUES(?)");

			ps.setString(1, ub.getComment());

			// ひな形を送信
			int r = ps.executeUpdate();
			if (r != 0) {
				System.out.println(r + "件の書き込みを追加しました");
			}
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
