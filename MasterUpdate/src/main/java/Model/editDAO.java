package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class editDAO {
	String url = "jdbc:mysql://localhost/LastWork";
	String user = "root";
	String password = "password";
	Connection conection = null;

	public void conect() throws Exception {
		// おまじない
		Class.forName("com.mysql.cj.jdbc.Driver");
		// ①DBに接続
		conection = DriverManager.getConnection(url, user, password);
	}
	
	public ArrayList<HashMap<String, String>> select_me(int user_id) throws Exception {
		PreparedStatement statement = null;
		ResultSet results = null;
		String sql = "SELECT * FROM BOOK";
		//String sql = "SELECT * FROM employeesInfo";
		
		// DB接続メソッド呼び出し
		conect();
		// ステートメント生成
		statement = conection.prepareStatement(sql);
		
		statement.setInt(1, user_id);
		// SQL実行
		results = statement.executeQuery();
		// 取得結果を格納

		ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
		while (results.next()) {
			HashMap<String, String> columns = new HashMap<String, String>();

			String id = results.getString("id");
			columns.put("id", id);

			String name = results.getString("name");
			columns.put("name", name);

			String position = results.getString("position_name");
			columns.put("position", position);

			String dpt = results.getString("dpt_name");
			columns.put("dpt", dpt);
			rows.add(columns);
		}
		return rows;
	}
}