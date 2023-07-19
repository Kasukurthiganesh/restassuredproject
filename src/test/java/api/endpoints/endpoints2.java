package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class endpoints2 {
	
	static ResourceBundle getUrl()
	{
		ResourceBundle routes =ResourceBundle.getBundle("routes");
		return routes;
	}
	public static Response CreateUser(user payload)
	{
		String posturl=getUrl().getString("post_url");
	 Response response=given()
		.accept("application/json")
		.contentType("application/json")
		.body(payload)
		.when()
		.post(posturl);
	 return response;
		
	}
	public static Response getUser(String UserName)
	{
		String geturl=getUrl().getString("get_url");
	 Response response=given()
		.pathParam("username", UserName)
		.when()
		.get(geturl);
	 return response;
		
	}
	
	public static Response Updateuser(String Username,user payload)
	{
		String puturl=getUrl().getString("put_url");
	 Response response=given()
	    .accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", Username)
		.body(payload)
		.when()
		.put(puturl);
	 return response;
		
	}
	
	public static Response deleteUser(String UserName)
	{
		String delete=getUrl().getString("delete_url");
	 Response response=given()
		.pathParam("username", UserName)
		.when()
		.delete(delete);
	 return response;
		
	}
	
	
	
	
	

}
