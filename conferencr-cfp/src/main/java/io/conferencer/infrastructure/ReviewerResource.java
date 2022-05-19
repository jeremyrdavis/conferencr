package io.conferencer.infrastructure;

import io.conferencer.domain.Reviewer;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/reviewers")
public class ReviewerResource {

    @POST
    @Transactional
    public Response addReviewer(final Reviewer reviewer) {

        if(Reviewer.find("email = ?1", reviewer.getEmail()).count() >= 1){
            return Response.status(Response.Status.FORBIDDEN).build();
        }else {
            reviewer.persist();
            return Response.created(URI.create("/" + reviewer.id)).entity(reviewer).build();
        }
    }

    @GET
    public Response getReviewers() {

        List<Reviewer> reviewerList = Reviewer.listAll();
        return Response.ok().entity(reviewerList).build();
    }
}
