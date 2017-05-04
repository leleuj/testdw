package org.leleuj.testdw;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

    @GET
    @Timed
    @ExceptionMetered
    public String test() {
        return "test : " + new Date();
    }
}
