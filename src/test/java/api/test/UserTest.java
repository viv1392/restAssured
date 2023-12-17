package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.EndPoint.*;
import api.Payload.User;
import io.restassured.response.Response;


public class UserTest {
	Faker faker;
	User userPayload;
	String username;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
	   Response response=UserEndPoint.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
			
	}
	@Test(priority=2)
	public void testreadUser() {
		Response response=UserEndPoint.readUser(this.userPayload.getUsername());
		    response.then().log().all();
		    Assert.assertEquals(response.getStatusCode(),200);
		
	}
	@Test(priority=3)
	void updateUser() {
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		Response response = UserEndPoint.updateUser(this.userPayload.getUsername(), userPayload);
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=4)
	void deleteUser() {
		Response response=UserEndPoint.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);

		
	}
	


}
