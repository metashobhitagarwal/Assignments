package Assignment_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**this class provide  connection 
 *and also close it
 */
public class DBConnection {

	Connection con = null;

	//connect to db
	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class Error" + e);
		}

		String host = "jdbc:mysql://localhost:3306/";
		String db = "lis";
		String mysqlURL = host.trim() + db.trim();
		String user = "root";
		String pass = "gogogo";

		try {
			con = DriverManager.getConnection(mysqlURL.trim(), user, pass);
		} catch (SQLException e) {
			System.out.println("SQL execption" + e);
		}

		return con;
	}

	//close databse connection
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error In Connection Close" + e);
		}
	}
}
