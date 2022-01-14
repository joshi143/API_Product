package com.Rest.demo;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.product.bean.Product;
import com.product.bean.Productlist;
import com.product.service.productser;
import com.product.service.productserimpl;

@Path("/products")
public class ProductResource {
	private productser productService=new productserimpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllProducts(){
		Productlist prolistref=new Productlist();
		try {
			List<Product> proslist=productService.viewAllProducts();
			prolistref.setProlist(proslist);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(prolistref)
	            .build();
		
//		List<Product> products=new ArrayList();
//		products.add(new Product(0, null, null, null, 0))
		
	}
	@Path("/code/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByCode(@PathParam("code") String code) {
		Product product=null;
		try {
			product=productService.getProductByCode(code);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(product)
	            .build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product c) 
	{ 
		Product product=null;
		try {
			product=productService.insertProduct(c);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(product)
	            .build();
	}
	@Path("/delete/{delete}")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteProduct(@PathParam("delete")String pName)
	{
		boolean probool=false;
		Product product1=null;
		try {
			product1=productService.getProductByName(pName);
			probool=productService.deleteProduct(pName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(product1)
	            .build();
	}
	@Path("/update/{pname}/{price}")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response updateProduct(@PathParam("pname")String pName,@PathParam("price")Double price)
	{
		boolean probool=false;
		Product product1=null;
		try {
			probool=productService.updateProduct(pName,price);
			product1=productService.getProductByName(pName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(product1)
	            .build();
	}
}
