package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;


import conn.Connections;

import data.Users;



@Path("/loginservice")
public class LoginService2 {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	//@CrossOrigin(origins = "http://localhost:8080")
	
	@GET
	@Path("/check/{p1}/{p2}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Boolean loginCheck(@PathParam("p1") String user, @PathParam("p2") String pass)   {
		
		Users u= new Users();
		
		System.out.println(user);
		System.out.println(pass);
		readUsers();
		
		System.out.println(readUsers());
//		System.out.println(readUser(user, pass));
		
//		System.out.println("User: "+u.getUser());
//		System.out.println("Password: "+u.getPass());
		
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		return null;

		}
	
	

	
	public List<Users> readUsers() {
		List<Users> list = null;
		Connection conn=null;
		try {
			conn=Connections.getConnection();	
			}
		catch(Exception e) {}
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from users");
			while (RS.next()){
				Users u = new Users();
				u.setId(RS.getInt("id"));
				u.setUser(RS.getString("user"));
				u.setPass(RS.getString("pass"));
				list.add(u);
			}
			
			
			
			
//			if (user != userDB || pass != passDB) {
//				System.out.println("Samoja");
//				return true;
//			}
			
//			System.out.println("ReactUser: "+user);
//			System.out.println("ReactPass: "+pass);
		
//			System.out.println("DBUser: "+userDB);
//			System.out.println("DBPass: "+passDB);
			
//			return u;
			
//				if (user != userDB || pass != passDB) {
//					System.out.println("Samoja");
//					return true;
//				}
//				else  {
//					System.out.println("Eri tunnarit");
//				return false;
//				}
		}
		catch(SQLException e) {
			
			
		}
		return list;
	}
}

		
		