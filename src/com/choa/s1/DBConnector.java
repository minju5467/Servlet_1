package com.choa.s1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

	public Connection getConnect() throws Exception {

		String user = "hr";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		System.out.println("드라이버 로딩 성공");

		Connection con = DriverManager.getConnection(url, user, pw);

		return con;

	}
}
