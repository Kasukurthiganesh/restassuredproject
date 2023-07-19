package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.endpoints2;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTesting {
	

	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class )
	public void testPostuser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		user userdata=new user();
		
		userdata.setId(Integer.parseInt(userID));
		userdata.setUsername(userName);
		userdata.setFirstname(fname);
		userdata.setLastname(lname);
		userdata.setEmail(useremail);
		userdata.setPassword(pwd);
		userdata.setPhone(ph);
		
		Response response=endpoints2.CreateUser(userdata);
		Assert.assertEquals(response.getStatusCode(),200);
			
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
			Response response=endpoints2.deleteUser(userName);
			Assert.assertEquals(response.getStatusCode(),200);	
	
	}
	
	
	
	
	
	
	
	
	

}
