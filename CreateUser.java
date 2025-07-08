package Day8;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import  org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test()
	
	void createuser(ITestContext  context)
	{
		int id;
		Faker faker=new Faker();
		
		
		JSONObject data = new JSONObject();
		
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		
		
		String bearerToken ="7e4583986bf739f3ed5d1b2addd3099123c7d754efc533e20a5a7566d26f82cc";
		
id=	given()

.headers("Authorization","Bearer " + bearerToken)
.contentType("application/json")
.body(data.toString())
		
		.when()
		
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");

         System.out.println("Generated ID" +id);
		
		context.setAttribute("user_id", id);
		
		
	}

}
