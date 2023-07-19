package api.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.endpoints;
import api.endpoints.endpoints2;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest2 {
	Faker faker;
	user userdata;
	@BeforeClass
	public void setup()
	{
		
		faker=new Faker();
		userdata=new user();
		int id=faker.idNumber().hashCode();
		String username=faker.name().username();
		String firstname=faker.name().firstName();
		String lastName=faker.name().lastName();
		String email=faker.internet().emailAddress();
		String password=faker.internet().password(5,10);
		String phone=faker.phoneNumber().cellPhone();
		userdata.setId(id);
		userdata.setUsername(username);
		userdata.setFirstname(firstname);
		userdata.setLastname(lastName);
		userdata.setEmail(email);
		userdata.setPassword(password);
		userdata.setPhone(phone);	
	}
	@Test(priority = 1)
	public void postuser()
	{
		Response response=endpoints2.CreateUser(userdata);
		
		response.then().log().all();
	}
	@Test(priority = 2)
	public void getuser()
	{
		Response response=endpoints.getUser(this.userdata.getUsername());
		
		response.then().log().all();
	}
	@Test(priority = 3)
	public void Updateuser()
	{
		String firstname=faker.name().firstName();
		String lastName=faker.name().lastName();
		String email=faker.internet().emailAddress();
		userdata.setFirstname(firstname);
		userdata.setLastname(lastName);
		userdata.setEmail(email);
		Response response=endpoints2.Updateuser(this.userdata.getUsername(),userdata);
		response.then().log().all();
        Response responseupdated=endpoints2.getUser(this.userdata.getUsername());
		
        responseupdated.then().log().all();
		
	}
	@Test(priority = 4)
	public void Deleteuser()
	{
		Response response=endpoints2.deleteUser(this.userdata.getUsername());
		
		response.then().log().all();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
