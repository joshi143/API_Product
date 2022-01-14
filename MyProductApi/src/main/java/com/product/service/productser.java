package com.product.service;

import java.sql.SQLException;
import java.util.List;

import com.product.bean.Product;

public interface productser {
	List<Product> viewAllProducts()throws ClassNotFoundException,SQLException;
	public Product getProductByCode(String productCode)throws ClassNotFoundException,SQLException;
	public Product insertProduct(Product product) throws ClassNotFoundException, SQLException;
	public boolean deleteProduct(String pName)throws ClassNotFoundException,SQLException;
	public Product getProductByName(String pName)throws ClassNotFoundException,SQLException;
	public boolean updateProduct(String pName,double price)throws ClassNotFoundException,SQLException;
	//public Product updateProduct(Product product) throws ClassNotFoundException, SQLException;
}
