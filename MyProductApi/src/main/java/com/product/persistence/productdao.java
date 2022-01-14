package com.product.persistence;

import java.sql.SQLException;
import java.util.List;

import com.product.bean.Product;



public interface productdao {
	List<Product> getAllRecords()throws ClassNotFoundException,SQLException;
	public Product getProductByCode(String productCode)throws ClassNotFoundException,SQLException;
	public int insertProduct(Product product)throws ClassNotFoundException,SQLException;
	int deleteProduct(String pName)throws ClassNotFoundException,SQLException;
	public Product getProductByName(String pName)throws ClassNotFoundException,SQLException;
	public int updateproduct(String pName,double price)throws ClassNotFoundException,SQLException;
//	public int updateProduct(Product product)throws ClassNotFoundException,SQLException;
}
