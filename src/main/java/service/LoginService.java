package service;

import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import conn.Connections;
import data.User;
import data.Product;




//@Provider
@Path("/loginservice")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	//@CrossOrigin(origins = "http://localhost:8080")
//	 public LoginService() {
//	        super();
//	        
//	        // TODO Auto-generated constructor stub
//	    }
	
	
	@GET
	@Path("/check/{p1}/{p2}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> checkUser(@PathParam("p1") String user, @PathParam("p2") String pass)   {
//		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS");
//		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//		response.addHeader("Access-Control-Allow-Headers","Content-Type,Access-Control-Allow-Headers,X-Requested-With,Authorization");
		
		System.out.println("Tästä alkaa!");
		
//		Connection conn=null;
//		try {
//		conn=Connections.getConnection();	
//		}
//		catch(Exception e) { 
//		System.out.println("Ei yhteyttä tietokantaan");
//		}
	
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		System.out.println("UI-tunnarit user: "+user);
		System.out.println("UI-tunnarit pass: "+pass);
		
		//TÄSTÄ ALKAA SALASANAN HASH-JUPINAT
		
		
		String hashedPassword = passwordHasher(pass);
		System.out.println(hashedPassword);
		
		
		
		
		
		// TARKISTUS 
		String login=readUser(user,hashedPassword).toString();
		System.out.println("Tarkistuksen tulos ennen: "+login);
		
		
		ArrayList<String> state=new ArrayList<>();
		System.out.println("Tarkistuksen tulos jälkeen: "+state);
		state.add(login);
		
	
		return state;
		

		}
	


	
	
	public Boolean readUser(String user, String pass) {
		
		boolean result = false;
		System.out.println("Result before: "+result);
		Connection conn=null;
		try {
			conn=Connections.getConnection();
			
			}
		catch(Exception e) {}
		
		try {

			String sql="select * from users where user=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				User u = new User();
				u.setId(RS.getInt("id"));
				u.setUser(RS.getString("user"));
				u.setPass(RS.getString("pass"));
				String userDB, passDB;
				userDB = u.getUser();
				passDB = u.getPass();
				
				System.out.println("UserDB: "+userDB);
				System.out.println("PassDB: "+passDB);
			
				if(user.equals(userDB) && pass.contentEquals(passDB))
				{	
					System.out.println("Käyttäjä tunnus löytyi!");
					result=true;
					}
				else {	   	
					System.out.println("Käyttäjä tai salasna väärä!");
					}	
				}
			}
		catch(SQLException e) {
			
			
		}
		
		return result;
	}
	

	
	
public static String passwordHasher(String pass) 
{
  String passwordToHash = pass;
  String generatedPassword = null;

  try 
  {
    // Create MessageDigest instance for MD5
    MessageDigest md = MessageDigest.getInstance("MD5");

    // Add password bytes to digest
    md.update(passwordToHash.getBytes());

    // Get the hash's bytes
    byte[] bytes = md.digest();

    // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < bytes.length; i++) {
      sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    }

    // Get complete hashed password in hex format
    generatedPassword = sb.toString();
  } catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
  }
  System.out.println(generatedPassword);
  return generatedPassword;
}


}	
		