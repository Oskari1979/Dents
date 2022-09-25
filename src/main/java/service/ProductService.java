package service;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Product;
import conn.Connections;


@Path("/service")
public class ProductService {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	//@CrossOrigin(origins = "http://localhost:8080")
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Product> listAll() {
		ArrayList<Product> list=new ArrayList<>();
		
		Connection conn=null;
		try {
			conn=Connections.getConnection();	
			}
		catch(Exception e) {}
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("SELECT * FROM products");
			while (RS.next()) {
				Product product=new Product();
				product.setId(RS.getInt("id"));
				product.setProduct_id(RS.getString("product_id"));
				product.setName(RS.getString("name"));
				product.setWeight(RS.getInt("weight"));
				product.setEnergy(RS.getInt("energy"));
				list.add(product);
				System.out.println(list);
				
				}
			}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
			}
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		return list;

	}
	 
	@GET
	@Path("/one/{par}")
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Product> listOne(@PathParam("par") String query) {
		ArrayList<Product> list=new ArrayList<>();
		Connection conn=null;
		try {
			conn=Connections.getConnection();	
			}
		catch(Exception e) { 
			System.out.println("Ei yhteyttä tietokantaan");
			}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		String test="6420256001547";
		try {
			String sql="select * from products where id=?";
			System.out.println(sql);
			System.out.println(query);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, query);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()) {
				Product product=new Product();
				product.setId(RS.getInt("id"));
				product.setProduct_id(RS.getString("product_id"));
				product.setName(RS.getString("name"));
				product.setWeight(RS.getInt("weight"));
				product.setEnergy(RS.getInt("energy"));
				list.add(product);
				System.out.println(list);
				}
			}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
			}
		
		
		return list;
		
		}
	@GET
	@Path("/oneById/{par}")
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Product> searchById(@PathParam("par") String query) {
		ArrayList<Product> list=new ArrayList<>();
		Connection conn=null;
		try {
			conn=Connections.getConnection();	
			}
		catch(Exception e) { 
			System.out.println("Ei yhteyttä tietokantaan");
			}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		String test="6420256001547";
		try {
			String sql="select * from products where product_id=?";
			System.out.println(sql);
			System.out.println(query);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, query);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()) {
				Product product=new Product();
				product.setId(RS.getInt("id"));
				product.setProduct_id(RS.getString("product_id"));
				product.setName(RS.getString("name"));
				product.setWeight(RS.getInt("weight"));
				product.setEnergy(RS.getInt("energy"));
				list.add(product);
				System.out.println(list);
				}
			}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
			}
		
		
		return list;
		
		}
	}
