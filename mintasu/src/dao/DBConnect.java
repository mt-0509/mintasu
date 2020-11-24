package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {
    public static Connection getConnection(){
        System.out.println("おはよ!");
        Connection con = null; // 初期化
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mintas/mintasudb/user", "root", "mtmt0509");
            System.out.println("DB接続成功!!!");
            return con;
        }catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException(); // クラスがなかった時の例外処理
        } catch (SQLException e) {
            throw new IllegalMonitorStateException(); // SQLでエラーが起きた時の例外処理
        }
    }
}
