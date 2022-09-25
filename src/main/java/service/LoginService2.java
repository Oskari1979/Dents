//package service;
//
//import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import java.security.spec.InvalidKeySpecException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.ws.rs.Consumes;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//
//
//
//
//import conn.Connections;
//
//import data.Users;
//
//
//
//
//@Path("/loginservice2")
//public class LoginService2  {
//	
//	@Context
//	HttpServletRequest request;
//	@Context
//	HttpServletResponse response;
//	//@CrossOrigin(origins = "http://localhost:8080")
//	
//	 public LoginService2() {
//	        super();
//	        // TODO Auto-generated constructor stub
//	    }
//	@Path("/check2")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void checkUser(String user, String pass)   
//	{
//	
//		// HttpSession session = request.getSession();
//		response.setContentType("text/html");
//	    response.setCharacterEncoding("UTF-8");
//	       
//	    System.out.println("UI-tunnarit: "+user);
//	    System.out.println("UI-tunnarit: "+pass);
//	    
//	    
////		System.out.println("UI-tunnarit: "+user.getUser());
////		System.out.println("UI-tunnarit: "+user.getPass());
////		
////		String userUI = user.getUser();
////		String passUI = user.getPass();
////		System.out.println("UI-tunnarit: "+user);
////		System.out.println("UI-tunnarit: "+userUI);
////		System.out.println("UI-tunnarit: "+passUI);
//		
//		
//		
//		//TÄSTÄ ALKAA SALASANAN HASH-JUPINAT
//		
//		
//		String hashedPassword = passwordHasher(pass);
//		System.out.println(hashedPassword);
//		
//		
//		
//		
//		
//		// TARKISTUS 
//		String login=readUser(user,hashedPassword).toString();
//		System.out.println("Tarkistuksen tulos: "+login);
//		
//		
//		
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Headers", "*");
//		//response.setHeader("Access-Control-Allow-Credentials", true);
//		response.addHeader("boolean", "true" );
//		// System.out.println("Result: "+login);
//		//return login;
//
//		}
//	
//	private Boolean readUser(String user, String pass) {
//		
//		boolean result = false;
//		System.out.println("Result before: "+result);
//		Connection conn=null;
//		try {
//			conn=Connections.getConnection();
//			
//			}
//		catch(Exception e) {}
//		
//		try {
//
//			String sql="select * from users where user=?";
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, user);
//			ResultSet RS=pstmt.executeQuery();
//			while (RS.next()){
//				Users u = new Users();
//				u.setId(RS.getInt("id"));
//				u.setUser(RS.getString("user"));
//				u.setPass(RS.getString("pass"));
//				String userDB, passDB;
//				userDB = u.getUser();
//				passDB = u.getPass();
//				
//				System.out.println("UserDB: "+userDB);
//				System.out.println("PassDB: "+passDB);
//			
//				if(user.equals(userDB) && pass.contentEquals(passDB))
//				{	
//					System.out.println("Käyttäjä tunnus löytyi!");
//					result=true;
//					}
//				else {	   	
//					System.out.println("Käyttäjä tai salasna väärä!");
//					}	
//				}
//			}
//		catch(SQLException e) {
//			
//			
//		}
//		System.out.println("Result: "+result);
//		return result;
//	}
//	
//
//	
//	
//private static String passwordHasher(String pass) 
//{
//  String passwordToHash = pass;
//  String generatedPassword = null;
//
//  try 
//  {
//    // Create MessageDigest instance for MD5
//    MessageDigest md = MessageDigest.getInstance("MD5");
//
//    // Add password bytes to digest
//    md.update(passwordToHash.getBytes());
//
//    // Get the hash's bytes
//    byte[] bytes = md.digest();
//
//    // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < bytes.length; i++) {
//      sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//    }
//
//    // 
//    generatedPassword = sb.toString();
//  } catch (NoSuchAlgorithmException e) {
//    e.printStackTrace();
//  }
//  System.out.println(generatedPassword);
//  return generatedPassword;
//}
//
//
//}	
//		