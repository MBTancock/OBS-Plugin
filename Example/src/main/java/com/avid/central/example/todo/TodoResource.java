package com.avid.central.example.todo;

import javax.ws.rs.*;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by volodymyr.shugaiev on 7/20/2015.
 */

@Path("/todos")
@Consumes("application/json")
@Produces("application/json")
public class TodoResource{
    TodoStorage stogare = new TodoStorage();

    @GET
    @Path("/")
    public Collection<Todo> getAll () {
        return stogare.list();
    }

    @GET
    @Path("/{id}")
    public Todo get(@PathParam("id") UUID id) {
        return stogare.read(id);
    }

    @POST
    public Todo post(Todo item) {
        return stogare.create(item);
    }

    @PUT
    @Path("/{id}")
    public Todo put (@PathParam("id") UUID id, Todo item) {
        return stogare.update(id, item);
    }

    @DELETE
    @Path("/{id}")
    public Todo delete(@PathParam("id") UUID id) {
        return stogare.delete(id);
    }
}
