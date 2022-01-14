package com.product.service;

import java.sql.SQLException;
import java.util.List;

import com.product.bean.Product;
import com.product.persistence.productdao;
import com.product.persistence.productdaoimpl;

public class productserimpl implements productser {
	productdao pdao=new productdaoimpl();
	@Override
	public List<Product> viewAllProducts() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		return pdao.getAllRecords();
	}
	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Product product=pdao.getProductByCode(productCode);
		return product;
	}
	@Override
	public Product insertProduct(Product product) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int rows=pdao.insertProduct(product);
		if(rows>0) {
			Product product1=pdao.getProductByCode(product.getCode());
			return product1;
		}
		return null;
	}
	@Override
	public boolean deleteProduct(String pName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int rows=pdao.deleteProduct(pName);
		if(rows>0)
			return true;
		return false;
	}
	@Override
	public Product getProductByName(String pName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Product product=pdao.getProductByName(pName);
		return product;
	}
	@Override
	public boolean updateProduct(String pName, double price) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int rows=pdao.updateproduct(pName,price);
		if(rows>0)
			return true;
		return false;
	}
//	@Override
//	public Product updateProduct(Product product) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		int rows=pdao.updateProduct(product);
//		if(rows>0) {
//			Product product1=pdao.getProductByCode(product.getCode());
//			return product1;
//		}
//		return null;
//	}

	

}
