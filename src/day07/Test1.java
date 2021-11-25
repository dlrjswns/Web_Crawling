package day07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="jun";
		String password = "1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 번호와 이름을 순서대로 입력해주세요: ");
		String num = sc.next();
		String name = sc.next();
		String sql = "insert into text values("+num+", '"+name+"')";
		String prsql = "select * from text where a="+num+"and b='"+name+"'";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql); 
			ResultSet rs = stmt.executeQuery(prsql);
			
			while(rs.next()) {
			System.out.println("추가된 번호는 "+rs.getInt("a")+"이름은 "+rs.getString("b"));
			//조회하는 select를 할때는 executeQuery()를 사용했는데 데이터를 삭제하거나 추가할때는
			//executeUpdate()를 사용해준다
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
