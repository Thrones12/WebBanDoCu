package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IProductDAO;
import Models.Product;

public class ProductDAO implements IProductDAO{
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public List<Product> findAll() {
		List<Product> list_pro = new ArrayList<Product>();
		String query = "SELECT * FROM products";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product pro = new Product();
				pro.setProduct_id(rs.getInt("product_id"));
				pro.setProduct_name(rs.getString("product_name"));
				pro.setDescription(rs.getString("description"));
				pro.setPrice(rs.getInt("price"));
				pro.setImage(rs.getString("image"));
				pro.setCategory_id(rs.getInt("category_id"));
				pro.setSeller_id(rs.getInt("seller_id"));
				pro.setAmount(rs.getInt("amount"));
				pro.setStoke(rs.getInt("stoke"));
				list_pro.add(pro);
			}
			conn.close();
			return list_pro;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void Insert(Product product) {
		String query = "INSERT INTO products (product_name, description, price, image, category_id, seller_id, amount, stoke)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getProduct_name());
			ps.setString(2, product.getDescription());
			ps.setFloat(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCategory_id());
			ps.setInt(6, product.getSeller_id());
			ps.setInt(7, product.getAmount());
			ps.setInt(8, product.getStoke());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(Product product) {
		String query = "UPDATE products SET product_name=?, description=?, price=?, image=?, category_id=?, seller_id=?, amount=?, stoke=?"
				+ " WHERE product_id = ? ;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getProduct_name());
			ps.setString(2, product.getDescription());
			ps.setFloat(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCategory_id());
			ps.setInt(6, product.getSeller_id());
			ps.setInt(7, product.getAmount());
			ps.setInt(8, product.getStoke());
			ps.setInt(9, product.getProduct_id());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Delete(int product_id) {
		String query = "DELETE FROM products\r\n"
				+ "WHERE product_id = ?;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, product_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product findByID(int product_id) {
		Product pro = new Product();
		String query="SELECT * FROM products WHERE product_id=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, product_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				pro.setProduct_id(rs.getInt("product_id"));
				pro.setProduct_name(rs.getString("product_name"));
				pro.setDescription(rs.getString("description"));
				pro.setPrice(rs.getFloat("price"));
				pro.setImage(rs.getString("image"));
				pro.setCategory_id(rs.getInt("category_id"));
				pro.setSeller_id(rs.getInt("seller_id"));
				pro.setAmount(rs.getInt("amount"));
				pro.setStoke(rs.getInt("stoke"));
			}
			conn.close();
			return pro;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product findByName(String product_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCategory(int category_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
