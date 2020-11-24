package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserBeans;

public class AccountRegisterDAO {
	// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "mtmt0509";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/mintas/mintasudb";

	public AccountRegisterDAO(UserBeans ab) {
		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

			String sql = "INSERT INTO account (pass, name) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, ab.getPass());
			ps.setString(2, ab.getName());

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
