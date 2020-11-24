package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBeans;

public class AccountDAO {
	// データベース接続に使用する情報
	String jdbcUrl = "jdbc:mysql://localhost:3306/mintasudb";
	String jdbcId = "root"; // 上に同じ
	String jdbcPass = "mtmt0509"; // 上に同じ


	// ログインアカウントを探す
	public UserBeans findAccount(UserBeans ab) {
		System.out.println("findAccountのメソッドまで使えているよ！！");

		// 戻り値の用意
		UserBeans returnAb = new UserBeans();

		System.out.println("おはよう");

		// classfornameがいるかも？ネットに書いてあった情報にようといらないみたいな感じになっていたがバージョンなどによっているのかもしれない
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}



		// データベースへ接続
		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

			System.out.println("こんばんは");
//			// SQL文を使うためにステートメントを作成する
//			Statement stmt = con.createStatement();
//
//			//　送りたいSQL文を実行する
//			String sql = "SELECT pass, name, FROM user ";
//			ResultSet rs = stmt.executeQuery(sql);
//
//			// ResultSetに戻り値として含まれている全ての行を選択する
//			while (rs.next()) {
//			String na = rs.getString("name");
//			}



			String sql = "SELECT pass, name, FROM user WHERE pass = ? AND name = ? "; // とりあえずサイトに乗っているコードを丸パクリして書いている。後からSQLを勉強して書き直す
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, ab.getPass());
			ps.setString(2, ab.getName());

			ResultSet rs = ps.executeQuery();

			System.out.println("接続成功！");


			if (rs.next()) {
				// 見つかったアカウント情報を戻り値にリセット
				returnAb.setPass(rs.getString("pass"));
				returnAb.setName(rs.getString("name"));
				System.out.println("OK!");

			} else {
				// アカウントがなければnullを返す
				System.out.println("NG");
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
