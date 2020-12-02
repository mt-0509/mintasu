package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class otameshi {
	 public  void ooo() {

		 String url = "jdbc:mysql://localhost:3306/mintasudb";
		 String username = "root";
		 String password = "mtmt0509";

		 System.out.println("Connecting database...");

		 try (Connection connection = DriverManager.getConnection(url, username, password)) {
		     System.out.println("Database connected!");

		     // SQL文を使うためにステートメントを作成する
		     Statement stmt = connection.createStatement();

		     // 送りたいSQL文を実行する
		     String sql = "SELECT pass FROM user";
		     ResultSet rs = stmt.executeQuery(sql);

		     // ResultSetに戻り値として含まれている全ての行を取得する
		     while (rs.next()) {
		    	 String na = rs.getString("pass");
		    	 System.out.println(na);
		    	 System.out.println("俺の名前は真武だ！！！");
		     }
		     rs.close();
		     stmt.close();


		 } catch (SQLException e) {
		     throw new IllegalStateException("Cannot connect the database!", e);
		 }

	 }

}
