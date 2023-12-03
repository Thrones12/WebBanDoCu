package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

import Models.Category;
import Models.Permission;
import Models.Supplier;
import Services.Impl.CategoryService;
import Services.Impl.PermissionService;
import Services.Impl.SupplierService;

public class DBConnection {
	// Thông tin kết nối
	private final String serverName = "localhost";
	private final String portNumber = "3306";
	private final String dbName = "azshop";
    String userID = "root";
    String password = "Nam1392003";
	
	public Connection getConnection() throws Exception {

		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userID, password);
	}
	public static void main(String[] args) {

		try (Connection conn = new DBConnection().getConnection()){
            System.out.println("Ket noi thanh cong");

        } catch (Exception e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu!");
            e.printStackTrace();
        }

	}
}