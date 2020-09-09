package org.chuckledog.minimal_kumuluz.endpoints;

import org.chuckledog.minimal_kumuluz.beans.HelloBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("hello")
public class HelloEndpoint {

    @Inject
    private HelloBean helloService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return helloService.sayHello();
    }

}
