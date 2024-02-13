package fr.epita.assistants.presentation.rest;

import fr.epita.assistants.presentation.rest.request.ReverseRequest;
import fr.epita.assistants.presentation.rest.response.HelloResponse;
import fr.epita.assistants.presentation.rest.response.ReverseResponse;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Endpoints {
    @Path("/hello/{name}")
    @GET
    public HelloResponse hello(@PathParam("name") String name) {
        if (name == null || name.equals(""))
            throw new BadRequestException("string is null or empty");
        return new HelloResponse(name);
    }

    @Path("/reverse")
    @POST
    public ReverseResponse reverse(ReverseRequest req) {
        if (req == null || req.content == null || req.content.equals(""))
            throw new BadRequestException("body is null or content is empty");
        return new ReverseResponse(req.content);
    }
}
