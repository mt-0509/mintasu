package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentDeleteDAO {
	public CommentDeleteDAO() {

		final String jdbcId = "root";
		final String jdbcPass = "mtmt0509";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/mintasudb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {
			String sql = "DELETE FROM post";
			Statement st = con.createStatement();
			st.executeUpdate(sql);


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
