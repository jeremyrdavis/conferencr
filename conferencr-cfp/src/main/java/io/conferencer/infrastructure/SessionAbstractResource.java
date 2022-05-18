package io.conferencer.infrastructure;

import io.conferencer.domain.SessionAbstract;
import org.slf4j.Logger;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/abstracts")
@Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
public class SessionAbstractResource {

    private static final Logger LOGGER = getLogger(SessionAbstractResource.class);

    @GET
    public Response getAbstracts() {

        List<SessionAbstract> sessionAbstracts = SessionAbstract.listAll();
        return Response.ok().entity(sessionAbstracts).build();
    }
    @POST@Transactional
    public Response addAbstract(final SessionAbstract sessionAbstract) {

        LOGGER.debug("Adding {}", sessionAbstract);

        sessionAbstract.persist();
        return Response.created(URI.create("/" + sessionAbstract.id)).entity(sessionAbstract).build();
    }
}
