package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	// Thông tin kết nối
	private final String serverName = "localhost";
	private final String portNumber = "3306";
	private final String dbName = "Webbandocu";
    String userID = "root";
    String password = "Phong@123";
	
	public Connection getConnection() throws Exception {

		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
		
		return DriverManager.getConnection(url, userID, password);
	}
	public static void main(String[] args) {

		try (Connection conn = new DBConnection().getConnection()){
            System.out.println("Ket noi thanh cong");

            // Thêm mã xử lý cơ sở dữ liệu ở đây nếu cần
        } catch (Exception e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu!");
            e.printStackTrace();
        }

	}
}
