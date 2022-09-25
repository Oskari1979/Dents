package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import conn.Connections;
import data.Product;

/**
 * Date: 
 * This is the DAO class that is responsible for accessing the databases.
 * @author Oskari Ahoniemi
 * @version 1.0
 * 
 */

@Path("/dao")
public class Dao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("DentsHarjoitus");
//	@Context
//	HttpServletRequest request;
//	@Context
//	HttpServletResponse response;
	
	/**
	 * String value for URL
	 */
	private String url;
	/**
	 * String value for database user 
	 */
	private String user;
	/**
	 * String value for database user's password
	 */
	private String pass;
	/**
	 * Connection session for the database
	 */
	
	private Connection conn;
	
	/**
	 * This is DAO constructor
	 * @param url constructor for database url
	 * @param user constructor for database user
	 * @param pass constructor for database user password
	 */
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	/**
	 * This method establishes connection to the database
	 * @return returns that connection was created if it is successful or not if it fails
	 */
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	/**
	 * This method reads all the products from the database
	 * @return returns an arraylist of products
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Product> readAllProducts() {
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
//		response.addHeader("Access-Control-Allow-Origin", "*");
		
		return list;

	}
}
