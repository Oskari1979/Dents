//package service;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.Path;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Invocation.Builder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.GenericType;
//
//import dao.Dao;
//import data.Product;
//
//
//
//
///**
// * Servlet implementation class ListAllQuestionsRest
// */
//
//@Path("/listallproducts")
//public class ListAllProducts extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	@Context
//	HttpServletRequest request;
//	@Context
//	HttpServletResponse response;
//	//@CrossOrigin(origins = "http://localhost:8080")
//	
//
//	 public ListAllProducts() {
//	        super();
//	        // TODO Auto-generated constructor stub
//	    }
//	 
//	 
//	 /*
//	  * If the request type is POST, the request is transferred to the method doGet
//	  */
//	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
//		      throws IOException, ServletException {
//		  doGet(request, response);}
//		  
//	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			// TODO Auto-generated method stub		
//			List<Product> list=null;
//			System.out.println(request);
//			list=readProducts(request);
//			
//			
//			response.addHeader("Access-Control-Allow-Origin", "*");
//			response.addHeader("name", "Oskari");
//			request.setAttribute("productlist", list);
//			RequestDispatcher rd=request.getRequestDispatcher("./jsp/showproductlist.jsp");
//			rd.forward(request, response);
//			
//			
//			
//		}
//	 
//	 private List<Product> readProducts(HttpServletRequest request) {
//		 String uri="http://127.0.0.1:8080/rest/service/all";
//		 Client c=ClientBuilder.newClient();
//		 WebTarget wt=c.target(uri);
//		 Builder b=wt.request();
//			//Create a GenericType to be able to get List of objects
//			//This will be the second parameter of post method
//		 GenericType<List<Product>> genericList = new GenericType<List<Product>>() {};		
//		 List<Product> returnedList=b.get(genericList);
//		 return returnedList;
//	 }
//	 
//}
