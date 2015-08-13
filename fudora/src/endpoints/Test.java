package endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.cloudant.client.api.Database;

import example.nosql.CloudantClientMgr;
import model.User;

@Path("/v1/save/")
public class Test {

	@GET
	@Path("get")
	public Response saveData(@QueryParam("name") String name,@QueryParam("email") String email, @QueryParam("age") int age)
	{
		User user=new User();
		user.setAge(age);
		user.setName(name);
		user.setEmail(email);
		
		Database db=CloudantClientMgr.getDB();
		db.save(user);
		return Response.status(200).entity("WElcome "+name).build();
	}
	
	@GET
	@Path("get2")
	public Response saveData(User user)
	{	
		Database db=CloudantClientMgr.getDB();
		db.save(user);
		return Response.status(200).entity("WElcome "+user.getName()).build();
	}
}
