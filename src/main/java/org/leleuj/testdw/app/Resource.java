package org.leleuj.testdw.app;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import org.leleuj.testdw.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

    private static final Logger logger = LoggerFactory.getLogger(Resource.class);

    @GET
    @Timed
    @ExceptionMetered
    public Response test() {
        final int r = Util.random(20);
        if (r == 0) {
            logger.info("unfortunately not found at: " + new Date());
            return Response.status(404).build();
        } else if (r > 0 && r < 3) {
            throw new RuntimeException("failed at: " + new Date());
        } else {
            final Date now = new Date();
            logger.info("replied at: " + now);
            return Response.ok("tested at: " + now).build();
        }
    }
}
