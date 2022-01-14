<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#link1")
								.click(
										function() {
											$
													.getJSON(
															"http://localhost:8085/MyProductApi/webapi/products",
															function(data1,
																	status) {
																$(
																		"#allproducts")
																		.html(
																				displayAllProducts(data1))
															})
										})
					}

			)
	$(document)
			.ready(
					function() {
						$("#link2")
								.click(
										function() {
											alert("hello");
											$
													.getJSON(
															"http://localhost:8085/MyProductApi/webapi/products/code/101",
															function(data2,
																	status) {
																$(
																		"#allproducts")
																		.html(
																				displayProduct(data2))
															})
										})
					})

	$(document).ready(function() {
		$("#save").click(function() {
			alert("hi");
			var arr = {  code: $("#productcode").val(),
				    description: $("#productdesc").val(),
				    id: $("#productid").val(),
				    name: $("#productname").val(),
				    price: $("#productprice").val() };
			$.ajax({
			    url: 'http://localhost:8085/MyProductApi/webapi/products',
			    type: 'POST',
			    data: JSON.stringify(arr),
			    contentType: 'application/json; charset=utf-8',
			    dataType: 'json',
			    async: false,
			    success: function(msg) {
			    	$(
					"#allproducts")
					.html(
							displayProduct(msg))
			    }
			});
		})

	})
	$(document).ready(function() {
		$("#saved").click(function() {
			//alert($("#productnamed").val());
			$.ajax({
			    url: 'http://localhost:8085/MyProductApi/webapi/products/delete/'+$("#productnamed").val(),
			    type: 'post',
			    
			    success: function(msg) {
			    	$(
					"#allproducts")
					.html(
							displayProduct(msg))
			    }
			});
		})

	})
	$(document).ready(function() {
		$("#updated").click(function() {
			alert($("#upproname").val());
			alert($("#upproprice").val());
			$.ajax({
			    url: 'http://localhost:8085/MyProductApi/webapi/products/update/'+$("#upproname").val()+'/'+$("#upproprice").val(),
			    type: 'post',
			    
			    success: function(msg) {
			    	$(
					"#allproducts")
					.html(
							displayProduct(msg))
			    }
			});
		})

	})
	
	function displayAllProducts(data) {
		var table = "<table border=\"1\"><tr><td>Product ID</td><td>Product Code</td><td>Product Name</td><td>Product Description</td><td>Price</td></tr>";
		for (var index = 0; index < data.prolist.length; index++) {
			table += "<tr><td>" + data.prolist[index].id + "</td><td>"
					+ data.prolist[index].code + "</td><td>"
					+ data.prolist[index].name + "</td><td>"
					+ data.prolist[index].description + "</td><td>"
					+ data.prolist[index].price + "</td></tr>";
		}
		return table;
	}

	function displayProduct(data) {
		var table = "<table border=\"1\"><tr><td>Product ID</td><td>Product Code</td><td>Product Name</td><td>Product Description</td><td>Price</td></tr>";
		table += "<tr><td>" + data.id + "</td><td>" + data.code + "</td><td>"
				+ data.name + "</td><td>" + data.description + "</td><td>"
				+ data.price + "</td></tr></table>";

		return table;
	}
</script>
</head>
<body>
	<a id="link1" href="#">Display All Products</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a id="link2" href="#">Display Product By Code</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<br>
	<from> Enter Product Id:<input type="text" name="productid"
		id="productid"> <br>
	<br>
	Enter Product Code:<input type="text" name="productcode"
		id="productcode"> <br>
	<br>
	Enter Product Name:<input type="text" name="productname"
		id="productname"> <br>
	<br>
	Enter Product Description:<input type="text" name="productdesc"
		id="productdesc"> <br>
	<br>
	Enter Product Price:<input type="text" name="productprice"
		id="productprice"> <br>
	<br>
	<input type="submit" value="submit" id="save"> </from>
	<br>
	Enter Product Name:<input type="text" name="productname"
		id="productnamed"> <br>
	<br>
	<input type="submit" value="delete" id="saved">
	<br>
	<br>
	<br>
	<h3>To Update Product Price</h3>
	Enter Product Name:<input type="text" name="upproname"
	id="upproname">
	Enter New Product Price:<input type="text" name="upproprice"
	id="upproprice">
	<br>
	<br>
	<input type="submit" value="update" id="updated">
	
	<div id="allproducts"></div>
</body>
</html>