package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class endpoints {
	
	
	public static Response CreateUser(user payload)
	{
	 Response response=given()
		.accept("application/json")
		.contentType("application/json")
		.body(payload)
		.when()
		.post(Routes.create_Url);
	 return response;
		
	}
	public static Response getUser(String UserName)
	{
	 Response response=given()
		.pathParam("username", UserName)
		.when()
		.get(Routes.get_Url);
	 return response;
		
	}
	
	public static Response Updateuser(String Username,user payload)
	{
	 Response response=given()
	    .accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", Username)
		.body(payload)
		.when()
		.put(Routes.update_Url);
	 return response;
		
	}
	
	public static Response deleteUser(String UserName)
	{
	 Response response=given()
		.pathParam("username", UserName)
		.when()
		.delete(Routes.delete_Url);
	 return response;
		
	}
	
	
	
	
	

}
