package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UserBeans;

public class UserFindCommentDAO {

	public List<UserBeans> findcomment() {

		// id,name,commentを格納するリスト
		List<UserBeans> list = new ArrayList<>();

		final String jdbcId = "root";
		final String jdbcPass = "mtmt0509";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/mintasudb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {
			String sql = "select * from post";
			Statement st = con.createStatement();

			try {

				// sqlを送信
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					// DBから取り出したname,commentをJavaBeansにセットする
					UserBeans ub = new UserBeans();
					ub.setComment(rs.getString("comment"));

					// リストに1個ずつ格納。末尾に要素が追加されていく
					list.add(ub);
			}
				rs.close();
				st.close();


			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
