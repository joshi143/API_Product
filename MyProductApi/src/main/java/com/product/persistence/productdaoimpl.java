package com.product.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.Product;
import com.product.helper.OracleConnection;

public class productdaoimpl implements productdao {

	@Override
	public List<Product> getAllRecords() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();

		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String des = resultSet.getString("DESCRIPTION");
			double price = resultSet.getDouble("PRICE");

			Product product = new Product(id, code, name, des, price);
			productList.add(product);
		}

		connection.close();

		return productList;
	}

	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Product product = null;

		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE CODE=?");
		preparedStatement.setString(1, productCode);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price = resultSet.getDouble("PRICE");

			product = new Product(id, code, name, description, price);
		}

		connection.close();
		return product;
	}

	@Override
	public int insertProduct(Product product) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?,?)");
		preparedStatement.setLong(1, product.getId());
		preparedStatement.setString(2, product.getCode());
		preparedStatement.setString(3, product.getName());
		preparedStatement.setString(4, product.getDescription());
		preparedStatement.setDouble(5, product.getPrice());

		int rows = preparedStatement.executeUpdate();

		return rows;
	}

	@Override
	public int deleteProduct(String pName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUCT WHERE NAME=?");

		preparedStatement.setString(1, pName);

		int rows = preparedStatement.executeUpdate();

		return rows;
	}

	@Override
	public Product getProductByName(String pName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Product product = null;

		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE NAME=?");
		preparedStatement.setString(1, pName);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price = resultSet.getDouble("PRICE");

			product = new Product(id, code, name, description, price);
		}

		connection.close();
		return product;
	}

	@Override
	public int updateproduct(String pName, double price) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PRODUCT SET PRICE=? WHERE NAME=?");
		preparedStatement.setDouble(1, price);
		preparedStatement.setString(2, pName);

		int rows = preparedStatement.executeUpdate();

		return rows;
	}

}
