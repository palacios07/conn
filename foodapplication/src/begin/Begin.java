package begin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.cloudant.client.api.Database;

import example.nosql.CloudantClientMgr;
import profile.Person;

@Path("/db/folder/")
public class Begin {

	@GET
	public Response saveData(@QueryParam("name") String name, @QueryParam("email") String email, @QueryParam("age") int age)
	{
		Person user = new Person();
		user.setName(name);
		user.setEmail(email);
		user.setAge(age);
		
		Database db=CloudantClientMgr.getDB();
		db.save(user);
		return Response.status(200).entity("Connected "+name).build();
	}
	
	
	
}
