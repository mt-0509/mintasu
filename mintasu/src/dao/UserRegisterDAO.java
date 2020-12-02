package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserBeans;

public class UserRegisterDAO {
	// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "mtmt0509";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/mintasudb";

	public UserRegisterDAO(UserBeans ub) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

			String sql = "INSERT INTO user (pass, name) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, ub.getPass());
			ps.setString(2, ub.getName());

			int r = ps.executeUpdate();
			if(r != 0) {
				System.out.println("新規登録成功！");
			} else {
				System.out.println("新規登録失敗");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
