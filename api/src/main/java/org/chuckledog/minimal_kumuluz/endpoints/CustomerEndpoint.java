package org.chuckledog.minimal_kumuluz.endpoints;

import org.chuckledog.minimal_kumuluz.beans.CustomerBean;
import org.chuckledog.minimal_kumuluz.entities.Customer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("customer")
public class CustomerEndpoint {

    @Inject
    private CustomerBean customerBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Customer> customers = customerBean.getAll();

        return Response.status(Response.Status.OK).entity(customers).build();
    }

}
