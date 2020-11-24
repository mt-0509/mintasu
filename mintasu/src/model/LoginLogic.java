package model;

public class LoginLogic {
	public boolean execute(User user) {
		if(user.getPass().equals("1234")) { return true;} // 1234のパスワードの部分は仮で使っている
		System.out.println("行う");
		return false;                                     // 本当はDBにアクセスしてパスワードが正しいか確認するコードを書く必要がある
	}


}
